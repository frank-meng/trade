package com.stocktrade.trader.controllers;

import com.stocktrade.trader.TraderConfig;
import com.stocktrade.trader.dto.ExchangeAccount;
import com.stocktrade.trader.exceptions.UserNotFoundException;
import com.stocktrade.trader.models.*;
import com.stocktrade.trader.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
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


    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/api/users/{name}")
    public User getUser(@PathVariable("name") String userName){
        return userRepository.findByName(userName);
    }

    @GetMapping("/api/user/info")
    public User getUserInfo(@AuthenticationPrincipal Jwt principal) {

        Map<String, Object> userMap =  Collections.singletonMap("user_name", principal.getClaimAsString("preferred_username"));
        String userName = userMap.get("user_name").toString();

        return userRepository.findByName(userName);

    }

    @GetMapping("/api/accounts")
    public List<Account> getAccounts(@AuthenticationPrincipal Jwt principal) throws UserNotFoundException {

        Map<String, Object> userMap =  Collections.singletonMap("user_name", principal.getClaimAsString("preferred_username"));
        String userName = userMap.get("user_name").toString();

        User u = userRepository.findByName(userName);
        if (u == null) throw new UserNotFoundException();


        return u.getAccounts();
    }

    @PostMapping("/api/accounts")
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

    @GetMapping("/api/accounts/{name}")
    public Account getAccount(@PathVariable("name") String acctName){
        return exchange.getAccount (acctName);
    }

}
