package com.sharefree.bean.system;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "operator")
public class Operator implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column
    private Long optId;
    
    @Name
    @Column
    private String optNo;

    @Column
    private String password;

    @Column
    private String optName;

	@Column
    private String gender;

	@Column
    private String tel;

    @Column
    private String pictureUrl;

    @Column
    private String status;

	@Column
    private Long crtOptId;

    @Column
    private Date crtTime;

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
