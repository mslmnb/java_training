package com.epam.lottery;

import static com.epam.lottery.StartLotteryProgram.getRandomNumber;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Player extends BaseEntity{
    private Set<Ticket> tickets = new HashSet<>();

    public void checkTicketsByNumber(int currentNumber) {
        tickets.stream().forEach(t -> checkTicketByNumber(currentNumber, t));
    }

    private void checkTicketByNumber(Integer currentNumber, Ticket ticket) {
        TicketNumber wonTicketNumber = ticket.getTicketNumber(currentNumber);
        if (wonTicketNumber!=null) {
            wonTicketNumber.setWon(true);
        }
    }

    public void addTicket(Ticket ticket) {
        completeTicket(ticket);
        tickets.add(ticket);
    }

    private void completeTicket(Ticket ticket){
        final int fromNumber = 1;
        while (ticket.addNumber(getRandomNumber(fromNumber, ticket.getPlayingNumbersCount())));
    }

    public void checkTickets() {
        tickets.stream().forEach(t->t.check());
    }

    public Set<Ticket> getWonTickets() {
        return tickets.stream().filter(t->t.isWon()).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Player" + getId();
    }
}
