package com.epam.lottery;

import java.util.Set;

public class StartLotteryProgram {
    public static void main(String[] args) {
        final Integer playingNumbersCount = 90;
        final Integer wonNumbersCount = 15;
        final Integer playersCount = 1000000;
        final int minTicketsCount = 1;
        final int maxTicketsCount = 3;

        Lottery lottery = new Lottery(playingNumbersCount, wonNumbersCount);
        Player[] players = new Player[playersCount];
        for (int i=0; i<players.length; i++ ){
            players[i] = new Player();
            int ticketsCount = getRandomNumber(minTicketsCount, maxTicketsCount);
            for (int j=0; j < ticketsCount; j++) {
                lottery.addPlayer(players[i]);
            }
        }

        while (true) {
            lottery.startGame();
            Set<Player> winners = lottery.getWinners();
            if (winners.size()>1) {
                break;
            }
        }

        for (Player player: lottery.getWinners()) {
            System.out.print("Победитель:" + player + "[");
            System.out.println(player.getWonTickets().stream()
                                                     .map(ticket -> ticket.toString())
                                                     .reduce((x,y)-> x + ", " + y)
                                                     .get() + "]");
        }

    }

    public static int getRandomNumber(int fromNumber, int toNumber) {
        return (int) (fromNumber + (Math.random()*(toNumber + 1)));
    }
}

/*
Победитель:Player7[Ticket8, Ticket9]
Победитель:Player23[Ticket25, Ticket26]
Победитель:Player30[Ticket32]
*/
