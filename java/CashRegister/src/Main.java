import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    // do not know if this is a good idea ¯\_(ツ)_/¯
//    public static String menuSelect = "";
    public static void main(String[] args){

        ArrayList<Cashier> workers = new ArrayList<Cashier>();
        workers.add( new Cashier("james"));
        workers.add( new Cashier("bob"));
        workers.add( new Cashier("burt"));
        workers.add( new Cashier("ken"));


        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("Water Melon", 5.99f, 12));
        itemList.add(new Item("Loaf of Bread", 2.50f, 35));
        itemList.add(new Item("Bag of Lemons", 3.50f, 3));
        itemList.add(new Item("Bag of Chips", 6.99f, 12));

//        listItems(itemList);
        if(login(workers)){
            mainMenu(itemList);
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
            cashierNumInput = sc.nextLine();
            System.out.println(","+cashierNumInput+",");
            System.out.println(","+cashierNumInput.trim()+",");

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

    public static void mainMenu(ArrayList<Item> itemList){
        String menuSelect = "";
        boolean exitMenu = false;
        Scanner sc = new Scanner(System.in);
        while (!exitMenu){

            System.out.printf("%n%1$s Main Menu %1$s", "------------");
            System.out.printf("%n1-Add new item%n2-Purchase item%nX-Exit%n:");
            menuSelect = sc.nextLine().trim();

            switch (menuSelect){
                case "1":
                    itemList = addItem(itemList);
                    break;
                case "2":
                    itemList = purchaseItem(itemList);
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

    public static ArrayList<Item> addItem(ArrayList<Item> itemList){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Pattern stringVerification = Pattern.compile("^[A-Za-z][\\w\\s]+$");
        String menuSelect = "";
        Matcher matcher;


        System.out.printf("%n%1$s Adding Item %1$s%n", "------------");
        listItems(itemList);

        while(true){
            System.out.printf("%nEnter Item Name: ");
            String name = sc.nextLine().trim();
            if(name.equals("x")){
                break;
            }

            System.out.printf("%nEnter Item Price: ");
            String price = sc.nextLine().replace(",", ".").trim();
            if(price.equals("x")){
                break;
            }

            System.out.printf("%nEnter Item Quantity: ");
            String quantity = sc.nextLine().trim();
            if (quantity.equals("x")){
                break;
            }

            try {
                matcher = stringVerification.matcher(name);
                float itemPrice = Float.parseFloat(price.trim());
                int itemQuantity = Integer.parseInt(quantity);


                if(!matcher.matches()){
                    throw new IllegalArgumentException("Item name must only contain letters, numbers, and spaces, and start with a letter");
                }
                String itemName = name;

                if(itemPrice < 0.00f){
                    throw new IllegalArgumentException("Item price cannot be negative");
                }
                if(itemQuantity < 0 || itemQuantity > 200){
                    throw new IllegalArgumentException("Item quantity cannot be negative or greater than 200");
                }


                System.out.printf("%nNew Item Added: ");
                System.out.printf("%nItem name: %1$s%nItem price: %2$.2f%nItem quantity: %3$d", itemName, itemPrice, itemQuantity);
                itemList.add(new Item(itemName, itemPrice, itemQuantity));

                System.out.printf("%n%nWould you like to add another item? (y/n): %n");
                menuSelect = sc.nextLine().trim().toLowerCase();

                if(menuSelect.equals("n")){
                    return itemList;
                }

            } catch (NumberFormatException e){
                System.out.println("Error: Please enter a valid number");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }


        return itemList;
    }

    public static ArrayList<Item>  purchaseItem(ArrayList<Item> itemList){
        Scanner sc = new Scanner(System.in);

//        while(true){
//            System.out.printf("%n%1$s Purchasing Item %1$s%n", "------------");
//            listItems(itemList);
//            System.out.printf("%nWhich item would like to purchase");
//
//
//
//        }


        return itemList;
    }

    public static void listItems(ArrayList<Item> itemList) {
        final int ITEM_NAME_WIDTH = 15;  // Fixed width for item names

        // display's current format
        System.out.printf(" %-3s%-" + ITEM_NAME_WIDTH + "s%s %s%n", "Id", "Item name", "Price", "Quantity");
        // Print each item with fixed-width formatting
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);

            // Format the number with padding
            String itemNumber = String.format("%d. ", i + 1);

            // Format the name with fixed width
            String itemName = item.getItemName();
            if (itemName.length() > ITEM_NAME_WIDTH) {
                itemName = itemName.substring(0, ITEM_NAME_WIDTH - 3) + "...";
            }
            // Print the formatted line
            System.out.printf(" %-3s%-" + ITEM_NAME_WIDTH + "s$%.2f x%d%n", itemNumber, itemName, item.getPrice(), item.getQuantity());
        }
    }

}





// 1- User base
// + Cashier (10 user)
// +-- Id
// +-- username

// + Items
// +-- item Id
// +-- item name
// +-- item price
// +-- item quantity

// 2- Application flow
// +-- User login (Cashier number/id) * Done
// +---- If correct greet user *insert username* ->> main menu
// +---- else if user failed 3 times give msg 'are you sure'
// +-- Main menu (items/info)
// +---- Add new items
// +---- Purchase items
// +---- Exit
// +--- Add new items ( default has 7 items)
// +----- Display current items
// +----- Prompt user to register new items
// +------ (only stops showing prompt until 'x' is entered)
// --- Purchase items
// +---- Display all items available
// ----- Prompt user for item to be purchased (item number)
// ------ Prompt user for the quantity
// ------ Display the subtotal ( item price * quantity)
// ------ Ask if user is finished
// -------- yes, then Display grand total
// ---------- then ask to return to main menu
// -------- no, then go to line 33