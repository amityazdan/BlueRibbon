package com.amit.blueribbon.controller;


import com.amit.blueribbon.service.BaggageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class CheckingController {


    private BaggageService baggageService;

    public CheckingController(BaggageService baggageService) {
        this.baggageService = baggageService;
    }

    @GetMapping("/checking")
    public boolean checkinSucceeded(@RequestParam(name = "baggageId") String baggageId,
                                    @RequestParam(name = "destinationId") Long destinationId) {
        log.info("rest request to check id baggage is checked in for baggage id {}", baggageId);
        return baggageService.checkinSucceeded(baggageId, destinationId);
    }
}
