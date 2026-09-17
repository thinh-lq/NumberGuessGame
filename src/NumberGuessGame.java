import java.util.Random;
import java.util.Scanner;

class Helper {
    static boolean checkNum(int playerGuess, int gameNum) {
        return playerGuess == gameNum;
    }

    static int play(int limitGuess, int gameNum, Scanner sc) {
        boolean hintUsed = false;

        System.out.print("Do you want a hint? (y/n): ");

        while (true) {
            String answer = sc.nextLine().strip().toLowerCase();

            if (answer.equals("y")) {
                int firstDigit = Integer.toString(gameNum).charAt(0) - '0';
                System.out.println("Hint: The first digit is " + firstDigit + ".");
                hintUsed = true;
                break;
            }

            if (answer.equals("n")) {
                break;
            }

            System.out.print("Invalid! Please enter 'y' or 'n': ");
        }

        for (int i = 1; i <= limitGuess; i++) {
            System.out.print("Enter your guess: ");

            int playerGuess;

            try {
                playerGuess = Integer.parseInt(sc.nextLine().strip());
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please enter a number.");
                i--;
                continue;
            }

            if (playerGuess < 1 || playerGuess > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                i--;
                continue;
            }

            boolean guessRight = checkNum(playerGuess, gameNum);

            if (guessRight) {
                System.out.println(
                        "\nCongratulations! You guessed the correct number in "
                                + i
                                + " attempts"
                );
                return i;
            }

            if (playerGuess > gameNum) {
                System.out.println("Incorrect! The number is less than " + playerGuess);
            } else {
                System.out.println("Incorrect! The number is greater than " + playerGuess);
            }

            if (!hintUsed) {
                System.out.print("Do you want a hint? (y/n): ");

                while (true) {
                    String answer = sc.nextLine().strip().toLowerCase();

                    if (answer.equals("y")) {
                        int firstDigit = Integer.toString(gameNum).charAt(0) - '0';
                        System.out.println("Hint: The first digit is " + firstDigit + ".");
                        hintUsed = true;
                        break;
                    }

                    if (answer.equals("n")) {
                        break;
                    }

                    System.out.print("Invalid! Please enter 'y' or 'n': ");
                }
            }
        }

        System.out.println("\nYou lose! The number is " + gameNum);
        return -1;
    }

    static int takeLevel(Scanner sc) {
        System.out.println(
                "\nPlease select the difficulty level:\n"
                        + "1. Easy (10 chances)\n"
                        + "2. Medium (5 chances)\n"
                        + "3. Hard (3 chances)\n"
                        + "4. Nightmare (2 chances)\n"
                        + "5. Impossible (1 chance)"
        );

        System.out.print("Enter your choice: ");

        int choice;

        while (true) {
            String line = sc.nextLine();

            try {
                choice = Integer.parseInt(line.strip());
            } catch (NumberFormatException e) {
                System.out.print("Invalid! Enter a number (1-5): ");
                continue;
            }

            if (choice >= 1 && choice <= 5) {
                break;
            }

            System.out.print("Invalid! Enter a number (1-5): ");
        }

        switch (choice) {
            case 1:
                System.out.println("\nGreat! You have selected the Easy difficulty level.");
                return 10;

            case 2:
                System.out.println("\nGreat! You have selected the Medium difficulty level.");
                return 5;

            case 3:
                System.out.println("\nGreat! You have selected the Hard difficulty level.");
                return 3;

            case 4:
                System.out.println("\nGreat! You have selected the Nightmare difficulty level.");
                return 2;

            case 5:
                System.out.println("\nGreat! You have selected the Impossible difficulty level.");
                return 1;

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    static boolean playAgain(Scanner sc) {
        while (true) {
            System.out.print("\nDo you want to play again? (y/n): ");

            String answer = sc.nextLine().strip().toLowerCase();

            if (answer.equals("y")) {
                return true;
            }

            if (answer.equals("n")) {
                return false;
            }

            System.out.print("Invalid! Please enter 'y' or 'n'.");
        }
    }
}

public class NumberGuessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new NumberGuessGame().run(sc);

        sc.close();
    }

    private void run(Scanner sc) {
        Random random = new Random();

        int bestScore = Integer.MAX_VALUE;
        int gameCount = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            gameCount++;

            System.out.println("\nI'm thinking of a number between 1 and 100.");

            int gameNum = random.nextInt(100) + 1;

            int level = Helper.takeLevel(sc);

            System.out.println("Let's start the game!\n");

            int score = Helper.play(level, gameNum, sc);

            if (score != -1) {
                if (score < bestScore) {
                    bestScore = score;
                    System.out.println("\nNew best score: " + bestScore + " attempts!");
                } else {
                    System.out.println("\nBest score: " + bestScore + " attempts");
                }
            }

            if (!Helper.playAgain(sc)) {
                break;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Games played: " + gameCount);

        if (bestScore == Integer.MAX_VALUE) {
            System.out.println("Best score: No winning game yet.");
        } else {
            System.out.println("Best score: " + bestScore + " attempts");
        }
    }
}
