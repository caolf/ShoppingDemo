/**
 * @Author clf
 * @Date 2019/2/26
 * @Desc 产品类型枚举
 */
package com.wg.commons.enums;

import com.wg.commons.util.StringUtil;

public enum ProductEnum {

    ELECTRONICS(1,"电子"),FOOD(2,"食品"),NECESSITIES(3,"日用品"),WINE(4,"酒类");
    private int index;
    private String name;

    ProductEnum(int index,String name){
        this.index=index;
        this.name=name;
    }

    public static ProductEnum getByName(String name){
        if(StringUtil.isEmpty(name))
            return null;
        name=name.trim();
        if("电子".equals(name))
            return ELECTRONICS;
        if("食品".equals(name))
            return FOOD;
        if("日用品".equals(name))
            return NECESSITIES;
        if("酒类".equals(name))
            return WINE;
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
