package com.wg.service;

import com.wg.domain.ShoppingInf;

/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc
 */


public interface ValidateAndParseService {
    public ShoppingInf validateAndParse(String param,ShoppingInf shoppingInf);
}
