package com.wg.service;/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc
 */

import com.wg.commons.validate.ValidateResult;
import com.wg.domain.ShoppingInf;

import java.util.List; /**
 * @Name: ShoppingDemo
 *
 * @description:
 *
 * @author: clf
 *
 * @create: 2019-02-27 14:20
 */
public interface ProductCalService {
    Double cal(ShoppingInf shoppingInf);
}
