package com.sharefree.model.ctrip;

import java.io.Serializable;
import java.util.List;

import com.sharefree.model.BaseModel;

public class WebProductDetailModel extends BaseModel<Object, List<Object[]>> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer detailid;

    private Integer productid;

    private Integer faceprice;

    private Integer tax;

    private String helpterm;

    private String changerefundrule;

    private String ticketnotice;

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
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

    public String getHelpterm() {
        return helpterm;
    }

    public void setHelpterm(String helpterm) {
        this.helpterm = helpterm == null ? null : helpterm.trim();
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