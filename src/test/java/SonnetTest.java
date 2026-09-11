import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SonnetTest {

    @Test
    void firstWordIsShall() {
        Sonnet sonnet = new Sonnet();
        assertEquals("Shall", sonnet.getWord(0));
    }

    @Test
    void promptShowsUnderscores() {
        Sonnet sonnet = new Sonnet();
        assertEquals("_____", sonnet.getPrompt(0));
    }

    @Test
    void correctAnswerWorks() {
        Sonnet sonnet = new Sonnet();
        assertTrue(sonnet.checkAnswer(7, "day"));
    }

    @Test
    void wrongAnswerFails() {
        Sonnet sonnet = new Sonnet();
        assertFalse(sonnet.checkAnswer(7, "night"));
    }
}