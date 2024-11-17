package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class CommentBtnFrame extends JFrame {

    private final HashMap<String, String> userInformation;
    static final String frameTitle = "Write Comment";


    public CommentBtnFrame(){

        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        this.add(mainPanel);
        this.setVisible(true);
        userInformation = new HashMap<>();
        userInformation.put("warren", "monkey");
        userInformation.put("bob", "apple");

        // region settings
        this.setTitle(frameTitle);
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //endregion

        final JButton commentBtn = new JButton("Comment");
        mainPanel.add(commentBtn);

        commentBtn.addActionListener(e -> commentLogin());
    }

    private void commentLogin() {
        String username = "";
        int response = JOptionPane.showConfirmDialog(null, "Would you like to write a comment?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.OK_OPTION){
            username = checkCredentials();
            if(!username.isEmpty()){
                CommentPanel cPan = new CommentPanel(username, CommentBtnFrame.this);
                CommentBtnFrame.super.setVisible(false);
                CommentBtnFrame.super.setEnabled(false);
                cPan.setVisible(true);
            }


        }

    }

    private String checkCredentials(){
        String username ="";
        String password = "";
        String correctPassword = "";
        while(true){
            username = JOptionPane.showInputDialog(null, "Enter Your Username: ", "Username", JOptionPane.QUESTION_MESSAGE);
            if(userInformation.containsKey(username)){
                password = JOptionPane.showInputDialog(null, "Enter Your Password: ", "Password", JOptionPane.QUESTION_MESSAGE);
                correctPassword = userInformation.get(username);
                if(password.equals(correctPassword)){
                    return username;
                }
            }

        }
    };
}

