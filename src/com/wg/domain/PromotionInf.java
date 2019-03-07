package com.wg.domain;

import com.wg.commons.enums.ProductEnum;

/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc 促销信息
 */

public class PromotionInf extends DomainBase{

    //折扣日期
    private String disCountDate;
    //折扣类型
    private double ratio;
    //产品品类
    private ProductEnum productType;

    public PromotionInf(){}

    public PromotionInf(String disCountDate,double ratio,ProductEnum productType){
        this.disCountDate = disCountDate;
        this.ratio = ratio;
        this.productType = productType;
    }

    public String getDisCountDate() {
        return disCountDate;
    }

    public void setDisCountDate(String disCountDate) {
        this.disCountDate = disCountDate;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public ProductEnum getProductType() {
        return productType;
    }

    public void setProductType(ProductEnum productType) {
        this.productType = productType;
    }
}
