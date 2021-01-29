package com.amit.blueribbon.controller;


import com.amit.blueribbon.CouponDTO;
import com.amit.blueribbon.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class CouponController {

    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }



    @PutMapping("/coupon")
    public ResponseEntity<?> useCoupon(@RequestBody CouponDTO couponDTO) {
        log.info("rest request to use coupon{}", couponDTO.getCouponId());
        double newPrice = couponService.useCoupon(couponDTO);
        return new ResponseEntity<>(newPrice, HttpStatus.OK);
    }


}
