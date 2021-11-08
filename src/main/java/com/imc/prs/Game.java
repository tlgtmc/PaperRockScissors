package com.imc.prs;

import com.imc.prs.constant.Messages;
import com.imc.prs.controller.GameController;
import com.imc.prs.controller.impl.PaperRockScissorsController;
import com.imc.prs.util.GameRound;
import com.imc.prs.util.ScoreBoard;
import com.imc.prs.util.enums.Symbol;
import com.imc.prs.util.enums.Winner;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.imc.prs.constant.Messages.*;

/**
 * @author tatmaca
 *  Paper - Rock - Scissor game's starting point.
 *
 *  Application informs user about the required inputs.
 *  Depending on the input, keeps on or ends the game.
 */

public class Game {

    static final Logger log = Logger.getLogger(Game.class.getName());

    public static void main(String[] args) {
        GameController gameController = new PaperRockScissorsController(new GameRound(), new ScoreBoard());

        Scanner scanner = new Scanner(System.in);
        String continueOrExit;

        log.info(Messages.getBanner());

        do {
            playGame(gameController, scanner);

            log.info(GAME_MESSAGES.getString("continueOrExit"));
            continueOrExit = scanner.next();

        } while (!continueOrExit.equalsIgnoreCase("N"));

        log.info(GAME_MESSAGES.getString("endGame"));
    }

    private static void playGame(GameController gameController, Scanner scanner) {
        log.info(GAME_MESSAGES.getString("newRound"));

        try {
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                log.info(String.format(GAME_MESSAGES.getString("notValidNumber"), input));
            }
            int usersMove = scanner.nextInt();
            Symbol usersMoveSymbol = Symbol.getSymbolById(usersMove);
            gameController.usersMove(usersMoveSymbol);

            Symbol computersMove = gameController.computersMove();
            Winner winner = gameController.calculateResult();
            ScoreBoard scoreBoard = gameController.getResults();

            informUser(usersMoveSymbol, computersMove, winner, scoreBoard);
        } catch (IllegalStateException | InputMismatchException e) {
            log.info(e.getMessage());
            playGame(gameController, scanner);
        }
    }


    private static void informUser(Symbol usersMoveSymbol, Symbol computersMove, Winner winner, ScoreBoard scoreBoard) {
        log.info(String.format(GAME_MESSAGES.getString("roundMoves"), usersMoveSymbol.name(), computersMove.name()));
        log.info(winner.announceWinner());
        log.info("");
        log.info(scoreBoard.toString());
        log.info("");
    }
}
