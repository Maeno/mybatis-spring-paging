package com.example.paging.controller;

import com.example.paging.api.Page;
import com.example.paging.api.PageConditon;
import com.example.paging.domain.Account;
import com.example.paging.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/paging")
@Controller
public class PagingController {

    private final AccountService accountService;

    @Autowired
    public PagingController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ModelAndView list () {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        final PageConditon pageConditon = new PageConditon(1, 20);
        Page<Account> page = accountService.list(pageConditon);
        modelAndView.addObject("accountList", page.getItems());
        modelAndView.addObject("page", page.getPageConditon());
        return modelAndView;
    }
}
