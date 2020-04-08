package com.stocktrade.trader.models;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findByName(String name);


}
