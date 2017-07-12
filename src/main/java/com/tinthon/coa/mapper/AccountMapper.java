package com.tinthon.coa.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by sidne on 2017/7/12.
 */
@Repository
public interface AccountMapper {
    List<Map> findAll();
}
