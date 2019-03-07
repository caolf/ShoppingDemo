package com.wg.commons.validate;

import com.wg.commons.enums.DiscountEnum;
import com.wg.domain.DomainBase;

import java.io.Serializable;

/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc
 */

public class ValidateResult implements Serializable{

    private static final long serialVersionUID = 1L;

    //合法数据
    private boolean isRight;
    //验证消息
    private String message;
    //数据类型
    private DiscountEnum dataType;
    //数据
    private DomainBase data;

    public DiscountEnum getDataType() {
        return dataType;
    }

    public void setDataType(DiscountEnum dataType) {
        this.dataType = dataType;
    }

    public DomainBase getData() {
        return data;
    }

    public void setData(DomainBase data) {
        this.data = data;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
