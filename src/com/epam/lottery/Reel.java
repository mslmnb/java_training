package com.epam.lottery;

import static com.epam.lottery.StartLotteryProgram.getRandomNumber;

public class Reel {
    private Integer PlayingNumbersCount;

    public Reel(Integer playingNumbersCount) {
        PlayingNumbersCount = playingNumbersCount;
    }

    public int spinReelAndGetNumber(){
        final int fromNumber = 1;
        return getRandomNumber(fromNumber, PlayingNumbersCount);
    }
}
