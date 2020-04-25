package com.stocktrade.exchange.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "TRADERS")

@Getter
@Setter
@NoArgsConstructor

@Data
@EqualsAndHashCode(exclude = "accounts")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;

    @NotBlank
    private String secretKey;

    @OneToMany(mappedBy = "trader", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    Set<Account> accounts;

    public Trader(Integer id) {
        this.id = id;
    }
}
