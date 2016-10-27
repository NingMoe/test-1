package com.sharefree.utils;

import java.util.HashMap;
import java.util.Map;

import com.sharefree.constant.DisneyConst;

public class DisneyUtil {

	public static enum Signal {
		OBTAIN, INCREASE, REDUCE
	}

	/**
	 * 同一入园日期，正在执行的[下单占位人数]<br>
	 * 
	 * key: 入园日期（Format: yyyy-MM-dd）<br>
	 * value: 正在执行的[下单占位人数]<br>
	 */
	private static Map<String, Integer> ORDERING = new HashMap<String, Integer>();

	/**
	 * 查询某入园日正在执行的[下单占位人数]
	 * 
	 * @param visitDate
	 *            入园日
	 * @return 正在执行的[下单占位人数]
	 */
	private static Integer obtain(String visitDate) {
		Integer num = ORDERING.get(visitDate);
		if (num == null)
			num = 0;
		return num;
	}

	/**
	 * 增加某入园日正在执行的[下单占位人数]
	 * 
	 * @param visitDate
	 *            入园日
	 * @return 增加后，正在执行的[下单占位人数]
	 */
	private static Integer increase(String visitDate, Integer increaseNum) {
		Integer num = obtain(visitDate) + increaseNum;
		ORDERING.put(visitDate, num);
		return num;
	}

	/**
	 * 减少某入园日正在执行的[下单占位人数]
	 * 
	 * @param visitDate
	 * @param num
	 * @return
	 */
	private static Integer reduce(String visitDate, Integer reduceNum) {
		Integer num = obtain(visitDate);
		if (num > 0) {
			if (num > reduceNum) {
				num = num - reduceNum;
				ORDERING.put(visitDate, num);
			} else {
				num = 0;
				ORDERING.remove(visitDate);
			}
		}
		return num;
	}

	public static Integer handle(String visitDate, Signal code, Integer num) {
		synchronized (visitDate) {
			switch (code) {
			case OBTAIN:
				num = obtain(visitDate);
				break;
			case INCREASE:
				num = increase(visitDate, num);
				break;
			case REDUCE:
				num = reduce(visitDate, num);
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
