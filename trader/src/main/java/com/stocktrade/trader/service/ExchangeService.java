package com.stocktrade.trader.service;

import com.stocktrade.trader.dto.AccountDto;
import com.stocktrade.trader.dto.ExchangeBid;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.dto.Stock;
import com.stocktrade.trader.models.Trader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface ExchangeService {

    public Trader registerTrader(Trader trader);

    public void registerAccount(AccountDto dto);

    public void list(ExchangeIpo ipo);


    public ExchangeBid bid(ExchangeBid req);

}
