import java.util.*;

public class GameEngine {
    private final List<Character> secretCode;
    private final List<Character> validLetters = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');
    private final int CODE_LENGTH = 4;

    public GameEngine() {
        this.secretCode = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            secretCode.add(validLetters.get(random.nextInt(validLetters.size())));
        }
    }

    public int[] getFeedback(String input) {
        char[] guess = input.toUpperCase().toCharArray();
        boolean[] secretMatched = new boolean[CODE_LENGTH];
        boolean[] guessMatched = new boolean[CODE_LENGTH];
        int exact = 0;
        int partial = 0;

        // Pass 1: Find Exact Matches (Correct letter, correct spot)
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (guess[i] == secretCode.get(i)) {
                exact++;
                secretMatched[i] = true;
                guessMatched[i] = true;
            }
        }

        // Pass 2: Find Partial Matches (Correct letter, wrong spot)
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!guessMatched[i]) {
                for (int j = 0; j < CODE_LENGTH; j++) {
                    if (!secretMatched[j] && guess[i] == secretCode.get(j)) {
                        partial++;
                        secretMatched[j] = true;
                        break;
                    }
                }
            }
        }
        return new int[]{exact, partial};
    }

    public boolean isValidInput(String input) {
        if (input.length() != CODE_LENGTH) return false;
        for (char c : input.toUpperCase().toCharArray()) {
            if (!validLetters.contains(c)) return false;
        }
        return true;
    }

    public String revealSecret() {
        return secretCode.toString();
    }
}