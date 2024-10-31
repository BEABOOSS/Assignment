import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.printf("%nDo While Loop%n");
//        diceRollDoWhile();

        System.out.printf("%nWhile Loop%n");
//        diceRollWhile();


    }

    public static void diceRollDoWhile(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String userInput;
        int dice1;
        int dice2;

        do{
            dice1 = rand.nextInt(1, 6);
            dice2 = rand.nextInt(1, 6);
            System.out.printf("To stop rolling the dice press 'x'%nTo roll again press 'enter'%nCurrent dice sum: %d%n", dice1 + dice2);
            System.out.printf("Dice 1: %1$d%nDice 2: %2$d%n", dice1, dice2);
            System.out.print("Input:");
            userInput = sc.nextLine();

        } while(!userInput.equals("x"));

        System.out.printf("Dice 1: %d%nDice 2: %d%n", dice1, dice2);

    }

    public static void diceRollWhile(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String userInput;
        int dice1;
        int dice2;

        while(true){
            dice1 = rand.nextInt(1, 6);
            dice2 = rand.nextInt(1, 6);
            System.out.printf("%nTo stop rolling the dice press 'x'%nTo roll again press 'enter'%nCurrent dice sum: %d%n", dice1 + dice2);
            System.out.printf("Dice 1: %1$d%nDice 2: %2$d%n", dice1, dice2);
            System.out.print("Input:");
            userInput = sc.nextLine();

            if(userInput.equals("x")){
                break;
            } else {
                continue;
            }
        }
    }

}
