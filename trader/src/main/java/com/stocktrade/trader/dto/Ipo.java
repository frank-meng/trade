package com.stocktrade.trader.dto;

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

    int traderId;  //tobe removed

}
