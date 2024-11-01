import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Tuple<Integer, Float> tuple = validation();
        System.out.printf("%nAge: %1$d%nGPA: %2$.2f%n", tuple.getFirst(), tuple.getSecond());
    }

    public static Tuple<Integer, Float> validation(){
        Scanner sc = new Scanner(System.in);
        Tuple<Integer, Float> output;
        String age;
        String gpa;
        int ageInt = 0;
        float gpaF = 0.0f;
        boolean validInput = false;

        while (!validInput){
            System.out.printf("%nEnter 'x' to quit at any time%n");
            System.out.printf("%nStudent Age (18-99):");
            age = sc.next();
            if(age.equals("x")) {
                break;
            }
            System.out.printf("%nStudent GPA (0-4.0):");
            gpa = sc.next();
            if(gpa.equals("x")) {
                break;
            }


            try{
                ageInt = Integer.parseInt(age);
                gpaF = Float.parseFloat(gpa);

                if (ageInt < 18 || ageInt > 100){
                    throw new IllegalArgumentException("Age must be between 18 and 99");
                }
                if (gpaF < 0.0 || gpaF > 4.0){
                    throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
                }

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return output = new Tuple<>(ageInt, gpaF);
    }
}