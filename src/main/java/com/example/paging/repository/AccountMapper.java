package com.example.paging.repository;

import com.example.paging.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface AccountMapper {
    int count();
    List<Account> select(final RowBounds rowBounds);
}
