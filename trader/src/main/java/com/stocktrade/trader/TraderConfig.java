package com.stocktrade.trader;



import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@ConfigurationProperties(prefix="exchange")

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Getter
@Setter
public class TraderConfig {

    @Value("${exchangeURL}")
    private String exchangeURL;

    @Value("${traderId}")
    private Integer traderId;

}
