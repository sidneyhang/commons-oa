package com.tinthon.coa.mapper;

import com.tinthon.coa.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}