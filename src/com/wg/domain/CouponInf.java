package com.wg.domain;/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc 优惠信息
 */

public class CouponInf extends DomainBase{

    //优惠券到期日期
    private String couponDate;
    //优惠券可使用总金额
    private Double total;
    //优惠额度
    private Double discount;

    public CouponInf(){}

    public CouponInf(String couponDate, double total, double discount)
    {
        this.couponDate = couponDate;
        this.total = total;
        this.discount = discount;
    }


    public String getCouponDate() {
        return couponDate;
    }

    public void setCouponDate(String couponDate) {
        this.couponDate = couponDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
