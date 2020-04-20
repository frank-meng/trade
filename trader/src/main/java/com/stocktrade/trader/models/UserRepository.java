package com.stocktrade.trader.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);

}
