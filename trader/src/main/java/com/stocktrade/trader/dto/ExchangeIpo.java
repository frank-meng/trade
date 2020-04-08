package com.stocktrade.trader.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ExchangeIpo {
    private String symbol;

    private String name;
    int traderId;  //tobe removed

    int nos;

    public ExchangeIpo(String symbol, String name, int nos) {
        this.symbol = symbol;
        this.name = name;
        this.nos = nos;
    }

}
