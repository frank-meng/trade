package com.stocktrade.exchange.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    Transaction findById(int id);

    List<Transaction> findByBuyer(Bid bid);
    List<Transaction> findBySeller(Bid bid);

    List<Transaction> findByStock(Stock stock);

}
