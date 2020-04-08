package com.stocktrade.trader.service;

import com.stocktrade.trader.dto.AccountDto;
import com.stocktrade.trader.dto.ExchangeBid;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.dto.Stock;
import com.stocktrade.trader.models.Trader;
import feign.Headers;
import feign.RequestLine;

public interface Exchange {

    @RequestLine("POST /traders")
    @Headers("Content-Type: application/json")
    Trader registerTrader(Trader trader);


    @RequestLine("POST /accounts")
    @Headers("Content-Type: application/json")
    void registerAccount(AccountDto dto);


    @RequestLine("POST /stocks/list")
    @Headers("Content-Type: application/json")
    Trader listStock(ExchangeIpo stock);

    @RequestLine("POST /bids")
    @Headers("Content-Type: application/json")
    ExchangeBid bid(ExchangeBid req);

}
