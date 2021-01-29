package com.amit.blueribbon.service;


import com.amit.blueribbon.CouponDTO;
import com.amit.blueribbon.Entity.Coupon;
import com.amit.blueribbon.Entity.Ticket;
import com.amit.blueribbon.repository.CouponRepository;
import com.amit.blueribbon.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class CouponService {

    private CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public double useCoupon(CouponDTO couponDTO) {
        Coupon coupon = couponRepository.findById(couponDTO.getCouponId()).orElse(null);
        if (coupon == null || !coupon.isValid()) {
            log.info("coupon not valid");
            return couponDTO.getPrice();
        }
        coupon.setValid(false);
        couponRepository.save(coupon);
        return couponDTO.getPrice() * (1 - randomDiscount());
    }

    private Double randomDiscount() {
        List<Double> dis = new ArrayList<>();
        dis.add(0.10);
        dis.add(0.50);
        dis.add(0.60);
        int rnd = new Random().nextInt(dis.size());
        return dis.get(rnd);
    }
}
