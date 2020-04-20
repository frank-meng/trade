package com.stocktrade.exchange.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface PositionRepository extends CrudRepository<Position, Integer> {

    Position findById(int id);

    List<Position> findByAccount(Account account);


}
