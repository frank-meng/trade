package com.stocktrade.trader.controllers;


import com.stocktrade.trader.TraderConfig;
import com.stocktrade.trader.dto.ExchangeIpo;
import com.stocktrade.trader.models.Ipo;
import com.stocktrade.trader.models.*;
import com.stocktrade.trader.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    ExchangeService exchange;

    @Autowired
    private TraderConfig config;

    @PostMapping("/api/stocks/ipo")
    @ResponseStatus(HttpStatus.CREATED)
    public Order startIpo(@Valid @RequestBody Ipo ipo){

        ExchangeIpo eipo = new ExchangeIpo(ipo.getSymbol(), ipo.getName(), ipo.getNos());
        //call exchange
        exchange.list(eipo);

        Order order = new Order();

        order.setBuy(false);
        order.setNos(ipo.getNos());
        order.setAccountName(ipo.getAccountName());
        order.setSymbol(ipo.getSymbol());
        order.setPrice(ipo.getOfferPrice());

        int orderId =  bidExchange(order);
        return exchange.checkOrder(orderId);
    }


    @GetMapping("/api/stocks/{symbol}")
    public Stock getStock(@PathVariable("symbol") String symbol){
        return exchange.getStock(symbol);
    }

    @PostMapping("/api/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer placerOrder(@Valid @RequestBody Order order){

        return bidExchange(order);
    }

    private Integer bidExchange(Order order){

        return exchange.placeOrder(order);
    }


    @GetMapping("/api/orders/{id}")
    public Order getOrder(@PathVariable("id") int orderId){

        Order order = exchange.checkOrder(orderId);
        if (order.getStatus()== OrderStatus.OPEN ) {


        }

        return order;
    }

    @GetMapping("/api/orders/account/{accountName}")
    public List<Order> getBid(@PathVariable("accountName") String accountName){

        List<Order> orders = exchange.getOrdersByAccount(accountName);

       // orders.forEach( s->{     System.out.println( s.getSymbol());   });
        return orders;
    }
}
