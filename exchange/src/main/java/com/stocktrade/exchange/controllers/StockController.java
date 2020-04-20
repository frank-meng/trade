package com.stocktrade.exchange.controllers;


import com.stocktrade.exchange.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        Stock stock = stockRepository.findBySymbol(symbol.toUpperCase());

        if (stock ==null)
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Stock Symbol Not Found");

        return stock;
    }


}
