package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ticket implements Comparable <Ticket>{
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int time;

    @Override
    public int compareTo(Ticket another) {
        return price - another.price;
    }

    public boolean matches(String from, String to) {
        return departureAirport.equals(from) && arrivalAirport.equals(to);
    }
}
