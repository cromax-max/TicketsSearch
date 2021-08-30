package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketsManager {
    private TicketsRepository repo;

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket t) {
        repo.save(t);
    }

    public Ticket[] search(String from, String to) {
        Ticket[] result = repo.findAll(from, to);
        Arrays.sort(result);
        return result;
    }

    public Ticket[] search(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = repo.findAll(from, to);
        Arrays.sort(result, comparator);
        return result;
    }
}