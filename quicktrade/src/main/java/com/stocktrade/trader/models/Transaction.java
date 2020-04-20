package com.stocktrade.trader.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    private Integer id;

    @JsonBackReference
    private Account account;

    private String symbol;
    private boolean buy;
    private int price;
    int nos;
    Date date;
}
