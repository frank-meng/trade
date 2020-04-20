package com.stocktrade.exchange.dto;

import com.stocktrade.exchange.models.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Integer id;

    private int traderId; ///?
    private String symbol;
    private String accountName;
    private int price;
    private boolean buy;
    int nos;
    Date date;

    //0 closed/withdrew
    // 1 pending
    // 2 partial filled
    // 3 completed
    // 4 locked
    OrderStatus status;
    int remaining;
}
