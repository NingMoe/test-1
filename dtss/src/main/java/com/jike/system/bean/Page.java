package com.jike.system.bean;

public class Page {

	// 分页查询开始位置 begin
	private Integer begin;
	// 分页查询结束位置 end
	private Integer end;
	// 查询结果总记录数 count
	private Integer totalCount;
	// 每页显示记录数 length
	private Integer limit;
	// 当前页码 current
	private Integer no;
	// 总共页数 total
	private Integer totalPage;

	public Page() {
	}

	private void freshBeginEnd() {
		if (this.limit == null || this.limit <= 0 || this.no == null
				|| this.no <= 0) {
			begin = null;
			end = null;
		} else {
			begin = (no - 1) * limit;
			end = no * limit;
			// TODO 是否加1 让oracle语句 <end 而不写成<=end
		}
	}

	/**
	 * 构造函数
	 * 
	 * @param pageNo
	 * @param pageSize
	 */
	public Page(Integer no, Integer limit) {
		setLimit(limit);
		setNo(no);
	}

	/**
	 * @return the begin
	 */
	public Integer getBegin() {
		return begin;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	/**
	 * @return the end
	 */
	public Integer getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(Integer end) {
		this.end = end;
	}

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (int) Math.ceil((this.totalCount * 1.0d) / this.limit);
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param pageSize
	 *            pageSize为-1时，表示查询全部， pageSize为0时，查询前10笔数据
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
		if (limit == null) {
			this.limit = 10;
		} else if (limit == -1) {
			this.limit = null;
		}
		freshBeginEnd();
	}

	public Integer getNo() {
		return no;
	}

	/**
	 * 页面记录数
	 * 
	 * @param no
	 */
	public void setNo(Integer no) {
		this.no = no;
		freshBeginEnd();
	}
}