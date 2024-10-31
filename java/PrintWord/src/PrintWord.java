import java.util.Scanner;

public class PrintWord {
    public static void printWordSwitch(){
    int number;
    Scanner sc = new Scanner(System.in);
    String[] numberList = new String[]{"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "OTHER"};
    System.out.println("Please enter a number between one and nine ");
    number = sc.nextInt();

    switch (number) {
        case 1:
            System.out.printf("Number: %s%n", numberList[0]);
            break;
        case 2:
            System.out.printf("Number: %s%n", numberList[1]);
            break;
        case 3:
            System.out.printf("Number: %s%n", numberList[2]);
            break;
        case 4:
            System.out.printf("Number: %s%n", numberList[3]);
            break;
        case 5:
            System.out.printf("Number: %s%n", numberList[4]);
            break;
        case 6:
            System.out.printf("Number: %s%n", numberList[5]);
            break;
        case 7:
            System.out.printf("Number: %s%n", numberList[6]);
            break;
        case 8:
            System.out.printf("Number: %s%n", numberList[7]);
            break;
        case 9:
            System.out.printf("Number: %s%n", numberList[8]);
            break;
        default:
            System.out.printf("Number: %s%n", numberList[9]);
            break;
        }

    }

    public static void printWordIfElse(){
        int number;
        Scanner sc = new Scanner(System.in);
        String[] numberList = new String[]{"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "OTHER"};
        System.out.println("Please enter a number between one and nine ");
        number = sc.nextInt();

        if(number == 1){
            System.out.printf("Number: %s%n", numberList[0]);
        } else if (number == 2) {
            System.out.printf("Number: %s%n", numberList[1]);
        } else if (number == 3) {
            System.out.printf("Number: %s%n", numberList[2]);
        } else if (number == 4) {
            System.out.printf("Number: %s%n", numberList[3]);
        } else if (number == 5) {
            System.out.printf("Number: %s%n", numberList[4]);
        } else if (number == 6) {
            System.out.printf("Number: %s%n", numberList[5]);
        } else if (number == 7) {
            System.out.printf("Number: %s%n", numberList[6]);
        } else if (number == 8) {
            System.out.printf("Number: %s%n", numberList[7]);
        } else if (number == 9) {
            System.out.printf("Number: %s%n", numberList[8]);
        } else {
            System.out.printf("Number: %s%n", numberList[9]);
        }

    }

}
