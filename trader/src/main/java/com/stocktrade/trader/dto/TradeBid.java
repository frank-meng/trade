package com.stocktrade.trader.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class TradeBid {
    private String account;
    private String symbol;
    private int price;
    int traderId;  //tobe removed
    private boolean buy;
    int nos;
}
