package com.stocktrade.trader.service;

import com.stocktrade.trader.dto.ExchangeAccount;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.models.Account;
import com.stocktrade.trader.models.Order;
import com.stocktrade.trader.models.Stock;
import com.stocktrade.trader.models.Trader;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface ServerInterface {

    @RequestLine("POST /traders")
    @Headers("Content-Type: application/json")
    Trader registerTrader(Trader trader);


    @RequestLine("POST /accounts")
    @Headers("Content-Type: application/json")
    void registerAccount(ExchangeAccount dto);

    @RequestLine("GET /accounts/{accountName}")
    @Headers("Content-Type: application/json")
    Account getAccount(@Param("accountName") String accountName);

    @RequestLine("POST /stocks/list")
    @Headers("Content-Type: application/json")
    Trader listStock(ExchangeIpo stock);

    @RequestLine("GET /stocks/{symbol}")
    @Headers("Content-Type: application/json")
    Stock getQuote(String symbol);

    @RequestLine("POST /orders")
    @Headers("Content-Type: application/json")
    Integer placeOrder(Order req);

    @RequestLine("GET /orders/{orderId}")
    @Headers("Content-Type: application/json")
    Order checkOrder(@Param("orderId") Integer orderId);

    @RequestLine("GET /orders/account/{accountName}")
    @Headers("Content-Type: application/json")
    List<Order> getOrdersByAccount(@Param("accountName") String accountName);

}
