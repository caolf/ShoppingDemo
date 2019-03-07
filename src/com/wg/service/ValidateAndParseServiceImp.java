package com.wg.service;

import com.wg.commons.enums.DiscountEnum;
import com.wg.commons.validate.Validata;
import com.wg.commons.validate.ValidataImp;
import com.wg.commons.validate.ValidateResult;
import com.wg.domain.*;


/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc
 */
public class ValidateAndParseServiceImp implements ValidateAndParseService {
    private Validata validata = new ValidataImp();

    //数据的校验和解析
    public ShoppingInf validateAndParse(String param, ShoppingInf shoppingInf) {
        ValidateResult validateResult = null;
        if (shoppingInf == null)
            shoppingInf = new ShoppingInf();
        //促销
        if (param.split("\\|").length == 3) {
            validateResult = validata.promotion(param);
            if (validateResult.isRight() && validateResult.getData() instanceof PromotionInf)
                shoppingInf.getPromotionInfList().add((PromotionInf) validateResult.getData());
        } else if (param.split("[\\*\\:\\：]").length == 3) {
            //商品
            validateResult = validata.product(param);
            if (DiscountEnum.NORMAL.equals(validateResult.getDataType()) && validateResult.getData() instanceof ProductInf)
                shoppingInf.getProductInfList().add((ProductInf) validateResult.getData());
        } else if (param.split("\\s").length == 3) {
            //优惠
            validateResult = validata.coupon(param);
            if (DiscountEnum.COUPON.equals(validateResult.getDataType()) && validateResult.getData() instanceof CouponInf) {
                if (shoppingInf.getCouponInf() == null)
                    shoppingInf.setCouponInf((CouponInf) validateResult.getData());
                else {
                    validateResult.setRight(false);
                    validateResult.setMessage("每次结算只能用一张，已经存在一张优惠卷！");
                }
            }
        } else {
            validateResult = validata.settlementdate(param);//结算
            if (DiscountEnum.SETTLEMENTDATE.equals(validateResult.getDataType()) && validateResult.getData() instanceof SettlementInf)
                shoppingInf.setSettlementInf((SettlementInf) validateResult.getData());
        }
        shoppingInf.setValidateResult(validateResult);
        return shoppingInf;
    }

}
