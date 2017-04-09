package com.tongwen.service;

import com.tongwen.dao.mapper.TestMapper;
import com.tongwen.dao.model.TestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * Created by tongwen on 2017/3/22.
 */
@Service
public class TestService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestMapper testMapper;

    public TestModel getModel(Long id){
//        TestModel model = new TestModel();
//        model.setId(1L);
//        model.setName("Hello");
//        return model;
        return testMapper.showModel(id);
    }

    public boolean addNewModel(TestModel model){
        TestModel tmpModel = new TestModel();
        tmpModel.setName(model.getName());
        tmpModel.setId(0L);
        try {
            int retCode = testMapper.addModel(tmpModel);
            if(retCode != 1){
                return false;
            }else{
                return true;
            }
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            return false;
        }
    }

    public boolean updateNameById(Long id, String name){
        try{
            int retCode = testMapper.updateNameById(id, name);
            if(retCode < 1){
                log.error("updateNameById fail, id=" + id);
                return false;
            }else{
                return true;
            }
        }catch (Exception ex){
            log.error("updateNameById fail, exception occur:" + ex.getMessage());
            return false;
        }
    }

    public boolean update(TestModel model){
        if(null == model){
            log.error("In param error!");
            return false;
        }

        try{
            int retCode = testMapper.update(model);
            if(retCode < 1){
                log.error("update model fail, id=" + model.getId());
                return false;
            }else{
                return true;
            }
        }catch (Exception ex){
            log.error("update model fail, exception occur:" + ex.getMessage());
            return false;
        }
    }

    public boolean deleteById(Long id){
        try{
            int retCode = testMapper.deleteById(id);
            if(retCode < 1){
                log.error("deleteById  fail, id=" + id);
                return false;
            }else{
                return true;
            }
        }catch (Exception ex){
            log.error("deleteById fail, exception occur:" + ex.getMessage());
            return false;
        }
    }
}
