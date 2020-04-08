package com.stocktrade.exchange.dto;

import com.stocktrade.exchange.models.Trader;
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
public class BidDto {

    private Integer id;

    private int traderId;
    private String symbol;
    private String account;
    private int price;
    private boolean buy;
    int nos;
    Date date;

    //0 closed/withdrew
    // 1 pending
    // 2 partial filled
    // 3 completed
    // 4 locked
    int status;
    int remaining;
}
