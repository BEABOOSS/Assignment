import Components.CommentBtnFrame;
import Components.CommentFrame;
import Components.DisplayFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {



        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CommentBtnFrame frame = new CommentBtnFrame();
                //CommentFrame frame = new CommentFrame("bob");
                //frame.setVisible(true);
            }
        });




    }
}
// Todo
// +-- 1- Write A comment button
// +-- 2- Confirm user wants to write a comment yes/no
// +-- 3- *Yes -> Input for username *while loop till the username is correct //
// +-- 3.5- JPassword while loop till password is correct * error message will appear if password is wrong
// -- 4- once successful create a new JFrame with a greeting message two buttons send and log out, and textarea
// -- 4.5- once user sends comment (first verify if comment.length >= 2 && < 200) JOption.showdialogmessage
// -- 4.6- on log out the step 4 frame close but the step 1 frame reappears.
