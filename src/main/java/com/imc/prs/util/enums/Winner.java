package com.imc.prs.util.enums;

import static com.imc.prs.constant.Messages.GAME_MESSAGES;

/**
 * @author tatmaca
 *
 * Winner class contains the possibilities of a round's result.
 */

public enum Winner {
    PLAYER,
    COMPUTER,
    TIE;

    public String announceWinner() {
        if (!this.equals(TIE)) {
            return String.format(GAME_MESSAGES.getString("winnerAnnounce"), this.name());
        } else {
            return TIE.name();
        }
    }
}
