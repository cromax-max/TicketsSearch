package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeComparator;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketsManagerTest {

    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);
    Ticket ticket1 = new Ticket(100, 6500, "NAY", "NBH", 480);
    Ticket ticket2 = new Ticket(101, 7500, "NAY", "NBH", 300);
    Ticket ticket3 = new Ticket(102, 5500, "NAY", "NBH", 360);
    Ticket ticket4 = new Ticket(103, 5800, "ASF", "NBH", 360);
    Ticket ticket5 = new Ticket(104, 3500, "JOK", "VKT", 360);

    @BeforeEach
    void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    void shouldSearchAndPriceSort() {
        Ticket[] expected = {ticket3, ticket1, ticket2};
        assertArrayEquals(expected, manager.search("NAY", "NBH"));
    }

    @ParameterizedTest
    @CsvSource({"ASF, UUS",
                "NAY, VKT",
                "UUS, NBH"})
    void shouldNotSearch(String from, String to) {
        Ticket[] expected = {};
        assertArrayEquals(expected, manager.search(from,to));
    }

    @Test
    void shouldSearchAndTimeSort() {
        Ticket[] expected = {ticket2, ticket3, ticket1};
        assertArrayEquals(expected, manager.search("NAY", "NBH", new TicketByTimeComparator()));
    }
}