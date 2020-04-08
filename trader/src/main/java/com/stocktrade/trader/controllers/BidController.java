package com.stocktrade.trader.controllers;


import com.stocktrade.trader.dto.ExchangeBid;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.dto.Ipo;
import com.stocktrade.trader.dto.TradeBid;
import com.stocktrade.trader.models.*;
import com.stocktrade.trader.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BidController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BidRepository bidRepository;

    @Autowired
    ExchangeService exchange;

    @PostMapping("/stocks/ipo")
    @ResponseStatus(HttpStatus.CREATED)
    public Bid startIpo(@Valid @RequestBody Ipo ipo){

        ExchangeIpo eipo = new ExchangeIpo(ipo.getSymbol(), ipo.getName(), ipo.getNos());
        //call exchange
        exchange.list(eipo);

        ExchangeBid ebid = new ExchangeBid();
        ebid.setTrader(ipo.getTraderId());

        ebid.setBuy(false);
        ebid.setNos(ipo.getNos());
        ebid.setAccount(ipo.getAccountName());
        ebid.setSymbol(ipo.getSymbol());
        ebid.setPrice(ipo.getOfferPrice());


        return bid(ebid);
    }

    @PostMapping("/bids")
    @ResponseStatus(HttpStatus.CREATED)

    public Bid bid(@Valid @RequestBody TradeBid tbid){

        ExchangeBid ebid = new ExchangeBid();
        ebid.setTrader(tbid.getTraderId());
        ebid.setBuy(tbid.isBuy());
        ebid.setNos(tbid.getNos());
        ebid.setAccount(tbid.getAccount());
        ebid.setSymbol(tbid.getSymbol());
        ebid.setPrice(ebid.getPrice());
        return bid(ebid);
    }

    private Bid bid(ExchangeBid ebid){

        ebid = exchange.bid(ebid);

        //save bid
        Bid bid = new Bid();
        bid.setId(ebid.getId());
        bid.setSymbol(ebid.getSymbol());
        bid.setAccount(accountRepository.findByName(ebid.getAccount()));

        bid.setNos(ebid.getNos());
        bid.setBuy(ebid.isBuy());
        bid.setPrice(ebid.getPrice());
        bid.setStatus(ebid.getStatus());
        bid.setDate(ebid.getDate());
        bid.setRemaining(ebid.getRemaining());

        bid = bidRepository.save(bid);

        return bid;
    }


    @GetMapping("/bids/{id}")
    public Bid getBid(@PathVariable("id") int bidId){

        return bidRepository.findById(bidId);
    }
}
