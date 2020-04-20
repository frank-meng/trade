package com.stocktrade.exchange.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;



@ToString
@Getter @Setter  @NoArgsConstructor

public class AccountDto implements Serializable {

    private String name;
    private Integer traderId;

}
