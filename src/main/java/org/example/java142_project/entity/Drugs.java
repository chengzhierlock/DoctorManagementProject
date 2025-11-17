package org.example.java142_project.entity;

public class Drugs {
    private int drugid;
    private String drugname;
    private int drugtype;
    private String drugunit;
    private int support;
    private String productdate;
    private String effectdate;
    private int stock;
    private float purchaseprice;
    private float price;
    private String descp;

    @Override
    public String toString() {
        return "Drugs{" +
                "drugid=" + drugid +
                ", drugname='" + drugname + '\'' +
                ", drugtype='" + drugtype + '\'' +
                ", drugunit='" + drugunit + '\'' +
                ", support=" + support +
                ", productdate='" + productdate + '\'' +
                ", effectdate='" + effectdate + '\'' +
                ", stock=" + stock +
                ", purchaseprice=" + purchaseprice +
                ", price=" + price +
                ", descp='" + descp + '\'' +
                '}';
    }

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public int getDrugtype() {
        return drugtype;
    }

    public void setDrugtype(int drugtype) {
        this.drugtype = drugtype;
    }

    public String getDrugunit() {
        return drugunit;
    }

    public void setDrugunit(String drugunit) {
        this.drugunit = drugunit;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public String getProductdate() {
        return productdate;
    }

    public void setProductdate(String productdate) {
        this.productdate = productdate;
    }

    public String getEffectdate() {
        return effectdate;
    }

    public void setEffectdate(String effectdate) {
        this.effectdate = effectdate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(float purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
