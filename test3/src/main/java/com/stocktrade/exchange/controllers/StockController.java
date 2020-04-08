package com.stocktrade.exchange.controllers;


import com.stocktrade.exchange.dto.AccountDto;
import com.stocktrade.exchange.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private TraderRepository traderRepository;



    @PostMapping("/stocks/list")
    public Stock addStock( @Valid @RequestBody Stock stocks){
        stocks = stockRepository.save(stocks);
        return stocks;
    }


    @GetMapping("/stocks/{symbol}")
    public Stock getStock(@PathVariable("symbol") String symbol){
        return stockRepository.findBySymbol(symbol.toUpperCase());
    }

    @GetMapping("/quote/{symbol}")
    public Integer getQuote(@PathVariable("symbol") String symbol){
        return stockRepository.findBySymbol(symbol.toUpperCase()).getLastPrice();
    }
}
