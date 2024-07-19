package ir.anisa.discount.service;

import ir.anisa.discount.dto.CouponDTO;

public interface DiscountService {

    CouponDTO loadCouponByCode(String code);

    CouponDTO createCoupon(CouponDTO couponDTO);
}
