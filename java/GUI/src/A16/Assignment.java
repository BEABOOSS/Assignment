package A16;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Assignment {
    public static void main(String[] args) {
        Dimension PANEL_SIZE = new Dimension(200, 0);
        Dimension NE_BTNS_SIZE = new Dimension(190, 75);
        Dimension SE_BTNS_SIZE = new Dimension(61, 395);

        JFrame frame = new JFrame();
        JPanel[] pans = new JPanel[3];
        JButton[] btns = new JButton[8];
        Border lightGrayBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY);

        frame.setSize(600, 600);
        // Panel West
        pans[0] = new JPanel();
        pans[0].setPreferredSize(PANEL_SIZE);
        // Panel Center
        pans[1] = new JPanel();
        pans[1].setPreferredSize(PANEL_SIZE);
        // Panel East
        pans[2] = new JPanel();
        pans[2].setPreferredSize(PANEL_SIZE);


        // West buttons
        btns[0] = new JButton("BTN1");
        btns[0].setBackground(Color.BLUE);
        btns[0].setForeground(Color.WHITE);
        btns[0].setPreferredSize(new Dimension(190, 140));
        btns[0].setBorder(lightGrayBorder);

        btns[1] = new JButton("BTN2");
        btns[1].setBackground(Color.BLUE);
        btns[1].setForeground(Color.WHITE);
        btns[1].setPreferredSize(new Dimension(190, 410));
        btns[1].setBorder(lightGrayBorder);



        // Center button
        btns[2] = new JButton("BTN3");
        btns[2].setBackground(Color.BLUE);
        btns[2].setForeground(Color.WHITE);
        btns[2].setPreferredSize(new Dimension(180, 555));
        btns[2].setBorder(lightGrayBorder);



        // East buttons
        btns[3] = new JButton("BTN4");
        btns[3].setBackground(Color.BLUE);
        btns[3].setForeground(Color.WHITE);
        btns[3].setPreferredSize(NE_BTNS_SIZE);
        btns[3].setBorder(lightGrayBorder);

        btns[4] = new JButton("BTN5");
        btns[4].setBackground(Color.BLUE);
        btns[4].setForeground(Color.WHITE);
        btns[4].setPreferredSize(NE_BTNS_SIZE);
        btns[4].setBorder(lightGrayBorder);

        btns[5] = new JButton("BTN6");
        btns[5].setBackground(Color.BLUE);
        btns[5].setForeground(Color.WHITE);
        btns[5].setPreferredSize(SE_BTNS_SIZE);
        btns[5].setBorder(lightGrayBorder);

        btns[6] = new JButton("BTN7");
        btns[6].setBackground(Color.BLUE);
        btns[6].setForeground(Color.WHITE);
        btns[6].setPreferredSize(SE_BTNS_SIZE);
        btns[6].setBorder(lightGrayBorder);

        btns[7] = new JButton("BTN8");
        btns[7].setBackground(Color.BLUE);
        btns[7].setForeground(Color.WHITE);
        btns[7].setPreferredSize(SE_BTNS_SIZE);
        btns[7].setBorder(lightGrayBorder);



        // Adding the components to the frame
        pans[0].add(btns[0]);
        pans[0].add(btns[1]);
        frame.add(pans[0], BorderLayout.WEST);


        pans[1].add(btns[2]);
        frame.add(pans[1], BorderLayout.CENTER);

        pans[2].add(btns[3]);
        pans[2].add(btns[4]);
        pans[2].add(btns[5]);
        pans[2].add(btns[6]);
        pans[2].add(btns[7]);
        frame.add(pans[2], BorderLayout.EAST);


        frame.setVisible(true);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
