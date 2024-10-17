import java.util.Scanner;

public class PrintWord {
    public static void printWord(){
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

}
