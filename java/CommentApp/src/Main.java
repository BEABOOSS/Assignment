import Components.CommentBtnFrame;

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
            CommentBtnFrame frame1 = new CommentBtnFrame();
        });




    }

}
// Todo
// +-- 1- Write A comment button
// +-- 2- Confirm user wants to write a comment yes/no
// +-- 3- *Yes -> Input for username *while loop till the username is correct //
// +-- 3.5- JPassword while loop till password is correct * error message will appear if password is wrong
// +-- 4- once successful create a new JFrame with a greeting message two buttons send and log out, and textarea
// +-- 4.5- once user sends comment (first verify if comment.length >= 2 && < 200) JOption.showdialogmessage
// +-- 4.6- on log out the step 4 frame close but the step 1 frame reappears.
// +-- Make it look better
