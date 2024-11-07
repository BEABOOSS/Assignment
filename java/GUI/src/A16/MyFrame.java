package A16;

import javax.swing.*;
import java.awt.*;

public class MyFrame {
    /**
     * @param args
     */
    public static void main(String[] args){
        JFrame frame = new JFrame("Testing");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        JPanel pans[] = new JPanel[5];
        JButton btns[] = new JButton[4];


        pans[0] = new JPanel();
        pans[0].setBackground(Color.BLUE);
        pans[0].setPreferredSize(new Dimension(90, 0));
        btns[0] = new JButton("Test");
        pans[0].add(btns[0]);
        frame.add(pans[0], BorderLayout.EAST);



        pans[1] = new JPanel();
        pans[1].setBackground(Color.GRAY);
        pans[1].setPreferredSize(new Dimension(90, 0));
        frame.add(pans[1], BorderLayout.WEST);

        pans[2] = new JPanel();
        pans[2].setBackground(Color.BLACK);
        pans[2].setPreferredSize(new Dimension(1, 50));
        frame.add(pans[2], BorderLayout.NORTH);

        pans[3] = new JPanel();
        pans[3].setBackground(Color.RED);
        pans[3].setPreferredSize(new Dimension(1, 100));
        frame.add(pans[3], BorderLayout.SOUTH);

        pans[4] = new JPanel();
        pans[4].setBackground(Color.MAGENTA);
        pans[4].setPreferredSize(new Dimension(1, 100));
        frame.add(pans[4], BorderLayout.CENTER);



        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
