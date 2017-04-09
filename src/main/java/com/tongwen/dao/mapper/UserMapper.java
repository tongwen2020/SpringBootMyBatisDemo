package com.tongwen.dao.mapper;

import com.tongwen.dao.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by tongwen on 2017/4/8.
 */
@Mapper
@Repository
public interface UserMapper {
    UserModel showUser(String id);
}
