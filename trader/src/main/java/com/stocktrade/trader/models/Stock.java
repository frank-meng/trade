package com.stocktrade.trader.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Stock {

    private String symbol;

    private int lastPrice;

}