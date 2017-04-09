package com.tongwen.common;

import com.tongwen.dao.model.JsonResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 * Created by tongwen on 2017/4/5.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private final LoggerHelper loggerHelper = LoggerHelperFactory.getLoggerHelper(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult json(Exception ex) {
        loggerHelper.fatal(ErrorCode.ErrWebServiceException, "unexpected exception:", ex);
        return new JsonResult(ErrorCode.ErrWebServiceException.getCode(), "app exception fault!");
    }
}
