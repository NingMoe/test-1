package com.sharefree.bean.disney;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "const")
public class Const implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long constId;

	@Name
	private String constKey;

	@Column
	private String constValue;

	@Column
	private String comment;

	public Long getConstId() {
		return constId;
	}

	public void setConstId(Long constId) {
		this.constId = constId;
	}

	public String getConstKey() {
		return constKey;
	}

	public void setConstKey(String constKey) {
		this.constKey = constKey;
	}

	public String getConstValue() {
		return constValue;
	}

	public void setConstValue(String constValue) {
		this.constValue = constValue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}