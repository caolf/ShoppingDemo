package com.wg.test.service;

import com.wg.commons.util.StringUtil;
import com.wg.domain.ShoppingInf;
import com.wg.service.ProductCalService;
import com.wg.service.ProductCalServiceImp;
import com.wg.service.ValidateAndParseService;
import com.wg.service.ValidateAndParseServiceImp;
import org.junit.Test;

import static org.junit.Assert.*;


public class ValidateAndParseServiceTest {
    private ValidateAndParseService validateAndParseService = new ValidateAndParseServiceImp();
    //商品计算服务
    private static ProductCalService productCalService = new ProductCalServiceImp();

    @Test
    public void validateAndParse() {

        ShoppingInf shoppingInf = new ShoppingInf();
        validateAndParseService.validateAndParse("2013.11.11 | 0.7 | 电子", shoppingInf);
        assertTrue(shoppingInf.getPromotionInfList().size() == 1);

        validateAndParseService.validateAndParse("1 * ipad : 2399.00", shoppingInf);
        assertTrue(shoppingInf.getProductInfList().size() == 1);

        validateAndParseService.validateAndParse("1 * 显示器 : 1799.00", shoppingInf);
        assertTrue(shoppingInf.getProductInfList().size() == 2);

        validateAndParseService.validateAndParse("12 * 啤酒 : 25.00", shoppingInf);
        assertTrue(shoppingInf.getProductInfList().size() == 3);

        validateAndParseService.validateAndParse("5 * 面包 : 9.00", shoppingInf);
        assertTrue(shoppingInf.getProductInfList().size() == 4);

        validateAndParseService.validateAndParse("2013.11.11", shoppingInf);
        assertNotNull(shoppingInf.getSettlementInf());

        validateAndParseService.validateAndParse("2014.3.2 1000 200", shoppingInf);
        assertNotNull(shoppingInf.getCouponInf());

        assertEquals("3083.60", StringUtil.doubleFormat2String(productCalService.cal(shoppingInf)));


    }

    @Test
    public void validateAndParse2() {//验证例二

        ShoppingInf shoppingInf = new ShoppingInf();

        validateAndParseService.validateAndParse("3 * 蔬菜 : 5.98", shoppingInf);
        assertTrue(shoppingInf.getProductInfList().size() == 1);

        validateAndParseService.validateAndParse("8 * 餐⼱纸 : 3.20", shoppingInf);
        assertTrue(shoppingInf.getProductInfList().size() == 2);

        validateAndParseService.validateAndParse("2014.01.0", shoppingInf);
        assertNotNull(shoppingInf.getSettlementInf());


        assertEquals("43.54", StringUtil.doubleFormat2String(productCalService.cal(shoppingInf)));


    }
}
