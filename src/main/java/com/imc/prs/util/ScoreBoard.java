package com.imc.prs.util;

import static com.imc.prs.constant.Messages.GAME_MESSAGES;

/**
 * @author tatmaca
 *
 * ScoreBoard class keeps the statistics of the current game.
 */

public class ScoreBoard {

    private int playerScore;
    private int computerScore;
    private int totalGameCount;

    public void playerWon() {
        this.playerScore++;
    }

    public void computerWon() {
        this.computerScore++;
    }

    public void roundPlayed() {
        this.totalGameCount++;
    }

    @Override
    public String toString() {
        return String.format(GAME_MESSAGES.getString("scoreAnnounce"), playerScore, computerScore, totalGameCount);
    }
}
