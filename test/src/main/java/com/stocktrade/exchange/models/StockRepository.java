package com.stocktrade.exchange.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface StockRepository extends CrudRepository<Stock, String> {

    Stock findBySymbol(String symbol);


}
