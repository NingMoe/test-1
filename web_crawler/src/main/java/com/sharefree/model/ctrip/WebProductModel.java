package com.sharefree.model.ctrip;

import java.io.Serializable;
import java.util.List;

import com.sharefree.model.BaseModel;

public class WebProductModel extends BaseModel<Object, List<Object[]>> implements Serializable {

    private static final long serialVersionUID = 1L;
	
    private Integer productid;

    private Integer tripid;

    private String producttype;

    private String cabinclass;

    private String cabincode;

    private Integer faceprice;

    private Integer tax;

    private Integer saleprice;

    private String combo;

    private Integer cabinleft;

    private String changerefundrule;

    private String ticketnotice;
    
    /*
     * 包含的航班
     */
    private List<Integer> includeTripid;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getTripid() {
        return tripid;
    }

    public void setTripid(Integer tripid) {
        this.tripid = tripid;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype == null ? null : producttype.trim();
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass == null ? null : cabinclass.trim();
    }

    public String getCabincode() {
        return cabincode;
    }

    public void setCabincode(String cabincode) {
        this.cabincode = cabincode == null ? null : cabincode.trim();
    }

    public Integer getFaceprice() {
        return faceprice;
    }

    public void setFaceprice(Integer faceprice) {
        this.faceprice = faceprice;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Integer saleprice) {
        this.saleprice = saleprice;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo == null ? null : combo.trim();
    }

    public Integer getCabinleft() {
        return cabinleft;
    }

    public void setCabinleft(Integer cabinleft) {
        this.cabinleft = cabinleft;
    }

	public String getChangerefundrule() {
		return changerefundrule;
	}

	public void setChangerefundrule(String changerefundrule) {
		this.changerefundrule = changerefundrule;
	}

	public String getTicketnotice() {
		return ticketnotice;
	}

	public void setTicketnotice(String ticketnotice) {
		this.ticketnotice = ticketnotice;
	}

	public List<Integer> getIncludeTripid() {
		return includeTripid;
	}

	public void setIncludeTripid(List<Integer> includeTripid) {
		this.includeTripid = includeTripid;
	}
}