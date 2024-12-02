
import dao.UserDAO;
import model.User;
import views.FormBody;

import javax.swing.*;


public class Main {


    // *** before running ***
    // src/dao/UserDao
    // change: DB_URL, DB_USERNAME, DB_PASSWORD
    // Make sure that the table users does not already exist in the
    //      current Database (registration)
    // or you can just change them if easier
    
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
//            FormBody form = new FormBody();
            // go fix both Gender and states to work with integers instead of strings
            UserDAO can = new UserDAO();
            can.createTable();
        });

    }

}

