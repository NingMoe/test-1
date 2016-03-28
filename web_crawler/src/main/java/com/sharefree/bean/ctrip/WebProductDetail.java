package com.sharefree.bean.ctrip;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "web_product_detail")
public class WebProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@Column
    private Integer detailid;

	@Column
    private Integer productid;

	@Column
    private Integer faceprice;

	@Column
    private Integer tax;

	@Column
    private String helpterm;

	@Column
    private String changerefundrule;

	@Column
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