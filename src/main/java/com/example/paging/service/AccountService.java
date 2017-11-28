package com.example.paging.service;

import com.example.paging.api.Page;
import com.example.paging.api.PageCondition;
import com.example.paging.api.PageInformation;
import com.example.paging.domain.Account;
import com.example.paging.repository.AccountMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(final AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Page<Account> list(final PageCondition pageCondition) {
        final int count = accountMapper.count();

        final Page<Account> page = new Page<>();
        final PageInformation pageInformation =
                new PageInformation.Builder(pageCondition.getPageNo(), pageCondition.getPageSize())
                        .totalRecords(count).build();
        page.setPageInformation(pageInformation);

        final List<Account> select = accountMapper.select(
                new RowBounds(pageInformation.getOffset(), pageInformation.getLimit()));
        page.setItems(select);

        return page;
    }
}
