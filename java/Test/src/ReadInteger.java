import java.util.Scanner;

public class ReadInteger {
    public static void test() {
        String firstName;
        String lastName;
        String address;
        String city;
        String postalCode;
        String phoneNumber;
        byte age;
        float earningsPerHour;
        long lightYear = 9460730472580800L;
        long lightYearTravel;
        float earningsPast;
        float earningsFuture;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name:");
        firstName = sc.nextLine();
        System.out.println("Please enter your last name:");
        lastName = sc.nextLine();
        System.out.println("Please enter your address:");
        address = sc.nextLine();
        System.out.println("Please enter your city:");
        city = sc.nextLine();
        System.out.println("Please enter your postal code:");
        postalCode = sc.nextLine();
        System.out.println("Please enter your phone number:");
        phoneNumber = sc.next();
        System.out.println("Please enter your age:");
        age = sc.nextByte();
        lightYearTravel=lightYear*age;
        System.out.println("Please enter your earning per hour:");
        earningsPerHour = sc.nextFloat();
        earningsPast = earningsPerHour * 100;
        earningsFuture = (float)(earningsPerHour * 1.7);

        System.out.printf("Your name is: %s %s\n", firstName, lastName);
        System.out.printf("Your address is: %s, %s, %s\n", address, city, postalCode);
        System.out.printf("Your phone number is: %s\n", phoneNumber);
        System.out.printf("Your age is: %s\n", age);
        System.out.printf("Light travel: %,dm\n", lightYearTravel);
        System.out.printf("Your earnings :\nYour earnings from 100 years ago: %1$,.2f$\nYour earnings in the near future: %2$,.2f$", earningsPast, earningsFuture);
    }
}