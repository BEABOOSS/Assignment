package views;

import javax.swing.*;
import java.awt.*;

public class FormBody extends JFrame {
    static final String frameTitle = "New Account Registration";
    public FormBody(){
        //region settings
            this.setResizable(false);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setTitle(frameTitle);
            this.setLayout(new BorderLayout());
        //endregion

        RegistrationForm form = new RegistrationForm();
        MenuBar bar = new MenuBar(FormBody.this, form);
        this.add(form, BorderLayout.CENTER);
        this.pack();

    }
}
