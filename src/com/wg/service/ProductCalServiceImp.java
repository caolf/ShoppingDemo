package com.wg.service;

import com.wg.commons.enums.ProductEnum;
import com.wg.commons.util.DateUtil;
import com.wg.domain.ProductInf;
import com.wg.domain.PromotionInf;
import com.wg.domain.ShoppingInf;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc 计算服务
 */
public class ProductCalServiceImp implements ProductCalService {

    //库存商品
    private static Map<ProductEnum, String> allShop = new HashMap<>();

    static {
        allShop.put(ProductEnum.ELECTRONICS, "ipad，iphone，显示器，笔记本电脑，键盘");
        allShop.put(ProductEnum.FOOD, "面包，饼干，蛋糕，牛肉，鱼，蔬菜");
        allShop.put(ProductEnum.NECESSITIES, "餐巾纸，收纳箱，咖啡杯，雨伞");
        allShop.put(ProductEnum.WINE, "啤酒，白酒，伏特加 ");
    }

    @Override
    public Double cal(ShoppingInf shoppingInf) {
        Double total = new Double(0);
        //产品
        List<ProductInf> productInfList = shoppingInf.getProductInfList();
        //计算促销
        List<PromotionInf> promotionInfList = shoppingInf.getPromotionInfList();


        if (productInfList.size() > 0) {
            for (ProductInf productInf : productInfList) {
                //计算总价
                productInf.setTotalPrice(productInf.getPrice() * productInf.getNum());
                //折扣计算
                if (promotionInfList.size() > 0) {
                    for (PromotionInf promotionInf : promotionInfList) {
                        if (DateUtil.compareDate(shoppingInf.getSettlementInf().getDate(), promotionInf.getDisCountDate()) < 1) {
                            if (allShop.get(promotionInf.getProductType()).contains(productInf.getProductName())) {
                                //个人理解，同类产品只有一种折扣，如果同类产品有多种修改此处
                                productInf.setTotalPrice(productInf.getPrice() * productInf.getNum() * promotionInf.getRatio());
                            }
                        }
                    }
                }
                total += productInf.getTotalPrice();
            }
        }
        //优惠卷计算
        if (shoppingInf.getCouponInf() != null
                && DateUtil.compareDate(shoppingInf.getSettlementInf().getDate(), shoppingInf.getCouponInf().getCouponDate()) < 1
                && total >= shoppingInf.getCouponInf().getTotal())
            total = total - shoppingInf.getCouponInf().getDiscount();
        BigDecimal bidDec = new BigDecimal(total);
        return bidDec.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
