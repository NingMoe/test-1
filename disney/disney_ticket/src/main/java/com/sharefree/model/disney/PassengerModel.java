package com.sharefree.model.disney;

import java.io.Serializable;

import com.sharefree.model.BaseModel;

public class PassengerModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long passengerId;

	private String name;

	private String idcType;

	private String idcNo;

	private String tel;

	private String email;

	// 条件
	private String[] rowIdIn;

	public String[] getRowIdIn() {
		return rowIdIn;
	}

	public void setRowIdIn(String[] rowIdIn) {
		this.rowIdIn = rowIdIn;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcType() {
		return idcType;
	}

	public void setIdcType(String idcType) {
		this.idcType = idcType;
	}

	public String getIdcNo() {
		return idcNo;
	}

	public void setIdcNo(String idcNo) {
		this.idcNo = idcNo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}