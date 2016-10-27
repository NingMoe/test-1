package com.sharefree.constant;

public class SqlsConst {

	// 查询游客订单信息，占位数和出票数为实时统计
	public static final String TOURIST_ORDER_QUERY = "queryTouristOrders";

	// 查询游客订单信息记录总数，占位数和出票数为实时统计
	public static final String TOURIST_ORDER_COUNT = "countTouristOrders";

	// 查询游客订单详情，出票数为实时统计
	public static final String TOURIST_DETAIL_QUERY = "queryTouristDeatils";

	// 统计某时间段段，各入园日订单总人数
	public static final String SELECT_ORDER_NUM_SUM = "selectOrderNumSum";

	// 统计某时间段段，各入园日库存总数
	public static final String SELECT_STOCK_NUM_SUM = "selectStockNumSum";

	// 统计某时间段段，各入园日占位总数
	public static final String SELECT_OCCUPY_NUM_SUM = "selectOccupyNumSum";

	// 统计某时间段段，各入园日出票总数
	public static final String SELECT_TICKET_NUM_SUM = "selectTicketNumSum";

	// 查询乘客总数
	public static final String SELECT_PASSENGER_SUM = "selectPassengerSum";

	// 随机获取乘客信息
	public static final String GET_PASSENGER_RANDOM = "getPassengerRandom";

	// 查询行程总数
	public static final String SELECT_TRIP_SUM = "selectTripSum";

	// 随机获取行程信息
	public static final String GET_TRIP_RANDOM = "getTripRandom";

}
