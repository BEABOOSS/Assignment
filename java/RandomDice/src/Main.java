import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String userInput;
        int dice1;
        int dice2;

        do{
            dice1 = rand.nextInt(1, 6);
            dice2 = rand.nextInt(1, 6);
            System.out.printf("To stop rolling the dice press 'x'%nTo roll again press 'enter'%nCurrent dice sum: %d%n", dice1 + dice2);
            userInput = sc.nextLine();

        } while(!userInput.equals("x"));

        System.out.printf("Dice 1: %d%nDice 2: %d%n", dice1, dice2);

    }
}
