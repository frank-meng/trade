package com.stocktrade.exchange.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT")

@ToString
@Getter @Setter  @NoArgsConstructor

public class Account implements Serializable {

    private @Id String name;
    private int buyingPower;
    private int balance;
    private String password;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Trader trader;

}
