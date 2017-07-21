package com.tinthon.coa.mapper;

import com.tinthon.coa.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccountMapper {

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> findListByOption(Account account);

    Account findByOption(Account account);
}