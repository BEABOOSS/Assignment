===================================================================================
===============================   ASSIGNMENT 12   =================================
===================================================================================

You are to create a console cash register with the following use cases:

	a. Program starts and asks for the Cashier Number, for example, 147852 
		    (you should provide username & password information as hardcode 
            in your application, let's say for 10 users) (25pts)
	   • If the Cashier Number is RIGHT, the program greets 
            the user: WELCOME BACK FELICIA.
	   • If the Cashier Number is WRONG, the user has 3 tries before the application ends 
		    with the following message: YOU HAVE EXCEEDED THE NUMBER OF TRIES, 
            ARE YOU SURE YOU HAVE THE RIGHT NUMBER?

	b. Once the Cashier is in, the program presents the following menu: (10pts)
	   i. Add new items
	   ii. Purchase items
	   iii. Exit

	c. Add new items: (20pts)
	  • By default, the application has 7 items:
		i. 	Water		$1.99 
		ii. 	Juice		$2.55 
		iii. 	Red Bull	$3.99 
		iv. 	Sandwich	$6.99 
		v. 	Beer		$5.00 
		vi. 	Bagel		$3.65
		vii. 	Coffee		$2.25

	   • The program displays the existing items and asks the Cashier for 
            new items to be registered, 
		    until "X" is entered to go back to the main Menu. 
            The program displays the items gradually as they are entered.

	d. Purchase item: (25pts)
	   • The application displays all the items that can be purchased, 
            including non-default items 
		    (items added by the Cashier), and asks for the item to be purchased 
            (go by item number), then asks for the quantity, then displays the subtotal 
            (item price x quantity). Asks if finished,if so, 
            displays the Grand Total and asks to return to the main Menu, 
            if not continue shopping, 
	   • (See the following screenshot). Validation at all times is expected.

(20 pts for using functions wisely, try/catch for validation, user friendliness ...)
In your program, there should be an option to get back to the main menu.
The only way to exit the program is by hitting "X" on the main menu.
If the user selects an invalid choice from the menu, the program should display an error message.
Remember why functions are used for, use them wisely.
Number validation is a must. (No negative numbers for price and so on)
Using try/catch is a must.
Run until the users hit Exit.
Please make something USER FRIENDLY.