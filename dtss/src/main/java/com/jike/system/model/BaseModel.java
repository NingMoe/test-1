package com.jike.system.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jike.system.bean.Page;

/**
 * 基础Model 提供分页
 * 
 * @author Sun
 * 
 */
// 忽略不需要的属性
@JsonIgnoreProperties(ignoreUnknown = true)
// 为空的值不返回
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594058870475174243L;

	private Page page;
	private Integer limit;
	private Integer no;
	private String keywords;
	private String orderByClause;

	private Long id;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
		if ((no != null && no != 0) && (limit != null && limit != 0)) {
			this.page = new Page(no, limit);
		}
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
		if ((no != null && no != 0) && (limit != null && limit != 0)) {
			this.page = new Page(no, limit);
		}
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

}
