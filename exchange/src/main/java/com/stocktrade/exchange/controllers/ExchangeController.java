package com.stocktrade.exchange.controllers;


import com.stocktrade.exchange.dto.AccountDto;
import com.stocktrade.exchange.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor

@RestController
public class ExchangeController {

    @Autowired
    private  TraderRepository traderRepository;

    @Autowired
    private AccountRepository acountRepository;

    @PostMapping("/traders")
    @ResponseStatus(HttpStatus.CREATED)

    public Trader registerTrader(@Valid @RequestBody Trader trader){

        trader = traderRepository.save(trader);
        return trader;
    }

    @GetMapping("/traders/{id}")
    public Trader getTrader(@PathVariable("id") int traderId){

        return traderRepository.findById(traderId);
    }


    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody AccountDto dto){
        int tId = dto.getTraderId();

        System.out.println("******         "+dto.toString());
        Trader trader = traderRepository.findById(tId);

        Account acct = new Account();
        acct.setBalance(dto.getBalance());
        acct.setName(dto.getName());
        acct.setBuyingPower(dto.getBuyingPower());
        acct.setPassword(dto.getPassword());
        acct.setTrader(trader);

      //  acct = acountRepository.save(acct);

        trader.getAccounts().add(acct);

        traderRepository.save(trader);
    }
    @GetMapping("/accounts/{name}")
    public Account getAccount(@PathVariable("name") String acctId){

        return acountRepository.findByName(acctId);
    }

}
