package com.tinthon.coa.mapper;

import com.tinthon.coa.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}