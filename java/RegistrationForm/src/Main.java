

import FormPractice.RegistrationForm;

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
            RegistrationForm form = new RegistrationForm();
        });




    }

}