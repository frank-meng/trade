package com.stocktrade.trader.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Order {

    private Integer id;

    private String  accountName;

    private String symbol;
    private int price;

    private boolean buy;
    int nos;

    Date date;
    private OrderStatus status;

    int remaining;

}
