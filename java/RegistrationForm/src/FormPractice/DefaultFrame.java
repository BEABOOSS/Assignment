package FormPractice;

import javax.swing.*;

public class DefaultFrame extends JFrame {
    public DefaultFrame(){

        this.setSize(800, 800);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
