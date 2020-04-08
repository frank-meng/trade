package com.stocktrade.trader.models;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource()
public interface BidRepository extends CrudRepository<Bid, Integer> {

    Bid findById(int id);

   // @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
 //   @Transactional(readOnly = true)
    List<Bid> findByAccount(Account account);





}
