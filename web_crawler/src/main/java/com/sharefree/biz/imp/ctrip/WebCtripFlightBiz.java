package com.sharefree.biz.imp.ctrip;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.alibaba.fastjson.JSON;
import com.sharefree.base.constant.WebCtripConsts;
import com.sharefree.biz.itf.ctrip.IWebCtripFlightBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.ctrip.CtripQueryFlightModel;
import com.sharefree.model.ctrip.PlaneODModel;
import com.sharefree.model.ctrip.WebClickModel;
import com.sharefree.model.ctrip.WebProductDetailModel;
import com.sharefree.model.ctrip.WebQueryFlightModel;
import com.sharefree.model.ctrip.WebTripModel;
import com.sharefree.service.itf.IRedisService;
import com.sharefree.service.itf.ISystemService;
import com.sharefree.service.itf.ctrip.IWebClickService;
import com.sharefree.service.itf.ctrip.IWebProductDetailService;
import com.sharefree.service.itf.ctrip.IWebProductService;
import com.sharefree.service.itf.ctrip.IWebQueryFlightService;
import com.sharefree.service.itf.ctrip.IWebTripService;
import com.sharefree.utils.DateUtil;
import com.sharefree.utils.StringUtil;

/**
 * 
 * Title: PlaneCtripService
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 17, 2016
 *
 */
@IocBean
public class WebCtripFlightBiz implements IWebCtripFlightBiz {

	@Inject
	private IWebQueryFlightService webQueryFlightService;
	@Inject
	private IWebTripService webTripService;
	@Inject
	private IWebProductService webProductService;
	@Inject
	private IWebProductDetailService webProductDetailService;
	@Inject
	private IWebClickService webClickService;
	@Inject
	private ISystemService systemService;
	@Inject
	private IRedisService redisService;
	
	
	@Override
	public Map<String, Object> shopping(CtripQueryFlightModel cqfm) {
		// 定义返回信息
		Map<String, Object> result = new HashMap<String, Object>();
		// 定义查询回航班数据
		List<WebTripModel> wtms = new ArrayList<WebTripModel>();
		try {
			// 验证必要数据：
			// 行程类型（单程:1，往返:2，多程:3）
			String tripType = cqfm.getTripType();
			if (StringUtil.isEmpty(tripType))
				throw new CommonException("缺少参数[行程类型：tripType]");
			// 行程序列
			Integer tripSequence = cqfm.getTripSequence();
			if (tripSequence == null)
				throw new CommonException("缺少参数[行程序列：tripSequence]");
			// 异步查询token
			Integer asyncToken = cqfm.getAsyncToken();
			// 点击类型
			String clickType = cqfm.getClickType();
			// 是否已存在点击任务
			if(asyncToken == null){
				// 新建查询任务
				if(WebCtripConsts.CLICK_NEW_QUERY_FLIGHT.equals(clickType)){
					// 航班类型（国内:1，国际:2）
					String flightType = cqfm.getFlightType();
					if (StringUtil.isEmpty(flightType))
						throw new CommonException("缺少参数[航班类型：flightType]");
					// 行程信息：
					List<PlaneODModel> podms = cqfm.getPodms();
					if(podms == null || podms.size() < 1)
						throw new CommonException("缺少参数[行程信息：podms]");
					// 定义行程信息：
					// 定义行程三字码
					String tripCode = null;
					// 定义行程日期
					String tripDate = null;
					for(PlaneODModel podm : podms){
						// 出发城市三字码
						String departCityCode = podm.getDepartCityCode();
						if (StringUtil.isEmpty(departCityCode))
							throw new CommonException("缺少参数[出发城市三字码：departCityCode]");
						if(WebCtripConsts.TRIP_TYPE_ROUND_FREE_COLLOCATION.equals(tripType)){
							tripCode = tripCode == null ? departCityCode : tripCode;
						}else{
							tripCode = tripCode == null ? departCityCode : tripCode + "/" + departCityCode;
						}
						
						// 到达城市三字码
						String arriveCityCode = podm.getArriveCityCode();
						if (StringUtil.isEmpty(arriveCityCode))
							throw new CommonException("缺少参数[到达城市三字码：arriveCityCode]");
						if(WebCtripConsts.TRIP_TYPE_ROUND_FREE_COLLOCATION.equals(tripType)){
							tripCode = tripCode.indexOf("~") != -1 ? tripCode : tripCode + "~" + arriveCityCode;
						}else{
							tripCode += "~" + arriveCityCode;
						}
						
						// 出发日期
						String departTime = DateUtil.parseDateToString(podm.getDepartTime(), DateUtil.FORMAT1);
						if (StringUtil.isEmpty(departTime))
							throw new CommonException("缺少参数[出发日期：departTime]");
						tripDate = tripDate == null ? departTime : tripDate + "/" + departTime;
					}
					// 获取数据库系统时间
					Date systemDate = systemService.getTime();
					// 定义查询航班请求数据
					WebQueryFlightModel wqfm = new WebQueryFlightModel(
							systemDate, WebCtripConsts.FLIGHT_QUERY_TASK_TYPE, WebCtripConsts.FLIGHT_QUERY_DATASOURCE,
							flightType, tripType, tripCode, tripDate,
							cqfm.getAirlinecode(), cqfm.getCabinclass(),
							cqfm.getAdtNum(), cqfm.getChdNum(),
							cqfm.getInfNum(),
							WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
					// 添加查询航班请求
					wqfm = webQueryFlightService.insert(wqfm);
					// 规范数据
					cqfm.setTaskId(wqfm.getTaskid());
					cqfm.setTripSequence(1);
					// 新建点击任务
					clickMapper(cqfm);
					// 设置返回token
					result.put(WebCtripConsts.CTRIP_PROCESS_TOKEN, cqfm.getAsyncToken());
					// 设置完成状态
					result.put(WebCtripConsts.CTRIP_PROCESS_STATUS, WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
				}else{
					throw new CommonException("缺少参数[异步查询token：asyncToken]");
				}
			}else{
				// 验证点击任务状态
				WebClickModel wcm = webClickService.fetch(asyncToken);
				if(wcm == null)
					throw new CommonException("不存在点击任务");
				// 任务Id
				Integer taskId = wcm.getTaskid();
				// 规范数据
				cqfm.setTaskId(taskId);
				// 验证是否为点击任务:
				if(StringUtil.isEmpty(clickType)){
					// 获取任务状态
					Integer status = wcm.getStatus();
					if(status != null){
						// 查询失败
						if(status == WebCtripConsts.CTRIP_PROCESS_STATUS_ERROR){
							throw new CommonException("CTRIP国际航班查询失败");
						}
						if(status != WebCtripConsts.CTRIP_PROCESS_STATUS_INIT){
							// 定义查询条件参数
							WebTripModel wtmQ = new WebTripModel();
							// 同点击任务的航班数据属于同一程
							wtmQ.setClickid(asyncToken);
							// 设置行程
							wtmQ.setTripsequence(tripSequence);
							// 排除已查询数据
							List<Integer> excludeTripid = pullIncr(taskId, tripSequence);
							wtmQ.setExcludeTripid(excludeTripid);
							// 获取增量数据
							wtms = webTripService.queryFlights(wtmQ);
							if(wtms != null && wtms.size() > 0){
								// 定义缓存增量数据
								List<Integer> tripIdList = new ArrayList<Integer>();
								// 遍历航班数据，获取产品数据
								for(WebTripModel wtm : wtms){
									// 行程id
									Integer tripId = wtm.getTripid();
									tripIdList.add(tripId);
								}
								// 缓存增量数据
								pushIncr(taskId, tripSequence, tripIdList);
							}
						}
						// 设置返回token
						result.put(WebCtripConsts.CTRIP_PROCESS_TOKEN, asyncToken);
						// 设置点击任务完成状态
						result.put(WebCtripConsts.CTRIP_PROCESS_STATUS, status);
					}
				}else{
					// 新建点击任务
					clickMapper(cqfm);
					// 设置返回token
					result.put(WebCtripConsts.CTRIP_PROCESS_TOKEN, cqfm.getAsyncToken());
					// 设置完成状态
					result.put(WebCtripConsts.CTRIP_PROCESS_STATUS, WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
				}
			}
			// 设置返回data
			result.put(WebCtripConsts.CTRIP_PROCESS_DATA, wtms);
			
		} catch (CommonException e) {
			throw e;
		} catch (Exception e) {
			throw new CommonException("CTRIP国际航班查询错误", e);
		}
		// 返回结果
		return result;
	}

	@Override
	public Map<String, Object> check(CtripQueryFlightModel cqfm) {
		// 定义返回信息
		Map<String, Object> result = new HashMap<String, Object>();
		// 定义核价返回数据
		WebProductDetailModel wpdm = null;
		try {
			// 验证必要数据：
			// 行程类型（单程:1，往返:2，多程:3）
			String tripType = cqfm.getTripType();
			if (StringUtil.isEmpty(tripType))
				throw new CommonException("缺少参数[行程类型：tripType]");
			// 行程序列
			Integer tripSequence = cqfm.getTripSequence();
			if (tripSequence == null)
				throw new CommonException("缺少参数[行程序列：tripSequence]");
			// 异步核价token
			Integer asyncToken = cqfm.getAsyncToken();
			if (asyncToken == null)
				throw new CommonException("缺少参数[异步核价token：asyncToken]");
			// 点击类型
			String clickType = cqfm.getClickType();
			
			// 验证点击任务状态
			WebClickModel wcm = webClickService.fetch(asyncToken);
			if(wcm == null)
				throw new CommonException("不存在点击任务");
			// 规范数据
			cqfm.setTaskId(wcm.getTaskid());
			// 验证是否为点击任务:
			if(StringUtil.isEmpty(clickType)){
				// 获取任务状态
				Integer status = wcm.getStatus();
				// 核价任务状态
				if(status != null){
					// 核价完成
					if(status == WebCtripConsts.CTRIP_PROCESS_STATUS_FINISH){
						// 定义查询条件参数
						WebProductDetailModel wpdmQ = new WebProductDetailModel();
						// 根据产品id获取核价信息
						wpdmQ.setProductid(wcm.getProductid());
						List<WebProductDetailModel> wpdmsQ = webProductDetailService.query(wpdmQ);
						// 获取核价信息
						if(wpdmsQ != null && wpdmsQ.size() > 0){
							// 默认核价只有一条数据
							wpdm = wpdmsQ.get(0);
						}
					}
					// 核价失败
					else if(status == WebCtripConsts.CTRIP_PROCESS_STATUS_ERROR){
						throw new CommonException("CTRIP国际航班核价失败");
					}
				}
				// 设置返回token
				result.put(WebCtripConsts.CTRIP_PROCESS_TOKEN, asyncToken);
				// 设置点击任务完成状态
				result.put(WebCtripConsts.CTRIP_PROCESS_STATUS, status);
			}else{
				// 判断是否重复请求，避免增加爬虫服务器压力，不允许重复请求
				WebClickModel wcmQ = new WebClickModel();
				wcmQ.setClicktype(cqfm.getClickType());
				wcmQ.setTaskid(cqfm.getTaskId());
				wcmQ.setTripsequence(cqfm.getTripSequence());
				wcmQ.setProductid(cqfm.getProductId());
				List<WebClickModel> wcms = webClickService.query(wcmQ);
				if(wcms != null && wcms.size() > 0){
					wcmQ = wcms.get(0);
					// 设置异步查询token
					cqfm.setAsyncToken(wcmQ.getClickid());
				}else{
					// 新建点击任务
					clickMapper(cqfm);
				}
				// 设置返回token
				result.put(WebCtripConsts.CTRIP_PROCESS_TOKEN, cqfm.getAsyncToken());
				// 设置完成状态
				result.put(WebCtripConsts.CTRIP_PROCESS_STATUS, WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
			}
			// 设置返回data
			result.put(WebCtripConsts.CTRIP_PROCESS_DATA, wpdm);
			
		} catch (CommonException e) {
			throw e;
		} catch (Exception e) {
			throw new CommonException("CTRIP国际航班核价错误", e);
		}
		// 返回结果
		return result;
	}
	
	/**
	 * 点击任务适配生成器<br/>
	 * 
	 * 1. 点击任务类型：<br/>
	 * 新建查询：1<br/>
	 * 下一程：2<br/>
	 * 修改行程：3<br/>
	 * 核价：4<br/>
	 * 
	 * 2. 点击任务适配行程类型<br/>
	 * 单程：1、4<br/>
	 * 多程：1、2、3、4<br/>
	 * <br/>
	 * 
	 * 注：往返进行2、3点击时不新建任务<br/>
	 * 
	 * @param cqfm
	 */
	private void clickMapper(CtripQueryFlightModel cqfm){
		// 验证必要数据：
	    // 点击类型
	    String clickType = cqfm.getClickType();
		if (StringUtil.isEmpty(clickType))
			throw new CommonException("缺少参数[点击类型：clickType]");
		// 请求id
		Integer taskId = cqfm.getTaskId();
		if (taskId == null)
			throw new CommonException("缺少参数[请求id：taskId]");
		// 行程序列
		Integer tripSequence = cqfm.getTripSequence();
		if (tripSequence == null)
			throw new CommonException("缺少参数[行程序列：tripSequence]");
		// 定义待添加的点击任务对象
		WebClickModel wcm = null;
		
		// 根据点击类型生成对象：
		// 新建查询
		if(WebCtripConsts.CLICK_NEW_QUERY_FLIGHT.equals(clickType)){
			if(tripSequence != 1)
				throw new CommonException("新建查询行程序列必须为1：tripSequence=1");
			wcm = new WebClickModel(clickType, taskId, WebCtripConsts.FLIGHT_QUERY_TASK_TYPE, tripSequence, null, null, WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
		}
		
		// 下一程
		else if(WebCtripConsts.CLICK_QUERY_NEXT_TRIP.equals(clickType)){
			if(tripSequence < 2)
				throw new CommonException("多程航班查询，下一程序列大于1：tripSequence > 1");
			Integer productId = cqfm.getProductId();
			if(productId == null)
				throw new CommonException("缺少参数[产品id：productId]");
			wcm = new WebClickModel(clickType, taskId, WebCtripConsts.FLIGHT_QUERY_TASK_TYPE, tripSequence, null, productId, WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
		}
		
		// 修改行程
		else if(WebCtripConsts.CLICK_MODIFY_TRIP.equals(clickType)){
			wcm = new WebClickModel(clickType, taskId, WebCtripConsts.FLIGHT_QUERY_TASK_TYPE, tripSequence, null, null, WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
		}
		
		// 核价
		else if(WebCtripConsts.CLICK_CHECK_PRODUCT.equals(clickType)){
			Integer productId = cqfm.getProductId();
			if(productId == null)
				throw new CommonException("缺少参数[产品id：productId]");
			wcm = new WebClickModel(clickType, taskId, WebCtripConsts.FLIGHT_QUERY_TASK_TYPE, tripSequence, null, productId, WebCtripConsts.CTRIP_PROCESS_STATUS_INIT);
		}
		
		// 其他抛出异常
		else{
			throw new CommonException("不存在点击类型：clickType = " + clickType);
		}
		// 添加点击任务
		if(wcm != null){
			wcm = webClickService.insert(wcm);
			// 设置异步查询token
			cqfm.setAsyncToken(wcm.getClickid());
		}
		// 删除冗余数据
		delIncr(taskId);
	}

	/**
	 * 根据key获取航班查询（携程爬虫）增量数据缓存
	 * 
	 * @param taskId
	 * @param tripSequence
	 * @return
	 */
	private List<Integer> pullIncr(Integer taskId, Integer tripSequence){
		// 设置缓存key
		String key = WebCtripConsts.REDIS_KEY_FLIGHT_INTER_INCR_CACHE + ":" + taskId.toString() + ":" + tripSequence.toString();
		// 定义返回结果集
		List<Integer> incrValues = null;
		String incrValue = redisService.get(key);
		if(StringUtil.isNotEmpty(incrValue)){
			// 存在
			incrValues = JSON.parseArray(incrValue, Integer.class);
		}
		// 返回结果集
		return incrValues;
	}

	/**
	 * 根据key删除航班查询（携程爬虫）增量数据缓存
	 * 
	 * @param taskId
	 */
	private void delIncr(Integer taskId){
		// 设置缓存key
		String key = WebCtripConsts.REDIS_KEY_FLIGHT_INTER_INCR_CACHE + ":" + taskId.toString() + ":*";
		// 删除
		Set<String> keys = redisService.keys(key);
		if(keys != null && keys.size() > 0){
			for(String keyE : keys){
				redisService.del(keyE);
			}
		}
	}

	/**
	 * 根据key添加航班查询（携程爬虫）增量数据缓存
	 * 
	 * @param taskId
	 * @param tripSequence
	 * @param tripIdList
	 */
	private void pushIncr(Integer taskId, Integer tripSequence, List<Integer> tripIdList){
		// 设置缓存key
		String key = WebCtripConsts.REDIS_KEY_FLIGHT_INTER_INCR_CACHE + ":" + taskId.toString() + ":" + tripSequence.toString();
		// 判断是否存在增量数据
		String incrValue = redisService.get(key);
		if(StringUtil.isEmpty(incrValue)){
			// 不存在
			incrValue = JSON.toJSONString(tripIdList);
		}else{
			// 存在
			List<Integer> incrValues = JSON.parseArray(incrValue, Integer.class);
			// 将新增且不重复数据添加到缓存
			for(Integer value : tripIdList){
				// 不重复的新增
				if(!incrValues.contains(value)){
					incrValues.add(value);
				}
			}
			incrValue = JSON.toJSONString(incrValues);
		}
		// 缓存新数据
		redisService.setEx(key, incrValue, WebCtripConsts.FLIGHT_INCR_CACHE_TIMELINESS);
	}
	
}
