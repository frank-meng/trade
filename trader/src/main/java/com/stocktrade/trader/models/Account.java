package com.stocktrade.trader.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

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

}
