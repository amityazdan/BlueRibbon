package com.amit.blueribbon.repository;

import com.amit.blueribbon.Entity.Baggage;
import com.amit.blueribbon.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Long> {

    Baggage findFirstByBaggageIdAndDestinationId(String baggage, Long destination);
}
