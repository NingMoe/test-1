package com.sharefree.model.system;

import java.io.Serializable;
import java.util.Date;

import com.sharefree.model.BaseModel;

public class OperatorModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long optId;

	private String optNo;

	private String password;

	private String optName;

	private String gender;

	private String tel;

    private String pictureUrl;

    private String status;

	private Long crtOptId;

	private Date crtTime;

	private String userNo;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public Long getOptId() {
		return optId;
	}

	public void setOptId(Long optId) {
		this.optId = optId;
	}

	public String getOptNo() {
		return optNo;
	}

	public void setOptNo(String optNo) {
		this.optNo = optNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCrtOptId() {
		return crtOptId;
	}

	public void setCrtOptId(Long crtOptId) {
		this.crtOptId = crtOptId;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
}