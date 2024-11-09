package Draw;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyPanel extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Font f = new Font("Arial", Font.BOLD, 20);
        g.setFont(f);

        g.setColor(Color.GRAY);
        g.fillOval(120, 6, 150, 80);

        String[] name = {"W", "A", "R", "R", "E", "N"};
        int[] x = {150, 170, 185, 200, 215, 230};
        int[] y = {50, 55, 50, 55, 50, 55};

        for(int i = 0; i < name.length; i++){
            g.setColor(i % 2 == 0? Color.RED: Color.BLUE);
            g.drawString(name[i], x[i], (i % 2 == 0? 50:55));

        }

        g.drawRoundRect(130, 30, 130, 30, 20,15);

        try {
            Image img = ImageIO.read(new File("C:\\Users\\warre\\OneDrive\\Pictures\\squared.jpg"));
            g.drawImage(img, 250, 250, 300, 300, this);
        } catch (Exception e){
            e.printStackTrace();
        }

        g.setColor(Color.GREEN);
        g.drawOval(250, 250, 300, 300);


        // 6 side each of 80px of length


        int[] xP = {200, 600, 780, 600, 200, 20};
        int[] yP = {200, 200, 400, 600, 600, 400};

        g.setColor(Color.BLUE);
        g.drawPolygon(xP, yP, 6);


        int[] a = {80, 160, 200, 160, 80, 40};
        int[] b = {610, 610, 542, 474, 474, 542};
        g.setColor(Color.BLACK);
        g.drawPolygon(a, b, 6);


    }
}
