package com.tinthon.coa.mapper;

import com.tinthon.coa.model.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}