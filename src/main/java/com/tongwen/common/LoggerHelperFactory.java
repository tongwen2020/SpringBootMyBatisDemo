package com.tongwen.common;

import org.slf4j.Logger;

/**
 * Created by tongwen on 2017/4/9.
 */
public final class LoggerHelperFactory {

    private LoggerHelperFactory(){

    }

    public static LoggerHelper getLoggerHelper(Class<?> clazz){
        return new LoggerHelper(clazz);
    }
}
