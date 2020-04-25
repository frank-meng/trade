package com.stocktrade.exchange.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "STOCKS")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Stock {

    @Id
    private String symbol;

    private int lastPrice;

}
