package com.epam.lottery;

public class TicketNumber {
    private Integer number;
    private boolean won;

    public TicketNumber(Integer number) {
        this.number = number;
        this.won = false;
    }

    public Integer getNumber() {
        return number;
    }

    public boolean isWon() {
        return won;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketNumber)) return false;

        TicketNumber that = (TicketNumber) o;

        return getNumber() != null ? getNumber().equals(that.getNumber()) : that.getNumber() == null;

    }

    @Override
    public int hashCode() {
        return getNumber() != null ? getNumber().hashCode() : 0;
    }
}
