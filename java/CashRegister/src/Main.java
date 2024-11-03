import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Cashier first = new Cashier(123, "james");
//    Cashier second = new Cashier(124, "bob");
//    Cashier third = new Cashier(125, "burt");
//    Cashier fourth = new Cashier(126, "ken");



    public static void main(String[] args){

        ArrayList<Cashier> workers = new ArrayList<Cashier>();
        workers.add( new Cashier("james"));
        workers.add( new Cashier("bob"));
        workers.add( new Cashier("burt"));
        workers.add( new Cashier("ken"));

//        workers.forEach(x -> System.out.println(x.getUsername()));
//        mainMenu();
        if(login(workers)){
            mainMenu();
        };
    }
    // Noo need to touch this
    public static boolean login(ArrayList<Cashier> workers){
        Scanner sc = new Scanner(System.in);
        boolean userFound = false;
        int numOfTries = 3;
        String cashierNumInput = "";

        for(int i=3; i >= 0; i--){
            if(i == 0){
                System.out.printf("%nYOU HAVE EXCEEDED THE NUMBER OF TRIES, ARE YOU SURE YOU HAVE THE RIGHT NUMBER?%n");
                break;
            }
            System.out.printf("%n%s", i == numOfTries ? "------------Main Menu------------": "");
            System.out.printf("%nEnter your Cashier number (%d tries left):%n", i);
            cashierNumInput = sc.next();

            try {
                int cashierInput = Integer.parseInt(cashierNumInput);

                if(cashierInput < 0 || cashierInput > 500){
                    throw new IllegalArgumentException("Cashier number need to be between 0 and 500");
                }

                for(Cashier j : workers){
                    if(j.getCashierNumber() == cashierInput){
                        userFound = true;
                        System.out.printf("%nWELCOME BACK %s.%n", j.getUsername());
                        break;
                    }
                }
                if(userFound){
                    break;
                }
            } catch (NumberFormatException e ){
                System.out.println("Error: Please enter a valid number");
            } catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }

        }
        return userFound;
    }

    public static void mainMenu(){

        String menuSelect = "";
        boolean exitMenu = false;
        Scanner sc = new Scanner(System.in);
        while (!exitMenu){

            System.out.printf("%n%1$s Main Menu %1$s", "------------");
            System.out.printf("%n1-Add new item%n2-Purchase item%nX-Exit%n:");
            menuSelect = sc.next();

            switch (menuSelect){
                case "1":
                    addItem();
                    break;
                case "2":
                    purchaseItem();
                    break;
                case "x":
                    exitMenu = true;
                    break;
                default:
                    System.out.printf("%nError please select one the available menus");
                    break;
            }
        }

    }

    public static void addItem(){

    }

    public static void  purchaseItem(){

    }

}





// 1- User base
// Cashier (10 user)
// -- Id
// -- username

// Items
// -- item Id
// -- item name
// -- item price
// -- item quantity

// 2- Application flow
// /-- User login (Cashier number/id) * Done
// /---- If correct greet user *insert username* ->> main menu
// /---- else if user failed 3 times give msg 'are you sure'
// -- Main menu (items/info)
// ---- Add new items
// ---- Purchase items
// ---- Exit
// --- Add new items ( default has 7 items)
// ----- Display current items
// ----- Prompt user to register new items
// ------ (only stops showing prompt until 'x' is entered)
// --- Purchase items
// ----- Display all items available
// ----- Prompt user for item to be purchased (item number)
// ------ Prompt user for the quantity
// ------ Display the subtotal ( item price * quantity)
// ------ Ask if user is finished
// -------- yes, then Display grand total
// ---------- then ask to return to main menu
// -------- no, then go to line 33