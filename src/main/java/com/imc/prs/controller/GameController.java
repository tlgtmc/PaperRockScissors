package com.imc.prs.controller;

import com.imc.prs.util.ScoreBoard;
import com.imc.prs.util.enums.Symbol;
import com.imc.prs.util.enums.Winner;

/**
 * @author tatmaca
 */

public interface GameController {
    void usersMove(Symbol move);
    Symbol computersMove();
    Winner calculateResult();
    ScoreBoard getResults();
}
