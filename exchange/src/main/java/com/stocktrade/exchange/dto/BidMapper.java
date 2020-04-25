package com.stocktrade.exchange.dto;

import com.stocktrade.exchange.models.Order;

import java.util.Date;

public class BidMapper {

    public static OrderDto convertBidToBidDto(Order order){

        OrderDto dto = new OrderDto();
        //set value back
        dto.setId(order.getId());
        dto.setDate(order.getDate());
        dto.setPrice(order.getPrice());
        dto.setSymbol(order.getSymbol());
        dto.setStatus(order.getStatus());
        dto.setRemaining(order.getRemaining());
        dto.setAccountName(order.getAccount().getName());

        return dto;
    }

    public static Order convertBidDtoToBid(OrderDto dto){

        Order order = new Order();
        //set value back

        order.setBuy(dto.isBuy());
        order.setSymbol(dto.getSymbol());
        order.setPrice(dto.getPrice());
        order.setDate(new Date());
        order.setStatus(dto.getStatus());
        order.setNos(dto.getNos());
        order.setRemaining(dto.getNos());
        return order;
    }
}
