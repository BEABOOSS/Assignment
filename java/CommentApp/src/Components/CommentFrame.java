package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentFrame extends JFrame {
    JFrame frame = this;
    public CommentFrame(String username){
        frame.setTitle("Assignment");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton logOutBtn = new JButton("LogOut");
        JButton sendCommentBtn = new JButton("Send");
        JTextArea textArea = new JTextArea();
        JLabel greeting = new JLabel(username);

        frame.add(greeting, BorderLayout.PAGE_START);
        frame.add(logOutBtn, BorderLayout.WEST);
        frame.add(sendCommentBtn, BorderLayout.EAST);
        frame.add(textArea, BorderLayout.CENTER);


        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                System.out.println("SHutting down");
                frame.dispose();
            }
        });
    }
}
