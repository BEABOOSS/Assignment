package FormPractice;

import javax.swing.*;
import java.awt.*;

public class Testing extends JFrame {
    public Testing(){

        //region settings
            this.setSize(400, 500);
            this.setResizable(false);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLayout(new BorderLayout());
        //endregion

        JPanel mainPan = new JPanel();

        MenuBar bar = new MenuBar(Testing.this, mainPan);
        this.add(mainPan, BorderLayout.CENTER);
    }

}
