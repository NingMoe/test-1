package com.sharefree.constant;

import org.nutz.dao.entity.annotation.Comment;

public class DisneyConst {

	// 游客订单状态
	public static final String TOURIST_ORDER_STATUS_CANCEL = "0"; // 已取消
	public static final String TOURIST_ORDER_STATUS_UNTICKET = "1"; // 未出票
	public static final String TOURIST_ORDER_STATUS_TICKETING = "2"; // 部分出票
	public static final String TOURIST_ORDER_STATUS_TICKETED = "3"; // 已出票
	public static final String TOURIST_ORDER_STATUS_OK = "9"; // 正常

	// 游客订单编号头部信息
	public static final String TOURIST_ORDER_ORDER_NO_HEAD = "DT"; // 迪斯尼门票

	// 游客订单所属客户名称
	public static final String TOURIST_ORDER_CUSTOMER_NAME_INIT = "系统占位（此名称可修改）";

	// 游客明细状态
	public static final String TOURIST_DETAIL_STATUS_CANCEL = "0"; // 已取消
	public static final String TOURIST_DETAIL_STATUS_OK = "1"; // 正常

	// 游客门票状态
	public static final String TOURIST_TICKET_STATUS_CANCEL = "0"; // 已取消
	public static final String TOURIST_TICKET_STATUS_PAYED = "1"; // 已支付
	public static final String TOURIST_TICKET_STATUS_TICKETED = "2"; // 已出票

	// 占位使用状态
	public static final String OCCUPY_DETAIL_STATUS_CANCEL = "0"; // 已取消
	public static final String OCCUPY_DETAIL_STATUS_UNUSE = "1"; // 待使用
	public static final String OCCUPY_DETAIL_STATUS_CANCEL_ORDER_ERROR = "2"; // 订单取消异常
	public static final String OCCUPY_DETAIL_STATUS_CANCEL_PNR_ERROR = "3"; // PNR取消异常

	// 证件类型
	public static String IDC_TYPE_IDENTITYCARD = "1"; // 身份证
	public static String IDC_TYPE_PASSPORT = "2"; // 护照
	public static String IDC_TYPE_GANGAOTONGXING = "3"; // 港澳通行证
	public static String IDC_TYPE_TAIWANTONGXING = "4"; // 台湾通行证
	public static String IDC_TYPE_TAIBAO = "5"; // 台胞证
	public static String IDC_TYPE_HUIXIANG = "6"; // 回乡证
	public static String IDC_TYPE_JUNREN = "7"; // 军人证
	public static String IDC_TYPE_HUKOU = "8"; // 户口簿
	public static String IDC_TYPE_OTHER = "9"; // 其他

	@Comment("爬虫URL")
	public static String CRAWLER_REQUEST_URL = "http://127.0.0.1:5050";
	@Comment("爬虫服务编码.查询库存")
	public static String CRAWLER_SERVICE_CODE_CHECK_STOCK = "/store";
	@Comment("爬虫服务编码.下单占位")
	public static String CRAWLER_SERVICE_CODE_ORDER_OCCUPY = "/createOrder";
	@Comment("爬虫服务编码.下单支付")
	public static String CRAWLER_SERVICE_CODE_ORDER_PAY = "/order/pay";
	@Comment("爬虫服务编码.取消订单")
	public static String CRAWLER_SERVICE_CODE_ORDER_CANCEL = "/cancel";
	@Comment("爬虫服务编码.订单出票")
	public static String CRAWLER_SERVICE_CODE_ORDER_TICKET = "/ticket";
	// 获取GLA编码
	@Comment("东航迪斯尼运价编码")
	public static String CRAWLER_SERVICE_PATAM_FREIGHTNO = "DM-60BJOT";

	@Comment("ETERM接口.URL")
	public static String ETERM_REQUEST_URL = "http://180.97.80.177:8083/travel_web/eterm/ibettu";
	@Comment("ETERM服务编码.生成PNR")
	public static String ETERM_SERVICE_CODE_CREATE_PNR = "/createPnr";
	@Comment("ETERM服务编码.取消PNR")
	public static String ETERM_SERVICE_CODE_CANCEL_PNR = "/cancelPnr/";
	@Comment("ETERM服务编码.解析PNR(RT&PAT)")
	public static String ETERM_SERVICE_CODE_ANALYSIS_PNR = "/analysisPnr/";
	@Comment("ETERM服务编码.解析RT信息")
	public static String ETERM_SERVICE_CODE_ANALYSIS_RT = "/analysisRt/";
	@Comment("ETERM服务编码.解析PAT信息")
	public static String ETERM_SERVICE_CODE_ANALYSIS_PAT = "/analysisPat/";

	@Comment("检查门票库存最多越天数")
	public static Integer CHECK_STOCK_DAY_MAX = 30;

	@Comment("入园日期距离下单日限定最小天数")
	public static Integer ORDER_PERIOD_MIN = 3;

	@Comment("每人每天最大购票数")
	public static Integer TICKET_NUM_MAX = 5;

	@Comment("占位订单游客默认占票数")
	public static Integer ORDER_OCCUPY_NUM_INIT = 5;

	@Comment("占位订单旅客生成pnr默认执行次数")
	public static Integer ORDER_OCCUPY_CREATE_PNR_LIMIT = 3;

	// 占位旅客id最大检索数
	public static Integer PASSENGETR_ROW_MAX = 5000;

	// 占位行程id最大检索数
	public static Integer TRIP_ROW_MAX = 1;

	@Comment("执行检查库存的频率")
	public static Integer CHECK_OCCUPY_PERIOD = 10;

	@Comment("是否执行占位JOB")
	public static Boolean ORDER_OCCUPY_RUN = true;

	@Comment("机票提前门票日期最少天数")
	public static Integer PLANE_BEFORE_DSN_MIN = 1;

	@Comment("机票提前门票日期最多天数")
	public static Integer PLANE_BEFORE_DSN_MAX = 30;

}
