import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String YesNo = String.format("(" + ANSI_GREEN +"y" + ANSI_WHITE + "/" + ANSI_RED + "n" + ANSI_RESET + ")");
    public static final String LINE_MENU = "------------";

    public static void main(String[] args){

        // id's start at 100 and increase by one
        ArrayList<Cashier> workers = new ArrayList<Cashier>();
        workers.add( new Cashier("James"));
        workers.add( new Cashier("Bob"));
        workers.add( new Cashier("Burt"));
        workers.add( new Cashier("Ken"));
        workers.add( new Cashier("Mary"));
        workers.add( new Cashier("Susan"));
        workers.add( new Cashier("David"));
        workers.add( new Cashier("Patricia"));

        // id's start at 100 and increase by one
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("Water Melon", 5.99f, 12));
        itemList.add(new Item("Loaf of Bread", 2.50f, 35));
        itemList.add(new Item("Bag of Lemons", 3.50f, 3));
        itemList.add(new Item("Bag of Chips", 6.99f, 12));
        itemList.add(new Item("Cheese", 6.50f, 0));
        itemList.add(new Item("Apples", 4.00f, 35));
        itemList.add(new Item("Tomato Soup", 1.09f, 70));
        itemList.add(new Item("Sugar", 3.49f, 6));
        itemList.add(new Item("Peanut Butter", 7.79f, 120));
        itemList.add(new Item("Froot Loops", 5.49f, 57));
        itemList.add(new Item("Cream Corn", 2.29f, 103));
        itemList.add(new Item("Oreo", 4.49f, 38));



        if(login(workers)){
            mainMenu(itemList);
        };

    }

    // Noo need to touch this
    public static boolean login(ArrayList<Cashier> workers){
        Scanner sc = new Scanner(System.in);
        boolean userFound = false;
        int NUMBER_OF_TRIES = 3;
        String cashierNumInput = "";
        String mainMenu = String.format("%1$s Main Menu %1$s", LINE_MENU);

        for(int i=3; i >= 0; i--){
            if(i == 0){
                System.out.printf(ANSI_YELLOW + "%n YOU HAVE EXCEEDED THE NUMBER OF TRIES,%n ARE YOU SURE YOU HAVE THE RIGHT NUMBER?%n" + ANSI_RESET);
                break;
            }
            System.out.printf("%n%s", i == NUMBER_OF_TRIES ? mainMenu : "");
            System.out.printf("%n Enter your Cashier number ("+ ANSI_YELLOW+ "%d tries left"+ANSI_RESET +")%n :", i);
            cashierNumInput = sc.nextLine().trim();

            try {
                int cashierInput = Integer.parseInt(cashierNumInput);

                if(cashierInput < 0 || cashierInput > 500){
                    throw new IllegalArgumentException(ANSI_YELLOW + "Cashier number need to be between 0 and 500" + ANSI_RESET);
                }

                // checks if cashier id exist
                for(Cashier j : workers){
                    if(j.getCashierNumber() == cashierInput){
                        userFound = true;
                        System.out.printf(ANSI_GREEN + "%n WELCOME BACK %s.%n" + ANSI_RESET, j.getUsername());
                        break;
                    }
                }
                if(userFound){
                    break;
                }
            } catch (NumberFormatException e ){
                System.out.println(ANSI_RED + "Error: Please enter a valid number" + ANSI_RESET);
            } catch (IllegalArgumentException e){
                System.out.println(ANSI_RED +"Error: " + e.getMessage() + ANSI_RESET);
            }

        }
        return userFound;
    }

    public static void mainMenu(ArrayList<Item> itemList){
        String menuSelect = "";
        boolean exitMenu = false;
        Scanner sc = new Scanner(System.in);
        while (!exitMenu){

            System.out.printf("%n%1$s Main Menu %1$s", LINE_MENU);
            System.out.printf("%n At any point you can enter "+ANSI_RED +"x" + ANSI_RESET + " to exit that menu.");
            System.out.printf("%n 1-Add new item%n 2-Purchase item%n "+ ANSI_RED +"X-Exit" +ANSI_RESET+"%n :");
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
                    System.out.printf(ANSI_YELLOW + "%nError please select one the available menus" + ANSI_RESET);
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


        System.out.printf("%n%1$s Adding Item %1$s%n", LINE_MENU);
        listItems(itemList);

        while(true){
            try {
                System.out.printf("%nEnter Item Name: ");
                String itemName = sc.nextLine().trim();
                if(itemName.equals("x")){
                    break;
                }
                matcher = stringVerification.matcher(itemName);

                if(!matcher.matches()){
                    throw new IllegalArgumentException(ANSI_RED + "Item name must only contain letters, numbers, and spaces, and start with a letter" + ANSI_RESET);
                }

                for(Item item : itemList){
                    if(itemName.equals(item.getItemName())){
                        throw new IllegalArgumentException(ANSI_YELLOW + "Item name already exist." + ANSI_RESET);
                    }
                }



                System.out.printf("%nEnter Item Price: ");
                String price = sc.nextLine().replace(",", ".").trim();
                if(price.equals("x")){
                    break;
                }
                float itemPrice = Float.parseFloat(price.trim());
                if(itemPrice < 0.00f){
                    throw new IllegalArgumentException(ANSI_RED + "Item price cannot be negative" + ANSI_RESET);
                }

                // Item quantity
                System.out.printf("%nEnter Item Quantity: ");
                String quantity = sc.nextLine().trim();
                if (quantity.equals("x")){
                    break;
                }

                int itemQuantity = Integer.parseInt(quantity);
                if(itemQuantity < 0 || itemQuantity > 200){
                    throw new IllegalArgumentException(ANSI_RED + "Item quantity cannot be negative or greater than 200" + ANSI_RESET);
                }


                System.out.printf(ANSI_GREEN + "%n New Item Added: " + ANSI_RESET);
                System.out.printf("%n Item name: %1$s%n Item price: %2$.2f%n Item quantity: %3$d", itemName, itemPrice, itemQuantity);
                itemList.add(new Item(itemName, itemPrice, itemQuantity));

                System.out.printf("%n%nWould you like to add another item? %s%n:", YesNo);
                menuSelect = sc.nextLine().trim();

                if(menuSelect.equals("n")){
                    return itemList;
                }

            } catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Error: Please enter a valid number" + ANSI_RESET);
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
            }

        }


        return itemList;
    }

    public static ArrayList<Item>  purchaseItem(ArrayList<Item> itemList){
        Scanner sc = new Scanner(System.in);
        float grandTotal = 0;
        int amountOfItems = 0;



        while(true){
            try{

                System.out.printf("%n%1$s Purchasing Item %1$s%n", "------------");
                listItems(itemList);
                System.out.printf("%nWhich item would like to purchase: (item id)%nEnter 'x' at any point to exit%n:");
                String uID = sc.nextLine().trim();
                if(uID.equals("x")){
                    break;
                }

                int itemId = Integer.parseInt(uID); // converts string to int

                // searches if id exist
                if(doesItemExist(itemList, itemId)){
                    System.out.println(ANSI_GREEN + "This item is available" + ANSI_RESET);
                } else {
                    throw new IllegalArgumentException(ANSI_YELLOW + "This item 'id' does not exist you sure you entered the right one?"+ ANSI_RESET);
                }

                System.out.printf("%nHow many would you like? (number)%n:");
                String quantity = sc.nextLine().trim();
                if(quantity.equals("x")){
                    break;
                }

                int itemQuantity = Integer.parseInt(quantity);

                if(itemQuantity < 0) {
                    throw new IllegalArgumentException(ANSI_RED + "Item quantity needs to be greater than 0"+ANSI_RESET);
                }

                float subtotal = 0;
                // checks if quantity is available
                for (Item item : itemList) {
                    if (item.getItemId() == itemId) {
                        if (itemQuantity > item.getQuantity()) {
                            throw new IllegalArgumentException(ANSI_RED + "Requested amount is greater than what is available currently"+ANSI_RESET);
                        } else {
                            subtotal += itemQuantity * item.getPrice();
                            System.out.printf("%nWould you like to purchase %d %s%nFor a total of $%.2f %s%n:", itemQuantity, item.getItemName(), subtotal, YesNo);
                            String confirmPurchase = sc.nextLine().trim();
                            if(confirmPurchase.equals("y")){
                                item.setQuantity(itemQuantity);
                                grandTotal += subtotal;
                                amountOfItems += itemQuantity;
                                int inx = itemList.indexOf(item);
                                itemList.set(inx, item);
                            } else {
                                break;
                            }
                        }
                    }
                }

                System.out.printf("%nWould you like to continue shopping? %s%n:", YesNo);
                String continueShopping = sc.nextLine().trim();
                if(continueShopping.equals("n")){
                    System.out.printf("Total of all items bought: $%.2f%nAmount of Items bought: %d", grandTotal, amountOfItems);
                    break;
                }

            } catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Error: Please enter a valid number"+ ANSI_RESET);
            } catch(IllegalArgumentException e){
                System.out.println(ANSI_RED + "Error: "+e.getMessage() + ANSI_RESET);
            }



        }


        return itemList;
    }

    // checks if item id exist or not
    public static boolean doesItemExist(ArrayList<Item> itemList, int itemId){
        for(Item item : itemList){
            if(item.getItemId() == itemId){
                return true;
            }
        }
        return false;
    };

    public static void listItems(ArrayList<Item> itemList) {
        final int ITEM_NAME_WIDTH = 15;  // Fixed width for item names

        // display's current format
        System.out.printf("%n %-4s%-" + ITEM_NAME_WIDTH + "s%s %s%n%n", "Id", "Item name", "Price", "Quantity");
        // Print each item with fixed-width formatting
        int quantity = 0;
        for (Item item : itemList) {
            // format the item quantity to be colored
            quantity = item.getQuantity();
            String itemName = item.getItemName();
            String itemQuantity = String.format((quantity <= 3? ANSI_YELLOW : ANSI_WHITE)+"%d"+ANSI_RESET, quantity);
            // Format the name with fixed width
            if (itemName.length() > ITEM_NAME_WIDTH) {
                itemName = itemName.substring(0, ITEM_NAME_WIDTH - 3) + "...";
            }
            // Print the formatted line
            System.out.printf(" %-4s%-" + ITEM_NAME_WIDTH + "s$%.2f x%s%n", item.getItemId(), itemName, item.getPrice(), itemQuantity);
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
// +-- Purchase items
// +---- Display all items available
// +---- Prompt user for item to be purchased (item number)
// +----- Prompt user for the quantity
// +----- Display the subtotal ( item price * quantity)
// +----- Ask if user is finished
// +------- yes, then Display grand total
// +--------- then ask to return to main menu
// +------- no, then go to line 33

// +Finish adding colors