package com.stocktrade.trader.dto;


import com.stocktrade.trader.models.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ExchangeBid {
    private Integer id;

    int trader;  //tobe removed

    private String account;

    private String symbol;
    private int price;

    private boolean buy;
    int nos;
    int status;
    int remaining;
    Date date;
}
