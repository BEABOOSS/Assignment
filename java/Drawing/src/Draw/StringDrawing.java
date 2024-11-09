package Draw;

import javax.swing.*;
import java.awt.*;

public class StringDrawing {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setTitle("Swag String");
        frame.setLayout(null);

        MyPanel pan = new MyPanel();
        pan.setBounds(0, 0, 800, 800);


        frame.add(pan);
    }
}
