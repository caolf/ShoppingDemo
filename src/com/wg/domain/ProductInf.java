package com.wg.domain;/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc 产品信息
 */
public class ProductInf extends DomainBase{

    //产品数量
    private int num;
    //产品名称
    private String productName;
    //单价
    private double price;

    //最终价格
    private Double totalPrice;

    public ProductInf(){}

    public ProductInf(int num,String productName,double price){
        this.num = num;
        this.productName = productName;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
