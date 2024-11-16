package Components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPanel extends JPanel {
    public TestPanel(){


        JButton btn = new JButton("Popup");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.QUESTION_MESSAGE, null);

            }
        });

        JButton btn2 = new JButton("button2");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "something", "this title", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if(res == JOptionPane.OK_OPTION){
                    System.out.println("Good to go");
                } else if (res == JOptionPane.NO_OPTION){
                    System.out.println("Darn");
                } else if (res == JOptionPane.CANCEL_OPTION){
                    System.out.println("bye bye");
                }
            }
        });

        JButton btn3 = new JButton("Button3");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = "";
                do {

                    res = JOptionPane.showInputDialog(null, "What is your name", "Get information", JOptionPane.QUESTION_MESSAGE);
                    if(res != null){
                        System.out.printf("%nYour name: %s%n", res);
                    } else {
                        JOptionPane.showMessageDialog(null, "No name entered");
                    }
                } while(res == null);
            }
        });


        JButton btn4 = new JButton("Button4");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] pizzas = {"Cheese", "All dressed", "Peperoni", "Mexican", "Veggie"};
                String topping = (String)JOptionPane.showInputDialog(
                        null,
                        "what is your favorite topping",
                        "Pizza",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        pizzas,
                        0
                        );
                System.out.println("Your favorite topping is: "+topping );
                }
        });

        // Design button
        JPanel txtPanel = new JPanel();
        LineBorder border = new LineBorder(Color.black, 2, true);
        TitledBorder titledBorder = new TitledBorder(border, "Top panel");

        txtPanel.setBorder(titledBorder);

        JLabel lab = new JLabel("Type your name: ");
        JTextField txtf = new JTextField();
        txtf.setText("Enter your name");
        txtf.setPreferredSize(new Dimension(200, 30));
        txtf.setBackground(Color.WHITE);
        txtf.setForeground(Color.GRAY);

        txtf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtf.setText("");

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton clr = new JButton();

        this.add(btn);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        txtPanel.add(lab);
        txtPanel.add(txtf);
        this.add(txtPanel);
    }
}
