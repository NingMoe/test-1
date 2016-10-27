package com.sharefree.model;

import org.nutz.dao.pager.Pager;

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
public class BaseModel {
	/*
	 * 当前页码
	 */
	private Integer pageNumber;

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
	 * 分页信息
	 */
	private Pager pager;

	/*
	 * 排序
	 */
	private String[] orderByClause;

	/*
	 * 自定义排序
	 */
	private String orderByCustom;

	/*
	 * 自定义查询SQL
	 */
	private String customQuerySQL;

	/*
	 * 自定义查询SQL
	 */
	private String customCountSQL;

	/*
	 * 自定义SQL
	 */
	private String customSQL;

	/*
	 * 加载的sql文件key值
	 */
	private String sqlKey;

	/*
	 * 查询时是否同时查询数据总量
	 */
	private Boolean needCount;

	/*
	 * 身份验证令牌
	 */
	private String token;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
		setPager();
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		setPager();
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

	public String[] getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String[] orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByCustom() {
		return orderByCustom;
	}

	public String getCustomQuerySQL() {
		return customQuerySQL;
	}

	public void setCustomQuerySQL(String customQuerySQL) {
		this.customQuerySQL = customQuerySQL;
	}

	public String getCustomCountSQL() {
		return customCountSQL;
	}

	public void setCustomCountSQL(String customCountSQL) {
		this.customCountSQL = customCountSQL;
	}

	public String getCustomSQL() {
		return customSQL;
	}

	public void setCustomSQL(String customSQL) {
		this.customSQL = customSQL;
	}

	public String getSqlKey() {
		return sqlKey;
	}

	public void setSqlKey(String sqlKey) {
		this.sqlKey = sqlKey;
	}

	public Boolean getNeedCount() {
		return needCount;
	}

	public void setNeedCount(Boolean needCount) {
		this.needCount = needCount;
	}

	public void setOrderByCustom(String orderByCustom) {
		if (orderByCustom != null) {
			String[] orderByCustoms = orderByCustom.split(",");
			if (orderByCustoms != null && orderByCustoms.length > 0) {
				orderByClause = orderByCustoms;
			} else {
				orderByClause = null;
			}
		}
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setPager() {
		if (pageNumber != null && pageSize != null) {
			Pager pager = new Pager();
			pager.setPageNumber(pageNumber);
			pager.setPageSize(pageSize);
			setPager(pager);
		}
	}

}
