package com.wg.domain;

import com.wg.commons.validate.ValidateResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc 购物车
 */

public class ShoppingInf  {
    private List<PromotionInf> promotionInfList=new ArrayList<>();//折扣
    private List<ProductInf> productInfList=new ArrayList<>();//产品
    private CouponInf couponInf=null;//优惠卷
    private SettlementInf settlementInf=null;//结算日期
    private ValidateResult validateResult=null;//

    public ValidateResult getValidateResult() {
        return validateResult;
    }

    public void setValidateResult(ValidateResult validateResult) {
        this.validateResult = validateResult;
    }

    public List<PromotionInf> getPromotionInfList() {
        return promotionInfList;
    }

    public List<ProductInf> getProductInfList() {
        return productInfList;
    }

    public CouponInf getCouponInf() {
        return couponInf;
    }

    public void setCouponInf(CouponInf couponInf) {
        this.couponInf = couponInf;
    }

    public SettlementInf getSettlementInf() {
        return settlementInf;
    }

    public void setSettlementInf(SettlementInf settlementInf) {
        this.settlementInf = settlementInf;
    }
}
