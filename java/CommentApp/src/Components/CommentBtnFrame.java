package Components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CommentBtnFrame extends JFrame {
    JFrame frame = this;
    private HashMap<String, String> userInformation;
    private boolean isLoggedIn = false;
    public CommentBtnFrame(){
        frame.setVisible(true);
        userInformation = new HashMap<>();
        userInformation.put("warren", "monkey");
        userInformation.put("bob", "apple");

        frame.setTitle("Assignment");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton comment = new JButton();
        comment.setText("Comment");
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = "";
                int response = JOptionPane.showConfirmDialog(null, "Would you like to write a comment?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.OK_OPTION){
                    do {
                        username = checkUsername();
                        if(!username.isEmpty()){
                            if(checkPassword()){
                                isLoggedIn = true;
                                frame.setVisible(false);
                                frame.set

                            }
                        }
                    } while(!isLoggedIn);

                    if(isLoggedIn){
                        CommentFrame subFrame = new CommentFrame(username);
                        subFrame.setVisible(true);


                        if (!subFrame.isActive()){
                            System.out.println("UUrrm this is awkward");
                            isLoggedIn = false;
                            frame.setVisible(true);

                        }
                    }

                }


            }
        });

        frame.add(comment);

    }

    private String checkUsername(){
        String username = "";
        username = JOptionPane.showInputDialog(null, "Enter Your Username: ", "Username", JOptionPane.QUESTION_MESSAGE);
        for (String i : userInformation.keySet()){
            if(username.equals(i)){
                return i;
            }
        }
        return "";
    }

    private boolean checkPassword(){
        String password = "";
        do{
            password = JOptionPane.showInputDialog(null, "Enter Your Password: ", "Password", JOptionPane.QUESTION_MESSAGE);
            for (String i : userInformation.keySet()){
                if (password.equals(userInformation.get(i))){
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Wrong password", "Wrong Password", JOptionPane.WARNING_MESSAGE);
        } while (true);
    }
}

