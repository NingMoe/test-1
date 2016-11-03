package com.sharefree.model.disney;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;

public class OccupyDetailSelector {

	/**
	 * 所有占位
	 */
	private List<OccupyDetailModel> details;

	/**
	 * 需要数量
	 */
	private Integer needNum;

	/**
	 * 选择的结果
	 */
	private List<OccupyDetailModel> selections;

	/**
	 * 选择的结果Id
	 */
	private List<Long> selectionIds;

	/**
	 * 实际数量
	 */
	private Integer realNum;

	/**
	 * 回占数量
	 */
	private Integer occupyNum = 0;

	/**
	 * 符合条件的排序组合
	 */
	private List<Integer[]> combinations;

	public OccupyDetailSelector(List<OccupyDetailModel> details, Integer needNum) {
		this.details = details;
		this.needNum = needNum;
		excute();
	}

	public void excute() {
		if (details != null && details.size() > 0) {
			// 验证占位总数是否满足
			Integer occupyNumSum = 0;
			// 获取占位数组
			int[] input = new int[details.size()];
			for (int i = 0; i < input.length; i++) {
				Integer occupyNum = details.get(i).getOccupyNum();
				input[i] = occupyNum;
				occupyNumSum = occupyNumSum + occupyNum;
			}
			// 没有符合排序时需求数量累加值
			int plus = 0;
			if (occupyNumSum >= needNum) {
				// 获取有效排序，并取出最优排序
				while (realNum == null) {
					// 初始化数据
					int[] record = new int[input.length];
					int key = needNum + plus;
					int sum = 0;
					int n = 0;
					combinations = new ArrayList<Integer[]>();
					sort(input, record, key, sum, n);
					if (combinations.size() > 0) {
						Integer[] selection = null;
						for (Integer[] combination : combinations) {
							if (selection == null || selection.length < combination.length)
								selection = combination;
						}
						Map<Long, OccupyDetailModel> selectionMap = new LinkedHashMap<Long, OccupyDetailModel>();
						for (Integer value : selection) {
							for (OccupyDetailModel detail : details) {
								if (detail.getOccupyNum() == value && !selectionMap.containsKey(detail.getOccupyId())) {
									selectionMap.put(detail.getOccupyId(), detail);
									break;
								}
							}
						}
						List<OccupyDetailModel> models = new ArrayList<OccupyDetailModel>();
						List<Long> ids = new ArrayList<Long>();
						for (Long occupyId : selectionMap.keySet()) {
							ids.add(occupyId);
							models.add(selectionMap.get(occupyId));
						}
						selections = models;
						selectionIds = ids;
						realNum = key;
						occupyNum = plus;
						break;
					}
					plus++;
				}
			}
		}
	}

	private void sort(int[] input, int[] record, int key, int sum, int n) {
		if (n == input.length) {
			return;
		} else {
			for (int i = 0; i <= 1; i++) {
				sum += i * input[n];
				record[n] = i;
				if (sum == key) {
					List<Integer> transition = new ArrayList<Integer>();
					for (int j = 0; j <= n; j++) {
						if (record[j] == 1)
							transition.add(input[j]);
					}
					Integer[] combination = transition.toArray(new Integer[transition.size()]);
					combinations.add(combination);
				}
				if (sum < key) {
					sort(input, record, key, sum, n + 1);
				}
				sum -= i * input[n];
			}
		}
	}

	public List<OccupyDetailModel> getDetails() {
		return details;
	}

	public void setDetails(List<OccupyDetailModel> details) {
		this.details = details;
	}

	public Integer getNeedNum() {
		return needNum;
	}

	public void setNeedNum(Integer needNum) {
		this.needNum = needNum;
	}

	public List<OccupyDetailModel> getSelections() {
		return selections;
	}

	public void setSelections(List<OccupyDetailModel> selections) {
		this.selections = selections;
	}

	public List<Long> getSelectionIds() {
		return selectionIds;
	}

	public void setSelectionIds(List<Long> selectionIds) {
		this.selectionIds = selectionIds;
	}

	public Integer getRealNum() {
		return realNum;
	}

	public void setRealNum(Integer realNum) {
		this.realNum = realNum;
	}

	public Integer getOccupyNum() {
		return occupyNum;
	}

	public void setOccupyNum(Integer occupyNum) {
		this.occupyNum = occupyNum;
	}

	public List<Integer[]> getCombinations() {
		return combinations;
	}

	public void setCombinations(List<Integer[]> combinations) {
		this.combinations = combinations;
	}

	public static void main(String[] args) {
		List<OccupyDetailModel> details = new ArrayList<OccupyDetailModel>();
		OccupyDetailModel detail = new OccupyDetailModel();
		detail.setOccupyId(1L);
		detail.setOccupyNum(3);
		details.add(detail);
		detail = new OccupyDetailModel();
		detail.setOccupyId(2L);
		detail.setOccupyNum(3);
		details.add(detail);
		// detail = new OccupyDetailModel();
		// detail.setOccupyId(3L);
		// detail.setOccupyNum(5);
		// details.add(detail);
		// detail = new OccupyDetailModel();
		// detail.setOccupyId(4L);
		// detail.setOccupyNum(5);
		// details.add(detail);
		// detail = new OccupyDetailModel();
		// detail.setOccupyId(5L);
		// detail.setOccupyNum(3);
		// details.add(detail);
		// detail = new OccupyDetailModel();
		// detail.setOccupyId(6L);
		// detail.setOccupyNum(4);
		// details.add(detail);
		System.out.println(Json.toJson(details));
		System.out.println("###############################################");
		OccupyDetailSelector selector = new OccupyDetailSelector(details, 9);
		System.out.println(Json.toJson(selector.getSelections()));
		System.out.println(Json.toJson(selector.getSelectionIds()));
		System.out.println(selector.getRealNum());
		System.out.println(selector.getOccupyNum());
	}

}
