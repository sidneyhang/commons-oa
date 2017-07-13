package com.tinthon.coa.mapper;

import com.tinthon.coa.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccountMapper {

    List<Map> findAll();
}