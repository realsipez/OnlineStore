package me.sina.client.product;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("PRODUCT")
public interface ProductClient {
}
