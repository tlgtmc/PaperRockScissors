package com.imc.prs.util;

import com.imc.prs.util.enums.Symbol;
import com.imc.prs.util.enums.Winner;

import java.util.Random;

import static com.imc.prs.util.enums.Winner.*;

/**
 * @author tatmaca
 *
 * GameRound class is a declaration of a round. It sets both user's and computer's moves.
 * And depending on these, determines the winner.
 *
 */

public class GameRound {
    private Symbol usersMove;
    private Symbol computersMove;

    public void setUsersMove(Symbol usersMove) {
        this.usersMove = usersMove;
    }

    public void setComputersMove(Symbol computersMove) {
        this.computersMove = computersMove;
    }

    public Winner getWinner(ScoreBoard scoreBoard) {
        scoreBoard.roundPlayed();
        if (getComputersMove().equals(getUsersMove())) {
            return TIE;
        } else if (getComputersMove().isBeatBy(getUsersMove())) {
            scoreBoard.playerWon();
            return PLAYER;
        } else {
            scoreBoard.computerWon();
            return COMPUTER;
        }
    }

    public Symbol randomMove() {
        int rand = new Random().nextInt(3)+1;
        return Symbol.getSymbolById(rand);
    }

    public Symbol getUsersMove() {
        return usersMove;
    }

    public Symbol getComputersMove() {
        return computersMove;
    }
}
