package com.imc.prs.controller.impl;

import com.imc.prs.controller.GameController;
import com.imc.prs.util.GameRound;
import com.imc.prs.util.ScoreBoard;
import com.imc.prs.util.enums.Symbol;
import com.imc.prs.util.enums.Winner;

/**
 * @author tatmaca
 *
 * PaperRockScissorsController class controls the game.
 * It initializes a game, arranges moves, and calculate the results.
 */

public class PaperRockScissorsController implements GameController {

    private final GameRound gameRound;
    private final ScoreBoard scoreBoard;

    public PaperRockScissorsController(GameRound gameRound, ScoreBoard scoreBoard) {
        this.gameRound = gameRound;
        this.scoreBoard = scoreBoard;
    }

    @Override
    public void usersMove(Symbol move) {
        gameRound.setUsersMove(move);
    }

    @Override
    public Symbol computersMove() {
        Symbol move = gameRound.randomMove();
        gameRound.setComputersMove(move);
        return move;
    }

    @Override
    public Winner calculateResult() {
        return gameRound.getWinner(scoreBoard);
    }

    @Override
    public ScoreBoard getResults() {
        return scoreBoard;
    }
}
