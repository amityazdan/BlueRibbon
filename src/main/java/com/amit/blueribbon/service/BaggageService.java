package com.amit.blueribbon.service;


import com.amit.blueribbon.Entity.Baggage;
import com.amit.blueribbon.repository.BaggageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaggageService {


    private BaggageRepository baggageRepository;

    public BaggageService(BaggageRepository baggageRepository) {
        this.baggageRepository = baggageRepository;
    }

    public boolean checkinSucceeded(String baggageId, Long destinationId) {
        Baggage baggage = baggageRepository.findFirstByBaggageIdAndDestinationId(baggageId, destinationId);
        log.info("checkin status for baggage for id {} is {}", baggageId, baggage.isCheckin());
        return baggage.isCheckin();
    }
}
