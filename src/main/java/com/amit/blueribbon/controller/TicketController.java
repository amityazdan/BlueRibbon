package com.amit.blueribbon.controller;


import com.amit.blueribbon.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<?> checkTicketAvailable(@PathVariable Long id) {
        log.info("rest request to find if ticket is available for id {}", id);
        try {
            return new ResponseEntity<>(ticketService.checkTicketAvailable(id), HttpStatus.OK);
        } catch (Exception e) {
            log.warn("there is no ticket for id {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}
