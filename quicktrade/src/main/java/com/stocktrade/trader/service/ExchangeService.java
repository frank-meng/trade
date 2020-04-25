package com.stocktrade.trader.service;

import com.stocktrade.trader.dto.ExchangeAccount;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.models.Account;
import com.stocktrade.trader.models.Order;
import com.stocktrade.trader.models.Stock;
import com.stocktrade.trader.models.Trader;

import java.util.List;


public interface ExchangeService {

    public Trader registerTrader(Trader trader);

    public void registerAccount(ExchangeAccount dto);
    public Account getAccount(String accountName);

    public void list(ExchangeIpo ipo);

    public Stock getStock(String symbol);

    public Integer placeOrder(Order req);

    public Order checkOrder(Integer orderId);

    public List<Order> getOrdersByAccount(String accountName);

}
