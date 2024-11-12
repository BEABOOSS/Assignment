package FormPractice;

import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JFrame {
    public RegistrationForm(){
//        DefaultFrame frame = new DefaultFrame();
        JPanel frame = new JPanel();
        FormPanel formPanel = new FormPanel();


        this.setSize(400, 600);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("New Account Registration");
        frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));

        frame.add(formPanel);
        this.setContentPane(frame);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationForm form = new RegistrationForm();
            form.setVisible(true);
        });

    }
}
