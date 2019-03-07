package com.wg.commons.validate;


import org.junit.Test;

import static org.junit.Assert.*;


public class ValidateUtilImpTest {
    private Validata validateUtilImp=new ValidataImp();


    @Test
    public void promotion() {
        //⽇期 | 折扣 | 产品品类
        assertTrue(validateUtilImp.promotion("2013.11.11 | 0.7 | 电子").isRight());
    }

    @Test
    public void coupon() {
        assertTrue(validateUtilImp.coupon("2014.3.2 1000 200").isRight());
    }

    @Test
    public void product() {
        assertTrue(validateUtilImp.product("1 * 显⽰器 : 1799.00").isRight());
    }
}
