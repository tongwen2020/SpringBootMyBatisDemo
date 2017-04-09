package com.tongwen.dao.model;

import org.springframework.context.annotation.Bean;

/**
 * Created by tongwen on 2017/3/22.
 */
public class TestModel {
    private Long id;
    private String name;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return  name;
    }
    public void setName(String name){
        this.name=name;
    }
}
