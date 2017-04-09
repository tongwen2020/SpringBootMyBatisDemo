package com.tongwen.api;

import com.tongwen.dao.model.JsonResult;
import com.tongwen.dao.model.TestModel;
import com.tongwen.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tongwen on 2017/3/22.
 */
@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String index(){
        return "welcome to spring boot test controller!";
    }

    @RequestMapping("/model/{id}")
    public TestModel getModel(@PathVariable("id") Long id){
        return testService.getModel(id);
    }


    @RequestMapping(value="/add", method=RequestMethod.POST)
    public JsonResult addModel(@RequestBody TestModel model){

        if(testService.addNewModel(model)){
            return new JsonResult(0, "addModel success");
        }else{
            return new JsonResult(1, "addModel fail");
        }
    }

    @RequestMapping(value="/updateNameById", method = RequestMethod.POST)
    public JsonResult updateNameById(@RequestBody TestModel model){
        if(testService.updateNameById(model.getId(), model.getName())){
            return new JsonResult(0, "updateNameById success");
        }else{
            return new JsonResult(1, "updateNameById fail");
        }
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public JsonResult update(@RequestBody TestModel model){
        if(testService.update(model)){
            return new JsonResult(0, "update success");
        }else{
            return new JsonResult(1, "update fail");
        }
    }

    @RequestMapping(value="/deleteById/{id}", method = RequestMethod.POST)
    public JsonResult deleteById(@PathVariable("id")Long id){
        if(testService.deleteById(id)){
            return new JsonResult(0, "deleteById success");
        }else{
            return new JsonResult(1, "deleteById fail");
        }
    }

    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public JsonResult testException(){
        int num = 100 / 0;
        return new JsonResult(0, "testException!");
    }
}
