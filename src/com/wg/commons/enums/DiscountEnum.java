package com.wg.commons.enums;

import com.wg.commons.util.StringUtil;

/**
 * @Author clf
 * @Date 2019/2/26
 * @Desc 数据类型枚举，正常：商品；促销：促销数据，优惠卷：优惠卷数据；
 */

public enum DiscountEnum {

    NORMAL(1,"正常"),PROMOTION(1,"促销"),COUPON(2,"优惠卷"),SETTLEMENTDATE(4,"结算日期");

    private int index;
    private String name;

    DiscountEnum(int index,String name){
        this.index=index;
        this.name=name;
    }

    public static DiscountEnum getByName(String name){
        if(StringUtil.isEmpty(name))
            return null;
        name=name.trim();
        if("正常".equals(name))
            return NORMAL;
        if("促销".equals(name))
            return PROMOTION;
        if("优惠卷".equals(name))
            return COUPON;
        if("结算日期".equals(name))
            return SETTLEMENTDATE;
        return null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
