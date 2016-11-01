package com.sharefree.model.disney;

import java.io.Serializable;

import com.sharefree.model.BaseModel;

public class ConstModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long constId;

	private String constKey;

	private String constValue;

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