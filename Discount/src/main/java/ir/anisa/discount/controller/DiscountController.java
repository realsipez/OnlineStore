package ir.anisa.discount.controller;

import ir.anisa.discount.dto.CouponDTO;
import ir.anisa.discount.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }


    @PostMapping("/add")
    public CouponDTO createCoupon(@RequestBody CouponDTO couponDTO) {
        return discountService.createCoupon(couponDTO);
    }


    @GetMapping("/get/{code}")
    public CouponDTO findByCouponCode(@PathVariable("code") String code) {
        return discountService.loadCouponByCode(code);
    }
}
