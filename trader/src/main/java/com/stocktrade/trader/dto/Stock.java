package com.stocktrade.trader.dto;

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

    private String name;

    private int lastPrice;

}