package com.tinthon.coa.mapper;

import com.tinthon.coa.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}