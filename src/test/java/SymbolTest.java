import org.junit.jupiter.api.Test;

import static com.imc.prs.util.enums.Symbol.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author tatmaca
 */

class SymbolTest {

    @Test
    void validateSymbols_success() {
        assertTrue(ROCK.isBeatBy(PAPER));
        assertTrue(PAPER.isBeatBy(SCISSORS));
        assertTrue(SCISSORS.isBeatBy(ROCK));

        assertFalse(ROCK.isBeatBy(SCISSORS));
        assertFalse(SCISSORS.isBeatBy(PAPER));
    }
}
