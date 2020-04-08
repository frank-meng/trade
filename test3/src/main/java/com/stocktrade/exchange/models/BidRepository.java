package com.stocktrade.exchange.models;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface BidRepository extends CrudRepository<Bid, Integer> {

    Bid findById(int id);

    List<Bid> findByTrader(Trader trader);


}
