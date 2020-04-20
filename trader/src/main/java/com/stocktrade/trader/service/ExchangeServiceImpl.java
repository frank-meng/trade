package com.stocktrade.trader.service;

import com.stocktrade.trader.TraderConfig;
import com.stocktrade.trader.dto.ExchangeAccount;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.models.Account;
import com.stocktrade.trader.models.Order;
import com.stocktrade.trader.models.Stock;
import com.stocktrade.trader.models.Trader;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService{

    @Autowired
    private TraderConfig myConfig;

    ServerInterface exchangeClient;

    public ExchangeServiceImpl(TraderConfig c) {
        this.myConfig =c;

        System.out.println(" *****8**  "+ myConfig.getExchangeURL());

        exchangeClient =Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(ServerInterface.class, myConfig.getExchangeURL());
    }

    @Override
    public Trader registerTrader(Trader trader) {
        Trader returnedTrader = exchangeClient.registerTrader(trader);
        return returnedTrader;
    }

    @Override
    public void registerAccount(ExchangeAccount dto){
        exchangeClient.registerAccount(dto);
    }

    @Override
    public Account getAccount(String accountName){
        return exchangeClient.getAccount(accountName);
    }

    @Override
    public void list(ExchangeIpo ipo) {
        exchangeClient.listStock(ipo);
    }

    @Override
    public Stock getQuote(String symbol){
        return exchangeClient.getQuote(symbol);
    }


    @Override
    public Integer placeOrder(Order req){
        return exchangeClient.placeOrder(req);

    }

    @Override
    public Order checkOrder(Integer orderId) {
        return exchangeClient.checkOrder(orderId);
    }

    @Override
    public List<Order> getOrdersByAccount(String accountName) {
        return exchangeClient.getOrdersByAccount(accountName);
    }


}
