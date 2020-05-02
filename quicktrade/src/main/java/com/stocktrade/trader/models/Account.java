package com.stocktrade.trader.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ACCOUNTS")

@Getter @Setter  @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Account implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;
    private String category;
    private int balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference
    private User user;

    @Transient
    private String userName;

    @Transient
    @JsonManagedReference
    private List<Position> holdings;

    @Transient
    @JsonManagedReference
    private List<Transaction> transactions;
}
