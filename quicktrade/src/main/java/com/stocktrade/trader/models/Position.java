package com.stocktrade.trader.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Position {
    private Integer id;

    @JsonBackReference
    private Account account;

    private String symbol;
    private int nos;
    private int bookPrice;

    private Date date;
}
