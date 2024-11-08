package A16;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class AssignmentPT2 {

    public static void main(String[] args) {
        Dimension NORTH_PANEL = new Dimension(0, 120);
        Dimension CENTER_PANEL = new Dimension(0, 360);
        Dimension SOUTH_PANEL = new Dimension(0, 120);
        Dimension NORTH_SIZE = new Dimension(180, 70);
        Dimension NHORI_GAP_SIZE = new Dimension(190,  0);
        Dimension NVERT_PADDING = new Dimension(0,  130);

        FlowLayout experimentLayout = new FlowLayout();
        JFrame frame = new JFrame();
        JPanel[] pans = new JPanel[8];
        JButton[] btns = new JButton[5];
        Border lightGrayBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY);

        // Main three panels
        pans[0] = new JPanel();
        pans[0].setPreferredSize(NORTH_PANEL);
        pans[0].setBackground(Color.RED);

        pans[1] = new JPanel();
        pans[1].setPreferredSize(CENTER_PANEL);
        pans[1].setBackground(Color.BLUE);

        pans[2] = new JPanel();
        pans[2].setPreferredSize(SOUTH_PANEL);
        pans[2].setBackground(Color.GREEN);

        // North Panels

        pans[3] = new JPanel();
        pans[3].setPreferredSize(NORTH_SIZE);
        pans[3].setBackground(Color.CYAN);

        pans[4] = new JPanel();
        pans[4].setPreferredSize(NORTH_SIZE);
        pans[4].setBackground(Color.GRAY);



        // Center Panels

        // left panel with btns
        BoxLayout boxLayout = new BoxLayout(pans[5], BoxLayout.Y_AXIS);
        pans[5] = new JPanel();
        pans[5].setLayout(boxLayout);
        pans[5].setBackground(Color.WHITE);

        btns[0] = new JButton();
        btns[0].setText("BIG BUTTON");

        btns[1] = new JButton();
        btns[1].setText("BTN2");

        btns[2] = new JButton();
        btns[2].setText("BTN3");

        btns[3] = new JButton();
        btns[3].setText("BTN4");


        // --------------------------

        // the order here is very important
        pans[0].add(Box.createRigidArea(NVERT_PADDING));
        pans[0].add(pans[3]);
        pans[0].add(Box.createRigidArea(NHORI_GAP_SIZE));
        pans[0].add(pans[4]);


        pans[1].add(pans[5]);
        pans[1].add(btns[0]);
//        pans[5].add(btns[1]);
//        pans[5].add(btns[2]);
//        pans[5].add(btns[3]);



        frame.add(pans[0], BorderLayout.NORTH);
        frame.add(pans[1], BorderLayout.CENTER);
        frame.add(pans[2], BorderLayout.SOUTH);


        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
