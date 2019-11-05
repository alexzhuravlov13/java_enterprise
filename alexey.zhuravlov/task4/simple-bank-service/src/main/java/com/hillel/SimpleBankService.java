package com.hillel;

import com.hillel.model.Account;
import com.hillel.service.AccountService;
import com.hillel.service.AccountServiceImpl;
import com.hillel.service.TestAccountService;
import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Log
@Component
@ComponentScan("com.hillel")
public class SimpleBankService {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleBankService.class);
        Account account1 = new Account(1, "Alex", 0.0, new ArrayList<>());
        Account account2 = new Account(2, "Ben", 0.0, new ArrayList<>());
        Account account3 = new Account(3, "Sam", 0.0, new ArrayList<>());
        Account account4 = new Account(4, "Gabe", 0.0, new ArrayList<>());

        AccountService accountService = ctx.getBean(AccountServiceImpl.class);
        AccountService testAccountService = ctx.getBean(TestAccountService.class);

        accountService.deposit(account1, 100.0);
        accountService.deposit(account2, 340.0);
        accountService.deposit(account3, 1000.0);

        testAccountService.deposit(account2, 100.0);

        accountService.transfer(account1, account2, 50);

        accountService.getAccStatement(account2);

    }
}


