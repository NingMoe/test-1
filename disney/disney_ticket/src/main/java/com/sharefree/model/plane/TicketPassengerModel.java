package com.sharefree.model.plane;

import java.io.Serializable;
import java.util.Date;

import com.sharefree.model.BaseModel;

/**
 * 
 * @author Sun
 * 
 */
public class TicketPassengerModel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idcName;

	private String passengerType;

	private String sex;

	private Date birthday;

	private String idcType;

	private String idcNo;

	private String nationality;

	private String tel;

	private String email;

	public String getIdcName() {
		return idcName;
	}

	public void setIdcName(String idcName) {
		this.idcName = idcName;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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
