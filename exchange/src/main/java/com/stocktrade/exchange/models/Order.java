package com.stocktrade.exchange.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STOCKORDER")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    private String symbol;
    private int price;
    private boolean buy;
    int nos;
    Date date;
    private OrderStatus status;
    int remaining;
}
