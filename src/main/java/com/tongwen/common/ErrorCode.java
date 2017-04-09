package com.tongwen.common;

/**
 * Created by tongwen on 2017/3/24.
 */
public enum ErrorCode {
    Success(0, "成功"),
    Error(1, "对不起，操作失败"),
    WebInvalidParam(2, "输入参数格式不正确"),


    ErrWebCommonBase(10000000, "Web通用失败码起始值"),
    ErrWebServiceException(ErrWebCommonBase.code + 1, "web服务发生异常"),
    ErrSessionTimeout(ErrWebCommonBase.code + 2, "Session超时，请重新登录");


    private String msg;
    private int code;

    private ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
