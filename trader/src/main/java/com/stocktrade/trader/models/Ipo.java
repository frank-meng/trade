package com.stocktrade.trader.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Ipo {

    private String symbol;

    private String name;

    private int offerPrice;

    int nos;

    String accountName;

}
