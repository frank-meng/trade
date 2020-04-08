package com.stocktrade.exchange.models;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface TraderRepository extends CrudRepository<Trader, Integer> {

    List<Trader> findByName(String name);

    Trader findById(int id);

}
