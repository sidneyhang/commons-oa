package com.tinthon.coa.mapper;

import com.tinthon.coa.model.RolePrivilege;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivilegeMapper {
    int insert(RolePrivilege record);

    int insertSelective(RolePrivilege record);
}