package com.stocktrade.exchange.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HOLDING")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Position {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference
    private Account account;

    private String symbol;
    private int nos;
    private int bookPrice;

    private Date date;
}
