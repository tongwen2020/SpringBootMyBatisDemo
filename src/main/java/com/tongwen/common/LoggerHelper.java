package com.tongwen.common;

import org.hibernate.validator.internal.util.*;
import org.slf4j.Logger;
/**
 * Created by tongwen on 2017/4/8.
 */
public final class LoggerHelper {

    private Logger logger;
    public LoggerHelper(Class<?> clazz){
        logger = org.slf4j.LoggerFactory.getLogger(clazz.getName());
    }

    /*
        error级别打印
     */
    public void error(ErrorCode errorCode){
        logger.error(String.format("ErrorCode: %s(%d), %s", errorCode.toString(), errorCode.getCode(), errorCode.getMsg()));
    }

    /*
        error级别打印
     */
    public void error(ErrorCode errorCode, String errMsg){
        String msg = errMsg;
        if(StringHelper.isStringNullOrEmpty(msg)){
            msg = errorCode.getMsg();
        }
        logger.error(String.format("ErrorCode: %s(%d), %s", errorCode.toString(), errorCode.getCode(), msg));
    }

    /*
        info级别打印
     */
    public void info(String errMsg){
        String msg = errMsg;
        if(StringHelper.isStringNullOrEmpty(msg)){
            msg = "";
        }
        logger.info(msg);
    }

    /*
        fatal级别打印
     */
    public void fatal(ErrorCode errCode, String errMsg, Exception ex){

        logger.error(
                String.format("encounter exception: %s(%d), %s",
                        errCode.toString(),errCode.getCode(),errMsg),
                ex);
    }
}
