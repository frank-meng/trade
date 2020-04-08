package com.stocktrade.trader.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BID")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Bid {

    @Id
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    private String symbol;
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

    public Bid(Integer id) {
        this.id = id;
    }

}
