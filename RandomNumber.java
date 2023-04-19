import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        int answer, guess;
        final int MAX = 100;
        int i, win = 0, lose = 0;
        char s;
        System.out.println("Welcome to the Number Guessing Game");
        Scanner sc = new Scanner(System.in);

        do {
            for (i = 0; i < 5; i++) {
                Random rand = new Random();
                answer = rand.nextInt(MAX) + 1;
                System.out.println("Guess a number between 1 to 100");
                guess = sc.nextInt();

                if (guess == answer) {
                    System.out.println("Good Job, the number was " + answer);
                    win++;
                } else {
                    System.out.println("Sorry, but the number was " + answer);
                    lose++;
                }
            }
            System.out.println("Your Score is " + win + "/" + (win + lose));
            System.out.println("Do you want to play again? (y/n)");
            s = sc.next().charAt(0);

        } while (s == 'y' || s == 'Y');

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
