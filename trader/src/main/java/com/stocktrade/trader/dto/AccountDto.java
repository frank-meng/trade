package com.stocktrade.trader.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@ToString
@Getter @Setter  @NoArgsConstructor

public class AccountDto implements Serializable {

    private String name;
    private int buyingPower;
    private int balance;
    private String password;

    private Integer traderId;

}
