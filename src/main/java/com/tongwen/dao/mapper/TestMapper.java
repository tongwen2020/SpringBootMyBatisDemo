package com.tongwen.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;
import com.tongwen.dao.model.*;
import org.springframework.stereotype.Repository;

/**
 * Created by tongwen on 2017/3/22.
 */
@Mapper
@Repository
public interface TestMapper {
    TestModel showModel(Long id);

    int addModel(TestModel model);

    int updateNameById(Long id, String name);

    int update(TestModel model);

    int deleteById(Long id);
}
