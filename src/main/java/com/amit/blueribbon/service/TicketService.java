package com.amit.blueribbon.service;


import com.amit.blueribbon.Entity.Ticket;
import com.amit.blueribbon.cache.InMemoryCache;
import com.amit.blueribbon.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TicketService {

    private static final String TICKET_AVAILABLE = "ticket_available";
    private static final long EXPIRATION_TIME = 5 * 1000;
    private TicketRepository ticketRepository;
    private InMemoryCache inMemoryCache;

    public TicketService(TicketRepository ticketRepository,
                         InMemoryCache inMemoryCache) {
        this.ticketRepository = ticketRepository;
        this.inMemoryCache = inMemoryCache;
    }

    /**
     * @param id is the ticket id
     * @return if ticket is available
     *
     * throw exception if no ticket with this id
     */
    public boolean checkTicketAvailable(Long id) {
        Object inMemTickStatus = inMemoryCache.get(TICKET_AVAILABLE + id);

        if (inMemTickStatus == null) {
            log.info("ticket status saved in cache");
            Ticket ticket = ticketRepository.findById(id).orElseThrow();
            inMemoryCache.add(TICKET_AVAILABLE + id, ticket.isAvailable(), EXPIRATION_TIME);
            return ticket.isAvailable();
        }
        return Boolean.parseBoolean(inMemTickStatus.toString());
    }
}
