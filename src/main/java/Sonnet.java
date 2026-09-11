import java.util.ArrayList;
import java.util.List;

public class Sonnet {

    private static final String[] LINES = {
            "Shall I compare thee to a summer's day?",
            "Thou art more lovely and more temperate:",
            "Rough winds do shake the darling buds of May,",
            "And summer's lease hath all too short a date;",
            "Sometime too hot the eye of heaven shines,",
            "And often is his gold complexion dimm'd;",
            "And every fair from fair sometime declines,",
            "By chance or nature's changing course untrimm'd;",
            "But thy eternal summer shall not fade,",
            "Nor lose possession of that fair thou ow'st;",
            "Nor shall death brag thou wander'st in his shade,",
            "When in eternal lines to time thou grow'st:",
            "So long as men can breathe or eyes can see,",
            "So long lives this, and this gives life to thee."
    };

    private List<String> words = new ArrayList<>();
    private List<Boolean> endOfLine = new ArrayList<>();

    public Sonnet() {
        for (String line : LINES) {
            String[] lineWords = line.split(" ");
            for (int i = 0; i < lineWords.length; i++) {
                words.add(lineWords[i]);
                endOfLine.add(i == lineWords.length - 1);
            }
        }
    }

    public int wordCount() {
        return words.size();
    }

    public String getWord(int index) {
        return words.get(index);
    }

    public String getPrompt(int blankIndex) {
        String result = "";
        for (int i = 0; i <= blankIndex; i++) {
            if (i == blankIndex) {
                String word = clean(words.get(i));
                for (int j = 0; j < word.length(); j++) {
                    result += "_";
                }
            } else {
                result += words.get(i);
                if (endOfLine.get(i)) {
                    result += "\n";
                } else {
                    result += " ";
                }
            }
        }
        return result;
    }

    public boolean checkAnswer(int blankIndex, String guess) {
        String correctWord = clean(words.get(blankIndex));
        String guessWord = clean(guess);
        return correctWord.equalsIgnoreCase(guessWord);
    }

    private String clean(String word) {
        return word.replaceAll("[^a-zA-Z']", "");
    }
}

/*
LINES holds the sonnet as fixed text
word is every word form the whole sonnet in one flat list
endOfLife is a matching list of T/F, informing the programmer fithe word was the last word on its line
the constructor loops through each line, splits it into words, and fills both lists at the same time
wordCount() returns total word count
getWord(index) returns the actual word at that spot
getPrompt(blankIndex) builds the text that gets printed
-  loops from first word up to blank
- if it is the blank word, it swaps it for an underscore (one/letter)
- otherwise, it adds the word normally then either a new line or a space depending on endOfLine
checkAnswer(blankIndex, guess) cleans bot the correct word and the user's guess, then compares them ignoring case
clean(word) strips out the puntucation like commas or periods so it doesn't mess up the word count


 */