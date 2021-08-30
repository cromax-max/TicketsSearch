package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketsRepository {
    Ticket[] tickets = new Ticket[0];

    public void save(Ticket t) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = t;
        tickets = tmp;
    }

    public Ticket findById(int id) {
        Ticket result = null;
        for (Ticket t : tickets) {
            if (t.getId() == id) {
                result = t;
            }
        }
        return result;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket t : findAll()) {
            if (t.matches(from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = t;
                result = tmp;
            }
        }
        return result;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket t : tickets) {
            if (t.getId() != id) {
                tmp[index] = t;
                index++;
            }
        }
        tickets = tmp;
    }
}
