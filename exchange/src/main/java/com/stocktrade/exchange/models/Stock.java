package com.stocktrade.exchange.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Stock {

    @Id
    private String symbol;

    private String name;

    private int lastPrice;

    private int nos;   //ipo

    public Stock(String symbol) {
        this.symbol = symbol;
    }

}
