package com.sharefree.utils;

import java.util.HashMap;
import java.util.Map;

import com.sharefree.constant.DisneyConst;

public class DisneyUtil {

	public static enum Signal {
		OBTAIN, INCREASE, REDUCE
	}

	/**
	 * 同一入园日期，各订单正在执行的[下单占位人数]<br>
	 * 
	 * key: 入园日期（Format: yyyy-MM-dd）<br>
	 * value: 各订单正在执行的[下单占位人数]<br>
	 */
	private static Map<String, Map<Long, Integer>> ORDERING = new HashMap<String, Map<Long, Integer>>();

	/**
	 * 查询某入园日某订单正在执行的[下单占位人数]
	 * 
	 * @param visitDate
	 *            入园日
	 * @param orderId
	 *            某订单
	 * @return 正在执行的[下单占位人数]
	 */
	private static Integer obtain(String visitDate, Long orderId) {
		Integer num = 0;
		Map<Long, Integer> map = ORDERING.get(visitDate);
		if (map != null) {
			if (orderId != null) {
				if (map.containsKey(orderId))
					num = map.get(orderId);
			} else {
				// 获取入园日所有执行数
				for (Integer value : map.values()) {
					num = num + value;
				}
			}
		}
		return num;
	}

	/**
	 * 增加某入园日正在执行的[下单占位人数]
	 * 
	 * @param visitDate
	 *            入园日
	 * @param orderId
	 *            某订单
	 * @return 增加后，正在执行的[下单占位人数]
	 */
	private static void increase(String visitDate, Long orderId, Integer increaseNum) {
		Map<Long, Integer> map = ORDERING.get(visitDate);
		if (map != null) {
			if (map.containsKey(orderId)) {
				Integer value = map.get(orderId) + increaseNum;
				map.put(orderId, value);
			} else {
				map.put(orderId, increaseNum);
			}
		} else {
			map = new HashMap<Long, Integer>();
			map.put(orderId, increaseNum);
			ORDERING.put(visitDate, map);
		}
	}

	/**
	 * 减少某入园日正在执行的[下单占位人数]
	 * 
	 * @param visitDate
	 * @param num
	 * @return
	 */
	private static void reduce(String visitDate, Long orderId, Integer reduceNum) {
		Map<Long, Integer> map = ORDERING.get(visitDate);
		if (map != null && map.containsKey(orderId)) {
			Integer value = map.get(orderId) - reduceNum;
			if (value > 0) {
				map.put(orderId, value);
			} else {
				map.remove(orderId);
				if (map.size() == 0)
					ORDERING.remove(visitDate);
			}
		}
	}

	public static Integer handle(String visitDate, Long orderId, Signal code, Integer num) {
		synchronized (visitDate) {
			switch (code) {
			case OBTAIN:
				num = obtain(visitDate, orderId);
				break;
			case INCREASE:
				increase(visitDate, orderId, num);
				break;
			case REDUCE:
				reduce(visitDate, orderId, num);
				break;
			default:
				num = 0;
				break;
			}
		}
		return num;
	}

	public static Integer[] calculateOccupyOrder(Integer need) {
		Integer[] occupy = new Integer[] {};
		if (need > 0) {
			int full = need / DisneyConst.ORDER_OCCUPY_NUM_INIT;
			int lack = need % DisneyConst.ORDER_OCCUPY_NUM_INIT;
			if (lack == 0) {
				occupy = new Integer[full];
			} else {
				occupy = new Integer[full + 1];
			}
			for (int i = 0; i < full; i++) {
				occupy[i] = DisneyConst.ORDER_OCCUPY_NUM_INIT;
			}
			if (lack != 0)
				occupy[occupy.length - 1] = lack;
		}
		return occupy;
	}
}
