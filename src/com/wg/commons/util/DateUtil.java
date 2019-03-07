package com.wg.commons.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc
 */

public class DateUtil {

    //日期格式
    private final static String DATEFORMAT = "yyyy.MM.dd";


    //日期解析
    public static Date dateParse(String date) {
        Date format = null;
        DateFormat df = new SimpleDateFormat(DATEFORMAT);
        try {
            format = df.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            format = null;
        }
        return format;
    }

    /**
     * 日期比较
     *
     * @param sourceDate 源日期
     * @param targetTate 目标日期
     * @return 大于：1，等于：0；小于-1
     */
    public static int compareDate(String sourceDate, String targetTate) {

        if (StringUtil.isEmpty(sourceDate) && StringUtil.isEmpty(targetTate)) {
            return 0;
        }

        if (StringUtil.isEmpty(sourceDate) && StringUtil.isNotEmpty(targetTate)) {
            return -1;
        }

        if (StringUtil.isNotEmpty(sourceDate) && StringUtil.isEmpty(targetTate)) {
            return 1;
        }
        DateFormat df = new SimpleDateFormat(DATEFORMAT);
        Date dt1;
        Date dt2;
        try {
            dt1 = df.parse(sourceDate);
            dt2 = df.parse(targetTate);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (ParseException e) {

        }

        return 0;
    }
}
