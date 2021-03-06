package com.stocktrade.exchange.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    Transaction findById(int id);
    List<Transaction> findByAccount(Account account);


    List<Transaction> findBySymbol(String symbol);

}
