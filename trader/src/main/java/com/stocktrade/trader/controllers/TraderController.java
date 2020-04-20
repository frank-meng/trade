package com.stocktrade.trader.controllers;

import com.stocktrade.trader.TraderConfig;
import com.stocktrade.trader.dto.ExchangeAccount;
import com.stocktrade.trader.exceptions.UserNotFoundException;
import com.stocktrade.trader.models.*;
import com.stocktrade.trader.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class TraderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository acountRepository;

    @Autowired
    private ExchangeService exchange;

    @Autowired
    private TraderConfig config;

    /*
    @PostMapping("/traders")
    @ResponseStatus(HttpStatus.CREATED)

    public Trader registerTrader(@Valid @RequestBody Trader trader){

        Trader returnedTrader = exchange.registerTrader(trader);
        TRADER_ID = returnedTrader.getId();
        return returnedTrader;
    }
*/


    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/users/{name}")
    public User getUser(@PathVariable("name") String userName){
        return userRepository.findByName(userName);
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(@PathVariable("name") String userName) throws UserNotFoundException {
        User u = userRepository.findByName(userName);
        if (u == null) throw new UserNotFoundException();


        return u.getAccounts();
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account registerAccount(@Valid @RequestBody Account acct) throws UserNotFoundException {

        User u = userRepository.findByName(acct.getUserName());

        if (u == null) throw new UserNotFoundException();

        ExchangeAccount ea = new ExchangeAccount();
        ea.setName(acct.getName());
        ea.setTraderId(config.getTraderId());

        exchange.registerAccount(ea);

        acct.setUser(u);
        acct = acountRepository.save(acct);
        return acct;
    }

    @GetMapping("/accounts/{name}")
    public Account getAccount(@PathVariable("name") String acctName){
        return exchange.getAccount (acctName);
    }

}
