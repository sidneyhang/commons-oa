package com.tinthon.coa.mapper;

import com.tinthon.coa.model.Privilege;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeMapper {
    int insert(Privilege record);

    int insertSelective(Privilege record);
}