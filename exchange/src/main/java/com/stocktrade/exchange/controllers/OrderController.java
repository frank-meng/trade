package com.stocktrade.exchange.controllers;

import com.stocktrade.exchange.dto.OrderDto;
import com.stocktrade.exchange.dto.BidMapper;
import com.stocktrade.exchange.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private PositionRepository positionRepository;

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)

    public int placeOrder(@Valid @RequestBody OrderDto dto) throws Exception {

        int tId = dto.getTraderId();

        Trader trader = traderRepository.findById(tId);

        Account account = accountRepository.findByName(dto.getAccountName());

        // validate trader and account
        if (account ==null) {
            throw new Exception(" unknown account");
        }

        Order order =  BidMapper.convertBidDtoToBid(dto);

        order.setAccount(account);

        order.setStatus(OrderStatus.OPEN); // open
        order = orderRepository.save(order);

        return order.getId();
    }

    @GetMapping("/orders/{id}")
    public OrderDto getOrder(@PathVariable("id") int orderId) throws Exception {
        Order order = orderRepository.findById(orderId);
        if (order ==null) throw new Exception("unknown order");
        return BidMapper.convertBidToBidDto(order);
    }

    @GetMapping("/orders/account/{accountName}")
    public List<OrderDto> getBidsByAccount(@PathVariable("accountName") String accountName){
        Account account = accountRepository.findByName(accountName);

        return orderRepository.findByAccount(account)
                .stream().map(BidMapper::convertBidToBidDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/holdings/account/{accountName}")
    public List<Position> getHoldingsByAccount(@PathVariable("accountName") String accountName){
        Account account = accountRepository.findByName(accountName);

        return positionRepository.findByAccount(account);
    }


}
