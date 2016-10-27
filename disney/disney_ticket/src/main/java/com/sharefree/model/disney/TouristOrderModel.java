package com.sharefree.model.disney;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.nutz.json.JsonField;

import com.sharefree.model.BaseModel;
import com.sharefree.utils.DateUtil;

public class TouristOrderModel extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long orderId;

	private String orderNo;

	private Long customerId;

	private String customerName;

	@JsonField(dataFormat = "yyyy-MM-dd")
	private Date visitDate;

	private Integer visitNum;

	private Boolean isNeedOccupy;

	private Integer needOccupyNum;

	private Integer priority;

	private Integer occupyNum;

	private Date crtTime;

	private Long crtOptId;

	private Date importTime;

	private Long importOptId;

	private Integer ticketingNum;

	private String status;

	private String showStatus;

	// 条件
	private Date visitDateF;

	private Date visitDateT;

	private String[] visitDateIn;

	private Integer occupyNumF;

	private Integer occupyNumT;

	private String[] statusIn;

	private String customerNameLike;

	private Boolean isImport;

	private List<TouristDetailModel> touristDetails;

	private List<OccupyDetailModel> occupyDetails;

	public List<TouristDetailModel> getTouristDetails() {
		return touristDetails;
	}

	public void setTouristDetails(List<TouristDetailModel> touristDetails) {
		this.touristDetails = touristDetails;
	}

	public List<OccupyDetailModel> getOccupyDetails() {
		return occupyDetails;
	}

	public void setOccupyDetails(List<OccupyDetailModel> occupyDetails) {
		this.occupyDetails = occupyDetails;
	}

	public Boolean getIsImport() {
		return isImport;
	}

	public void setIsImport(Boolean isImport) {
		this.isImport = isImport;
	}

	public String getCustomerNameLike() {
		return customerNameLike;
	}

	public void setCustomerNameLike(String customerNameLike) {
		this.customerNameLike = customerNameLike;
	}

	public String[] getStatusIn() {
		return statusIn;
	}

	public void setStatusIn(String[] statusIn) {
		this.statusIn = statusIn;
	}

	public Integer getOccupyNumF() {
		return occupyNumF;
	}

	public void setOccupyNumF(Integer occupyNumF) {
		this.occupyNumF = occupyNumF;
	}

	public Integer getOccupyNumT() {
		return occupyNumT;
	}

	public void setOccupyNumT(Integer occupyNumT) {
		this.occupyNumT = occupyNumT;
	}

	public Date getVisitDateF() {
		return visitDateF;
	}

	public void setVisitDateF(Date visitDateF) {
		this.visitDateF = visitDateF;
	}

	public Date getVisitDateT() {
		return visitDateT;
	}

	public void setVisitDateT(Date visitDateT) {
		this.visitDateT = DateUtil.addOneDay(visitDateT);
	}

	public String[] getVisitDateIn() {
		return visitDateIn;
	}

	public void setVisitDateIn(String[] visitDateIn) {
		this.visitDateIn = visitDateIn;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

	public Boolean getIsNeedOccupy() {
		return isNeedOccupy;
	}

	public void setIsNeedOccupy(Boolean isNeedOccupy) {
		this.isNeedOccupy = isNeedOccupy;
	}

	public Integer getNeedOccupyNum() {
		return needOccupyNum;
	}

	public void setNeedOccupyNum(Integer needOccupyNum) {
		this.needOccupyNum = needOccupyNum;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getOccupyNum() {
		return occupyNum;
	}

	public void setOccupyNum(Integer occupyNum) {
		this.occupyNum = occupyNum;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public Long getCrtOptId() {
		return crtOptId;
	}

	public void setCrtOptId(Long crtOptId) {
		this.crtOptId = crtOptId;
	}

	public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public Long getImportOptId() {
		return importOptId;
	}

	public void setImportOptId(Long importOptId) {
		this.importOptId = importOptId;
	}

	public Integer getTicketingNum() {
		return ticketingNum;
	}

	public void setTicketingNum(Integer ticketingNum) {
		this.ticketingNum = ticketingNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}
}