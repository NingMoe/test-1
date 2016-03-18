package com.sharefree.model;

/**
 * Title: BaseModel
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 19, 2016
 *
 */
public class BaseModel<C,R> {
	/*
	 * 当前页码
	 */
	private Integer pageNo;
	
	/*
	 * 每页数据量
	 */
	private Integer pageSize;
	
	/*
	 * 数据总量
	 */
	private Integer totalCount;
	
	/*
	 * 页码总数
	 */
	private Integer totalPage;
	
	/*
	 * 查询条件
	 */
	private C condition;
	
	/*
	 * 查询结果集
	 */
	private R results;

	/*
	 * 身份验证令牌
	 */
	private String token;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public C getCondition() {
		return condition;
	}

	public void setCondition(C condition) {
		this.condition = condition;
	}

	public R getResults() {
		return results;
	}

	public void setResults(R results) {
		this.results = results;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
