package me.sina.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients(basePackages = {"me.sina.client.payment", "me.sina.client.order"})
public class ProductServer {
    public static void main(String[] args) {
        SpringApplication.run(ProductServer.class, args);
    }
}