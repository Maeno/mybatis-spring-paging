package com.example.paging.controller;

import com.example.paging.api.Page;
import com.example.paging.api.PageCondition;
import com.example.paging.domain.Account;
import com.example.paging.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/paging")
@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ModelAndView list () {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        final PageCondition pageCondition = new PageCondition(1, 20);
        Page<Account> page = accountService.list(pageCondition);
        modelAndView.addObject("accountList", page.getItems());
        modelAndView.addObject("page", page.getPageInformation());
        return modelAndView;
    }
}
