
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sonnet sonnet = new Sonnet();
        GameState game = new GameState();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prithee! Fill in the missing word.");

        while (!game.isGameOver()) {
            int blankIndex = random.nextInt(sonnet.wordCount());
            System.out.println();
            System.out.println(sonnet.getPrompt(blankIndex));
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (sonnet.checkAnswer(blankIndex, answer)) {
                System.out.println("Correct!");
                game.addCorrect();
            } else {
                System.out.println("Incorrect. The word was: " + sonnet.getWord(blankIndex));
                game.addIncorrect();
            }
        }

        System.out.println();
        System.out.println("Correct: " + game.getCorrect() + " Incorrect: " + game.getIncorrect());
        scanner.close();
    }
}

/* Kean's comments:

we imported the java scanner and random generator tools
first int blankIndex = random... picks a random word index from the whole sonnet
it then prints the sonnet from the start to the blank, and then from the blank to the end
then the system asks the user for their answer and stores it in "answer"
it then checks if the word matches the blank
if true, game is over and it calls game.addCorrect()
if false, prints the real world and calls game.addIncorrect()
after the loop finishes, it prints the number of correct and incorrect responses
scanner.close() stops the program from scanning to avoid any problems while the program is not in use)


 */

