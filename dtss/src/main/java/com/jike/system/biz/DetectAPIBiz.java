package com.jike.system.biz;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.biz.itf.IDetectAPIBiz;
import com.jike.system.consts.APIConsts;
import com.jike.system.core.QuartzManager;
import com.jike.system.model.DetectAPIConfigModel;
import com.jike.system.model.DetectAPIModel;
import com.jike.system.quartz.DetectAPIJob;
import com.jike.system.service.itf.IDetectAPIService;
import com.jike.system.util.BeanUtils;
import com.jike.system.util.CityUtils;
import com.jike.system.util.DateUtils;
import com.jike.system.util.HttpClientUtil;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;

/**
 * Title: DetectAPIBiz
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 6, 2015
 *
 */
@Service("detectAPIBiz")
@Transactional
public class DetectAPIBiz implements IDetectAPIBiz {

	private static Logger log = LoggerFactory.getLogger(DetectAPIBiz.class);

	@Autowired
	private IDetectAPIService detectAPIService;

	@Override
	public DetectAPIConfigModel configStrategy(DetectAPIConfigModel dapicm)
			throws CommonException {
		BeanUtils.copyWithoutNullProperties(dapicm, APIConsts.DETECT_API_CONFIG);
		return APIConsts.DETECT_API_CONFIG;
	}

	@Override
	public void startTask(DetectAPIModel dapim) throws CommonException {
		int requestSpeed = APIConsts.REQUEST_SPEED;
		if(dapim.getRequestSpeed() != null){
			if(dapim.getRequestSpeed() > 2){
				requestSpeed = dapim.getRequestSpeed();
			}else{
				throw new CommonException("请求速度不可低于3秒");
			}
		}
		if(QuartzManager.vaildateTriggerExist(APIConsts.TRIGGER_NAME, APIConsts.TRIGGERGROUP_NAME)){
			QuartzManager.removeJob(APIConsts.JOB_NAME, APIConsts.JOBGROUP_NAME, APIConsts.TRIGGER_NAME, APIConsts.TRIGGERGROUP_NAME, null);
		}else{
			QuartzManager.addSimpleJob(APIConsts.JOB_NAME, APIConsts.JOBGROUP_NAME, APIConsts.TRIGGER_NAME, APIConsts.TRIGGERGROUP_NAME, 
					DetectAPIJob.class, null, null, SimpleTrigger.REPEAT_INDEFINITELY, requestSpeed, null);
		}
	}

	@Override
	public void stopTask() throws CommonException {
		if(QuartzManager.vaildateTriggerExist(APIConsts.TRIGGER_NAME, APIConsts.TRIGGERGROUP_NAME)){
			QuartzManager.removeJob(APIConsts.JOB_NAME, APIConsts.JOBGROUP_NAME, APIConsts.TRIGGER_NAME, APIConsts.TRIGGERGROUP_NAME, null);
		}
	}

	@Override
	public void execute() throws CommonException {
		DetectAPIModel dapim = new DetectAPIModel();
		// 随机获取国内城市三字码（不同城市）
		String[] cityCodes = CityUtils.getTripByStrategy();
		dapim.setDepartCode(cityCodes[0]);
		dapim.setArriveCode(cityCodes[1]);
        // 今天日期
        Date today = new Date();
        // 未来哪一天的航班 new Random().netInt(max - min) + min
		Integer futureDate = new Random(today.getTime())
				.nextInt(APIConsts.DETECT_API_CONFIG.getFutureEndDate()
						- APIConsts.DETECT_API_CONFIG.getFutureStartDate())
				+ APIConsts.DETECT_API_CONFIG.getFutureStartDate();
		dapim.setDepartDate(DateUtils.addDays(today, futureDate));
		dapim.setTaskId(DateUtils.formatSFullDate(today));
		dapim.setTaskRunTime(today);
		shopping(dapim);
		log.info("记录数据："+dapim.toString());
		detectAPIService.insert(dapim);
	}

	@Override
	public List<DetectAPIModel> selectByExample(DetectAPIModel dapim)
			throws CommonException {
		return detectAPIService.selectByExample(dapim);
	}

	@Override
	public int countByExample(DetectAPIModel dapim) throws CommonException {
		return detectAPIService.countByExample(dapim);
	}
	
	/**
	 * 创建请求包头部<br>
	 * 请求人
	 * 
	 * @param ele
	 * @return
	 */
	private Element createpos(Element ele) {
		Element pos = ele.addElement("POS");
		Element requestors = pos.addElement("Requestors");
		Element requestor = requestors.addElement("Requestor");
		requestor.addAttribute("Type", "13");
		requestor.addAttribute("Password", "EDF41FC103CDF6D4F7BA1390296AD6BF");
		requestor.addAttribute("ID", "suzhoujike");

		return pos;
	}

	public DetectAPIModel shopping(DetectAPIModel dapim) throws CommonException {

		//Http请求接收返回对象
		Map<String, Object> respObject = null;
		// 返回完全标识
		String finFlag = null;
		// 返回的token
		String tokenValue = null;
		// 结束请求处理标识（超时）
		Boolean endFlag = false;
		// 定义返回信息
		Element pricedItineraries = null;
		// 设置同步查询超时时间
		Long timeOut = APIConsts.DETECT_API_CONFIG.getTimeOut();
		// 设置起始时间
		Long startTime = new Date().getTime();
		// 请求返回完全耗时
		Long timeCost = 0L;
		// 获取Http请求返回值
		String querydataXML = null;

		try {
			Document document = DocumentHelper.createDocument(); // 创建文档
			Element otaRQ = document.addElement("OTA_AirFareSearchRQ");
			otaRQ.addAttribute("encoding", "UTF-8");
			Element pos = createpos(otaRQ);
			// <Source Code="QUNAR"/>
			pos.addElement("Source").addAttribute("Code", "CTRIP");
			// <Token Code="82F6356DEE6CCB85265E6069A3D32DA3"/>
			Element token = pos.addElement("Token");
			token.addAttribute("Code", "");
			Element originDestinationInformation = otaRQ
					.addElement("OriginDestinationInformation");
			originDestinationInformation.addAttribute("RefNumber", "1");
			originDestinationInformation.addElement("DepartureDateTime").setText(
					DateUtils.formatDayDate(dapim.getDepartDate()));
			Element originLocation = originDestinationInformation
					.addElement("OriginLocation");
			originLocation.addAttribute("LocationCode", dapim.getDepartCode());
			originLocation.addAttribute("MultiAirportCityInd", "true");

			Element destinationLocation = originDestinationInformation
					.addElement("DestinationLocation");
			destinationLocation
					.addAttribute("LocationCode", dapim.getArriveCode());
			destinationLocation.addAttribute("MultiAirportCityInd", "true");
			
			while(!"T".equals(finFlag)){
				String requestXML = document.asXML();
				try {
					// POST请求
					respObject = HttpClientUtil.sendPostRequest(
							APIConsts.CTRIP_URL, requestXML, null,
							APIConsts.REQUEST_ENCODECHARSET,
							APIConsts.DETECT_API_CONFIG.getConnectTimeOut(),
							APIConsts.DETECT_API_CONFIG.getSocketTimeOut());
					// 获取Http请求返回值
					querydataXML = (String) respObject.get(HttpClientUtil.RESPONSE_CONTENT);

					Element otaRS = StringUtil.analyzeRootElement(querydataXML);
					// 获取token值
					if(StringUtil.isEmpty(tokenValue))
						tokenValue = otaRS.element("Token").attributeValue("Code");
					// 是否有错误信息
					Element Fail = otaRS.element("Fail");
					if (Fail != null) {
						String code = Fail.attributeValue("Code");
						if("63000".equals(code)){
							 // 异常 数据缺失		 	   Fail != null Code = "63000" ErrMsg = "DATA ERROR!"
							dapim.setResultType(APIConsts.RESULT_TYPE_DATA_ERROR);
						}else if("81000".equals(code)){
							// 异常 没有数据		 	   Fail != null Code = "81000" ErrMsg = "SYSTEM IS BUSY!"
							dapim.setResultType(APIConsts.RESULT_TYPE_SYSTEM_BUSY);
						}else{
							// 异常 其它
							dapim.setResultType(APIConsts.RESULT_TYPE_EXCEPTION);
						}
					}
					// Token设置
					token.addAttribute("Code", tokenValue);
					pricedItineraries = otaRS.element("PricedItineraries");
					finFlag = pricedItineraries.attributeValue("FinFlag");
				} catch (CommonException e) {
					// 验证是否超时
					if(HttpClientUtil.SO_TO.equals(e)){
						dapim.setResultType(APIConsts.RESULT_TYPE_SOCKET_ERROR);
						endFlag = true;
						break;
					}else if(HttpClientUtil.CONN_TO.equals(e)){
						// 继续执行
					}
				}
				
				// 执行此次查询后共用时
				timeCost = new Date().getTime() - startTime;
				// 验证是否超时
				if(timeCost > timeOut){
					// 正常 采集未完成(超时) 	   Fail = null FinFlag = "F"
					dapim.setResultType(APIConsts.RESULT_TYPE_TIME_OUT);
					endFlag = true;
					break;
				}else{
					continue;
				}
			}
			// 如果不超时
			if(!endFlag){
				@SuppressWarnings("unchecked")
				List<Element> pricedItinerarys = pricedItineraries.elements("PricedItinerary");
				if(pricedItinerarys != null&&pricedItinerarys.size() > 0){
					// 正常 有数据且完全返回     Fail = null FinFlag = "T"
					dapim.setResultType(APIConsts.RESULT_TYPE_FULL_SUCCESS);
				}else{
					// 正常 完全返回却无数据     Fail = null FinFlag = "T"
					dapim.setResultType(APIConsts.RESULT_TYPE_EMPTY_DATA);
				}
			}
		} catch (Exception e) {
			// 异常 其它
			dapim.setResultType(APIConsts.RESULT_TYPE_EXCEPTION);
		}
		// 记录查询花费时间
		dapim.setTaskTimeCost(timeCost);
		// 记录token值
		dapim.setToken(tokenValue);
		return dapim;
	}

}
