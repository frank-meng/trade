package com.stocktrade.trader.service;

import com.stocktrade.trader.dto.AccountDto;
import com.stocktrade.trader.dto.ExchangeBid;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.models.Trader;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService{

    Exchange exchange = Feign.builder()
            .decoder(new GsonDecoder())
            .encoder(new GsonEncoder())
            .target(Exchange.class, "http://localhost:8888");


    @Override
    public Trader registerTrader(Trader trader) {
        Trader returnedTrader = exchange.registerTrader(trader);
        return returnedTrader;
    }

    @Override
    public void registerAccount(AccountDto dto){
        exchange.registerAccount(dto);
    }

    @Override
    public void list(ExchangeIpo ipo) {
        exchange.listStock(ipo);
    }

    @Override
    public ExchangeBid bid(ExchangeBid req){
        return exchange.bid(req);

    }
}
