package com.epam.lottery;

import java.util.HashSet;
import java.util.Set;

public class Ticket extends BaseEntity {
    private Set<TicketNumber> ticketNumbers = new HashSet<>();
    private Integer playingNumbersCount;
    private Integer wonNumbersCount;
    private boolean won;

    public Ticket(Integer playingNumbersCount, Integer wonNumbersCount) {
        this.playingNumbersCount = playingNumbersCount;
        this.wonNumbersCount = wonNumbersCount;
    }

    public Set<TicketNumber> getNumbers() {
        return ticketNumbers;
    }

    public boolean isWon() {
        return won;
    }

    public void check() {
        boolean won = true;
        for (TicketNumber ticketNumber: ticketNumbers) {
            if (!ticketNumber.isWon()) {
                won = false;
                break;
            }
        }
        this.won = won;
    }

    public Integer getPlayingNumbersCount() {
        return playingNumbersCount;
    }

    public Integer getWonNumbersCount() {
        return wonNumbersCount;
    }

    public boolean isCompleted() {
        return ticketNumbers.size()== wonNumbersCount;
    }

    public boolean addNumber(int number) {
        boolean result = false;
        if (!isCompleted()) {
            ticketNumbers.add(new TicketNumber(number));
            result = true;
        }
        return result;
    }

    public TicketNumber getTicketNumber(int number) {
        TicketNumber result = null;
        TicketNumber requiredNumber = new TicketNumber(number);
        if (ticketNumbers.contains(requiredNumber)) {
            result = ticketNumbers.stream().filter(n-> n.equals(requiredNumber)).findFirst().get();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Ticket" + getId();
    }
}
