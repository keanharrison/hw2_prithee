import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Test
    void startsNotOver() {
        GameState game = new GameState();
        assertFalse(game.isGameOver());
    }

    @Test
    void threeCorrectEndsGame() {
        GameState game = new GameState();
        game.addCorrect();
        game.addCorrect();
        game.addCorrect();
        assertTrue(game.isGameOver());
    }

    @Test
    void threeIncorrectEndsGame() {
        GameState game = new GameState();
        game.addIncorrect();
        game.addIncorrect();
        game.addIncorrect();
        assertTrue(game.isGameOver());
    }
}