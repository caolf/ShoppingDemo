package com.wg.test.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author clf
 * @Date 2019/2/27
 * @Desc
 */

public class DateUtilTest {

    @Test
    public void testDateFormat() throws ParseException {
        //assertNotNull( DateUtil.dateFormat("2014-03-02").toString());
        String newTime = "2014-03-02";
        //设置时间格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("y-M-d");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MMM-ddd");
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyyy-MMMM-dddd");

        System.out.println(sdf2.parse(newTime));
        Date date=sdf2.parse(newTime);
        System.out.println(sdf1.format(date)+"  ;"+sdf2.format(date)+" ;"+sdf3.format(date)+"   ;"+sdf4.format(date));
    }
}
