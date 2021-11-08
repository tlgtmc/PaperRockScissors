package com.imc.prs.util.enums;

import java.util.Arrays;
import java.util.Optional;

import static com.imc.prs.constant.Messages.GAME_MESSAGES;


/**
 * @author tatmaca
 *
 * Symbol class stores the symbols that can be played during the game.
 */

public enum Symbol {
    ROCK(1, 2),
    PAPER(2,3),
    SCISSORS(3, 1);

    private final int id;
    private final int beatBy;

    Symbol(int id, int beatBy) {
        this.id = id;
        this.beatBy = beatBy;
    }

    public boolean isBeatBy(Symbol move) {
        return this.beatBy == move.id;
    }

    public static Symbol getSymbolById(int id) {
        Optional<Symbol> move = Arrays.stream(Symbol.values()).filter(s -> s.id == id).findFirst();
        return move.orElseThrow(() -> new IllegalStateException(GAME_MESSAGES.getString("invalidType"), new Throwable()));
    }
}
