package me.sina.client.order;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ORDER")
public interface OrderClient {

}
