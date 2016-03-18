package com.sharefree.bean.ctrip;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "")
public class WebProduct implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @Id
    @Column
    private Integer productid;

    @Column
    private Integer tripid;

    @Column
    private String producttype;

    @Column
    private String cabinclass;

    @Column
    private String cabincode;

    @Column
    private Integer faceprice;

    @Column
    private Integer tax;

    @Column
    private Integer saleprice;

    @Column
    private String combo;

    @Column
    private Integer cabinleft;

    @Column
    private String changerefundrule;

    @Column
    private String ticketnotice;

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
        this.changerefundrule = changerefundrule == null ? null : changerefundrule.trim();
    }

    public String getTicketnotice() {
        return ticketnotice;
    }

    public void setTicketnotice(String ticketnotice) {
        this.ticketnotice = ticketnotice == null ? null : ticketnotice.trim();
    }
}