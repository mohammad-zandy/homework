import java.util.Scanner;

public class CodeBreakerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine game = new GameEngine();
        int maxAttempts = 10;
        boolean hasWon = false;

        System.out.println("================================");
        System.out.println("   DIGITAL CODE-BREAKER (A-F)   ");
        System.out.println("================================");
        System.out.println("Find the 4-letter secret code.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("\nAttempt " + attempt + "/" + maxAttempts + " - Enter Guess: ");
            String input = scanner.nextLine().trim();

            if (!game.isValidInput(input)) {
                System.out.println(">> ERROR: Use 4 letters from {A, B, C, D, E, F}.");
                attempt--; // Don't count invalid entries as an attempt
                continue;
            }

            int[] feedback = game.getFeedback(input);
            System.out.println(">> Exact Matches: " + feedback[0]);
            System.out.println(">> Partial Matches: " + feedback[1]);

            if (feedback[0] == 4) {
                System.out.println("\nSUCCESS! You've broken the code!");
                hasWon = true;
                break;
            }
        }

        if (!hasWon) {
            System.out.println("\nGAME OVER. You've run out of guesses.");
            System.out.println("The secret code was: " + game.revealSecret());
        }

        scanner.close();
    }
}