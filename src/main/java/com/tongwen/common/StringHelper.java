package com.tongwen.common;

/**
 * 操作String的公共方法类
 * Created by tongwen on 2017/3/23.
 */
public class StringHelper {
    /**
     * 判断string是否为null或者空字符串
     * @param str
     * @return
     */
    public static boolean isStringNullOrEmpty(String str){
        if(null == str || str.trim().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
