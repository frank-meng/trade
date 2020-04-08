package com.stocktrade.trader.controllers;

import com.stocktrade.trader.dto.AccountDto;
import com.stocktrade.trader.models.*;
import com.stocktrade.trader.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class TraderController {

    @Autowired
    private TraderRepository traderRepository;
    @Autowired
    private AccountRepository acountRepository;

    static int TRADER_ID;

    @Autowired
    private ExchangeService exchange;

    @PostMapping("/traders")
    @ResponseStatus(HttpStatus.CREATED)


    public Trader registerTrader(@Valid @RequestBody Trader trader){

        Trader returnedTrader = exchange.registerTrader(trader);
        TRADER_ID = returnedTrader.getId();

        returnedTrader = traderRepository.save(returnedTrader);
        return returnedTrader;
    }


    @GetMapping("/traders/{id}")
    public Trader getTrader(@PathVariable("id") int traderId){

        return traderRepository.findById(traderId);
    }


    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account registerAccount(@Valid @RequestBody Account acct){

        System.out.println("******         "+acct.toString());
        AccountDto dto = new AccountDto();
        dto.setName(acct.getName());
        dto.setPassword(acct.getPassword());
        dto.setTraderId(TRADER_ID);

        exchange.registerAccount(dto);
        acct = acountRepository.save(acct);
        return acct;
    }
    @GetMapping("/accounts/{name}")
    public Account getAccount(@PathVariable("name") String acctId){

        return acountRepository.findByName(acctId);
    }



}
