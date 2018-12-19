package com.epam.lottery;

import java.util.HashSet;
import java.util.Set;

public class Lottery {
    private Integer playingNumbersCount;
    private Integer wonNumbersCount;
    private Set<Player> players = new HashSet<>();
    private Reel reel;

    public Lottery(Integer playingNumbersCount, Integer wonNumbersCount) {
        this.playingNumbersCount = playingNumbersCount;
        this.wonNumbersCount = wonNumbersCount;
        this.reel = new Reel(playingNumbersCount);
    }

    public void startGame(){
        for (int i=1; i<=playingNumbersCount; i++){
            int currentNumber = reel.spinReelAndGetNumber();
            players.stream().forEach(p->p.checkTicketsByNumber(currentNumber));
        }
    }

    public Set<Player> getWinners() {
        Set<Player> resultSet = new HashSet<Player>() ;
        players.stream().forEach(p->p.checkTickets());
        for (Player player: players) {
            player.checkTickets();
            if (player.getWonTickets().size()>0) {
                resultSet.add(player);
            }
        }
        return resultSet;
    }

    public void addPlayer(Player player){
        if (!players.contains(player)) {
            players.add(player);
        }
        player.addTicket(new Ticket(playingNumbersCount, wonNumbersCount));
    }

    public void removePlayer(Player player){
        if (players.contains(player)) {
            players.remove(player);
        }
    }
}
