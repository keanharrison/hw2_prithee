public class GameState {

    private int correct = 0;
    private int incorrect = 0;

    public void addCorrect() {
        correct++;
    }

    public void addIncorrect() {
        incorrect++;
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public boolean isGameOver() {
        return correct == 3 || incorrect == 3;
    }
}

/* Kean's comments:

GameState is a dictionary with several methods to be applied in the programs of this repo
correct and incorrect are private field starting at 0
addIncorrect and addCorrect are the counters that increment the private fields
getCorrect and getIncorrect return the final values when program finishes running
isGameOver returns true once either hits 3

 */