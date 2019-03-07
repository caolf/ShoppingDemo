package com.wg.commons.util;
/**
 * @Author clf
 * @Date 2019/2/26
 * @Desc
 */
public class StringUtil {

    public static boolean isEmpty(Object object) {
        if (object == null || object.equals("") || object.equals("null"))
            return true;
        return false;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static Double string2Double(String str){
        if(isEmpty(str))
            return null;
        Double data=null;
        try {
            data=new Double(str.trim());
        }catch (Exception e){
            //e.printStackTrace();
            return null;
        }
        return data;
    }

    public static Integer string2Integer(String str){
        if(isEmpty(str))
            return null;
        Integer data=null;
        try {
            data=new Integer(str.trim());
        }catch (Exception e){
            //e.printStackTrace();
            return null;
        }
        return data;
    }

    public static String doubleFormat2String(Double d){
        if (d!=null)
            return new java.text.DecimalFormat("#.00").format(d);
        else
            return null;
    }
}
