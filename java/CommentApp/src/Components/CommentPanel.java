package Components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class CommentPanel extends JFrame {
    static final int MAX_CHARACTER = 200;
    static final int MINIMUM_LENGTH = 2;
    static final int THRESH_HOLD_CHAR = 150;
    static final String frameTitle = "Comment";
    static final String writeMessage = "Write a comment";
    final Border inputBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.black),
            BorderFactory.createEmptyBorder(3, 3, 3, 3));

    public CommentPanel(String username, Frame parentFrame){
        // region settings
        this.setTitle(frameTitle);
        this.setSize(400, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //endregion

        // region Title
        final JPanel title = new JPanel();
        final JLabel greeting = new JLabel(username);
        final JLabel charLeftLab = new JLabel("0/200");
        greeting.setFont(new Font("Sans-serif", Font.BOLD, 20));
        greeting.setText("Hi " + username +"!!");
        title.add(greeting);
        title.add(charLeftLab);
        //endregion

        //region Textarea
        final JPanel txtArPan = new JPanel();
        final JTextArea textArea = new JTextArea(6, 25);
        textArea.setFont(new Font("Sans-serif", Font.PLAIN, 13));
        textArea.setBorder(inputBorder);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        txtArPan.add(textArea);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharsLeft(textArea,charLeftLab);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharsLeft(textArea,charLeftLab);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharsLeft(textArea,charLeftLab);
            }
        });

        //endregion

        //region Button
        final JPanel buttonPan = new JPanel();
        final JButton logOutBtn = new JButton("Log Out");
        final JButton sendCommentBtn = new JButton("Send");
        buttonPan.setLayout(new BorderLayout(10, 0));

        buttonPan.add(logOutBtn, BorderLayout.WEST);
        buttonPan.add(sendCommentBtn, BorderLayout.EAST);

        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.setEnabled(true);
                parentFrame.setVisible(true);
                CommentPanel.super.dispose();
            }
        });

        sendCommentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageVerification(textArea.getText());
            }
        });
        //endregion

        this.add(title, BorderLayout.NORTH);
        this.add(buttonPan, BorderLayout.SOUTH);
        this.add(txtArPan, BorderLayout.CENTER);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                greeting.setText(writeMessage);
            }
        });
    }

    private void messageVerification(String text){
        int messageLen = text.length();
        if(messageLen >= MINIMUM_LENGTH && messageLen <= MAX_CHARACTER){
            JOptionPane.showMessageDialog(null, text, "Message sent", JOptionPane.PLAIN_MESSAGE);
        } else if(messageLen > MAX_CHARACTER) {
            JOptionPane.showMessageDialog(null, "Message Too Long", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Message needs contain more than one character", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void updateCharsLeft(JTextArea textArea, JLabel label){
        String text = textArea.getText();
        int textLen = text.length();
        String characterLeft = String.format("%d/%d", textLen, MAX_CHARACTER);

        if(textLen > THRESH_HOLD_CHAR)
            label.setForeground(Color.red);
        else
            label.setForeground(Color.black);

        label.setText(characterLeft);
    }
}
