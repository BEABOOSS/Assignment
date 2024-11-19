
import views.FormBody;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {

        try {
            // Use the system's native look and feel instead of Metal
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }



        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.

        SwingUtilities.invokeLater(() -> {
            FormBody form = new FormBody();
        });




    }

}

// +--Create a new table "users" 8+1 cols (col 1 user id's)
//      the rest is for the information the user submits

// +--Validate the forms input before inserting it into the db

// +--If any errors are detected during the validation process,
//      prompt the user with an error message box indicating the specific
//      issues that need to be addressed. Optionally, you can also display
//      error messages directly on the form next to the relevant fields or
//      by making the field border red

// +--Once all information is validated successfully, display a confirmation
//      message box to the user, summarizing the details entered.
//      Prompt the user to confirm whether they wish to proceed with
//      adding their information to the database.

// +--If the user confirms their details, add the entered information to
//      the "users" table in the database.
