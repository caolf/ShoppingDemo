package com.wg.commons.validate;

import com.wg.commons.enums.DiscountEnum;
import com.wg.commons.enums.ProductEnum;
import com.wg.commons.util.DateUtil;
import com.wg.commons.util.StringUtil;
import com.wg.domain.*;


/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc
 */


public class ValidataImp implements Validata{

    private final static String MARK1="\\|";
    private final static String MARK2="\\*";
    private final static String MARK3="\\s";
    private final static String MARK4=".";
    private final static String MARK5="\\:";
    @Override
    public ValidateResult promotion(String param) {
        //⽇期 | 折扣 | 产品品类
        ValidateResult result=new ValidateResult();
        result.setDataType(DiscountEnum.PROMOTION);
        result.setRight(false);
        result.setMessage("数据格式有误！");

        PromotionInf promotionInf=new PromotionInf();

        if(StringUtil.isNotEmpty(param) ){
            String []datas=param.split(MARK1);
            if(datas.length==3){
                //日期
                if(DateUtil.dateParse(datas[0])!=null){
                    promotionInf.setDisCountDate(datas[0].trim());
                    //折扣
                    if(StringUtil.string2Double(datas[1])!=null){
                        promotionInf.setRatio(StringUtil.string2Double(datas[1]));
                        //产品品类
                        if(ProductEnum.getByName(datas[2])!=null){
                            promotionInf.setProductType(ProductEnum.getByName(datas[2]));
                            result.setRight(true);
                            result.setMessage(null);
                        }
                        else
                            result.setMessage("产品类型不存在！");
                    }else
                        result.setMessage("折扣数据有误！");
                }
                else
                    result.setMessage("日期格式有误！");
            }
        }
        result.setData(promotionInf);
        return result;
    }

    //优惠卷信息校验
    @Override
    public ValidateResult coupon(String param) {
        ValidateResult result=new ValidateResult();
        result.setDataType(DiscountEnum.COUPON);
        result.setRight(false);
        result.setMessage("数据格式有误！");

        CouponInf couponInf=new CouponInf();

        //⽰例 2014.3.2 1000 200 为 2014 年 3⽉2⽇到期，满 1000 返 200，空格分隔
        if(StringUtil.isNotEmpty(param) ){
            String[] datas=param.split(MARK3);
            if(datas.length==3){
                //日期
                if(DateUtil.dateParse(datas[0])!=null){
                    couponInf.setCouponDate(datas[0].trim());
                    //满额
                    if(StringUtil.string2Double(datas[1])!=null){
                        couponInf.setTotal(StringUtil.string2Double(datas[1]));
                        //优惠金额
                        if(StringUtil.string2Double(datas[2])!=null) {
                            couponInf.setDiscount(StringUtil.string2Double(datas[2]));
                            result.setRight(true);
                            result.setMessage(null);
                        }else
                            result.setMessage("优惠金额格式有误！");
                    }else
                        result.setMessage("满额格式错误！");
                }else
                    result.setMessage("日期格式有误！");
            }
        }

        result.setData(couponInf);
        return result;
    }

    //数量 * 商品 : 单价
    @Override
    public ValidateResult product(String param) {
        ValidateResult result=new ValidateResult();
        result.setDataType(DiscountEnum.NORMAL);
        result.setRight(false);
        result.setMessage("数据格式有误！");

        ProductInf productInf=new ProductInf();
        if(StringUtil.isNotEmpty(param) ){
                String[] nums=param.split(MARK2);
                if(nums.length==2){
                    //数量
                    if(StringUtil.string2Integer(nums[0])!=null){
                        productInf.setNum(StringUtil.string2Integer(nums[0]));
                        //商品
                        String[] products=nums[1].split(MARK5);
                        if(products.length==2){
                            productInf.setProductName(products[0].trim());
                            //单价
                            if(StringUtil.string2Double(products[1])!=null){
                                productInf.setPrice(StringUtil.string2Double(products[1]));
                                result.setRight(true);
                                result.setMessage(null);
                            }else
                                result.setMessage("单价信息有误！");
                        }else
                            result.setMessage("商品信息有误！");
                    }
                    else
                        result.setMessage("数量信息有误！");

                }
        }
        result.setData(productInf);
        return result;
    }

    @Override
    public ValidateResult settlementdate(String param) {
        ValidateResult result=new ValidateResult();
        result.setDataType(DiscountEnum.SETTLEMENTDATE);
        result.setRight(false);
        result.setMessage("数据格式有误！");
        SettlementInf settlementInf=new SettlementInf();
        if(DateUtil.dateParse(param)!=null){
            settlementInf.setDate(param.trim());
            result.setRight(true);
            result.setMessage(null);
        }
        result.setData(settlementInf);
        return result;
    }


}
