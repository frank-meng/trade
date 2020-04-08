package com.stocktrade.exchange.controllers;

import com.stocktrade.exchange.dto.BidDto;
import com.stocktrade.exchange.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class BidController {

    @Autowired
    private BidRepository bidRepository;


    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private StockRepository stockRepository;

    @PostMapping("/bids")
    @ResponseStatus(HttpStatus.CREATED)

    public BidDto bid(@Valid @RequestBody BidDto dto){


        Bid bid = new Bid();

        int tId = dto.getTraderId();

        Trader trader = traderRepository.findById(tId);

        bid.setTrader(trader);
        bid.setAccount(dto.getAccount());
        bid.setBuy(dto.isBuy());
        bid.setSymbol(dto.getSymbol());
        bid.setDate(new Date());

        bid.setStatus(1); // open

        bid.setRemaining(bid.getNos());

        bid = bidRepository.save(bid);


        //set value back
        dto.setId(bid.getId());
        dto.setDate(bid.getDate());
        dto.setStatus(1);
        bid.setRemaining(bid.getRemaining());
        return dto;
    }

    @GetMapping("/bids/{id}")
    public Bid getBid(@PathVariable("id") int bidId){

        return bidRepository.findById(bidId);
    }

}
