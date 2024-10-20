import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        sumAndAvg();
        numberGuesser();
    }
    public static void sumAndAvg(){
        int smallNum = 111;
        int bigNum = 8989;
        int counter = 111;
        int sum = 111;
        int expectedSum = 40399450;
        double expectedAvg = 4550.0;

        while (counter != bigNum) {
            counter = counter + 1;
            sum = sum + counter;
        }

        if (counter != 0) {
            double average = (double)(sum)  / (counter - smallNum);
            System.out.printf("Expected sum should be: %d%nExpected average should be: %.1f%n", expectedSum, expectedAvg);
            System.out.printf("%nThe sum is %d%nAverage number is %.1f%n", sum, average);
        } else {
            System.out.println("Nothing Was Calculated");
        }
    }
    public static void numberGuesser(){

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String guessedNumber = "";
        String failedAttempt;
        int maxNumber = 2;
        int answer = rand.nextInt(maxNumber) + 1;
        int numOfTries = 3;
        while (!guessedNumber.equals("x")) {
            if(numOfTries == 0) {
                System.out.printf("%n%2$s%2$s%nYou ran out of tries%nThe answer was %1$d%nA new number will be chosen now%n%2$s%2$s%n", answer, "------------");
                answer = rand.nextInt(maxNumber) + 1;
                numOfTries = 3;
                continue;
            }

            System.out.printf("%n%s", numOfTries == 3? "------------NEW GAME------------": "");
            System.out.printf("%nGuess a number between 1 and 10%nYou can type 'x' to stop playing at anytime%nYou have %d of Tries:", numOfTries);
            guessedNumber = sc.next();

            if(guessedNumber.equals("x")) {
                break;
            }
            try {
                int guess = Integer.parseInt(guessedNumber);
                if(guess == answer) {
                    System.out.printf("%n%3$s SUCCESS %3$s%nGreat You guessed the number%nAnd you had %1$d %2$s left%n", numOfTries, numOfTries >1 ? "tries" : "try", "************");
                    answer = rand.nextInt(maxNumber) + 1;
                    numOfTries = 3;
                } else {
                    numOfTries--;
                    failedAttempt = numOfTries > 1 ? "You have " + numOfTries + " left" : "This is your last try give it your best guess";
                    System.out.printf("%nXX Wrong!! Try again XX%n%s%n", failedAttempt);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 10 or 'x' to quit.");
            }
        }
        System.out.printf("%n%1$s%1$s%1$s%nThanks For Playing see you next time!!%n%1$s%1$s%1$s%n", "------------");

    }
}