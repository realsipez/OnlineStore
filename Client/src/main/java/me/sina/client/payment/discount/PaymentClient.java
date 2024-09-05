package me.sina.client.payment.discount;

import me.sina.client.common.UrlConstants;
import me.sina.client.payment.discount.dto.CouponDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("PAYMENT")
public interface PaymentClient {

    @GetMapping(UrlConstants.DISCOUNT_GET_API_URL)
    CouponDTO findByCouponCode(@PathVariable("code") String code);

    @PostMapping("/api/v1/payment/pay/{totalPrice}")
    String pay(@PathVariable("totalPrice") String totalPrice);

}
