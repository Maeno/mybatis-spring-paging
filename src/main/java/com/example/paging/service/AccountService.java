package com.example.paging.service;

import com.example.paging.api.Page;
import com.example.paging.api.PageConditon;
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

    public Page<Account> list(final PageConditon pageConditon) {
        final int count = accountMapper.count();
        pageConditon.setTotalRecords(count);

        final int totalPages = (int)Math.ceil(count / pageConditon.getPageSize());
        pageConditon.setTotalPages(totalPages);

        if (pageConditon.getPageNo() == 1) {
            pageConditon.setFirst(true);
            pageConditon.setLast(false);
        } else if (pageConditon.getPageNo() == pageConditon.getTotalPages()) {
            pageConditon.setFirst(false);
            pageConditon.setLast(true);
        } else {
            pageConditon.setFirst(true);
            pageConditon.setLast(true);
        }

        final Page<Account> page = new Page<Account>();
        page.setPageConditon(pageConditon);

        final int offset = (pageConditon.getPageNo() - 1) * pageConditon.getPageSize();
        final int limit = pageConditon.getPageSize();

        final List<Account> select = accountMapper.select(new RowBounds(offset, limit));
        page.setItems(select);

        return page;
    }
}
