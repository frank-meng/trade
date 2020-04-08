package com.stocktrade.exchange.models;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findByName(String name);


}
