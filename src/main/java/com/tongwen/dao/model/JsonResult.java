package com.tongwen.dao.model;

/**
 * Created by tongwen on 2017/3/22.
 */
public class JsonResult {
    private int code;
    private String message;
    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
    public  JsonResult(int code,String message){
        this.code = code;
        this.message =message;
    }
}
