package com.stocktrade.exchange.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Stock stock;

    @OneToOne(cascade = CascadeType.ALL)
    private Bid buyer;

    @OneToOne(cascade = CascadeType.ALL)
    private Bid seller;

    private int price;

    int nos;

    Date date;

}
