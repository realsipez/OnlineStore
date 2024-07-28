package ir.anisa.client.discount;

import ir.anisa.client.common.UrlConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DISCOUNT")
public interface DiscountClient {

    @GetMapping(UrlConstants.DISCOUNT_GET_API_URL)
    CouponDTO findByCouponCode(@PathVariable("code") String code);

}
