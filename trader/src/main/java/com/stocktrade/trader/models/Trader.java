package com.stocktrade.trader.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TRADER")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Trader {
    @Id
    int id;

    private String secretKey;
    int balance;
    String name;
}
