package com.wg.commons.validate;/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc 输入信息校验
 */

public interface Validata {

    //促销信息校验,格式为：⽇期 | 折扣 | 产品品类
    public ValidateResult promotion(String param);
    //优惠卷信息校验,格式为：数量 * 商品 : 单价
    public ValidateResult coupon(String param);
    //数据校验,⽰例 2014.3.2 1000 200 为 2014 年 3⽉2⽇到期，满 1000 返 200，空格分隔，
    public ValidateResult product(String param);
    //结算日期
    public ValidateResult settlementdate(String param);

}
