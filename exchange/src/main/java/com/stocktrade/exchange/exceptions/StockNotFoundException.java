package com.stocktrade.exchange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Stock Symbol Not Found")
public class StockNotFoundException extends Exception {

    public StockNotFoundException(){

    }

}
