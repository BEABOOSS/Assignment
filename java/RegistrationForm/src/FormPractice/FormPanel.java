package FormPractice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    public FormPanel(){
        JTextField textField;
        JLabel labelPrint = new JLabel();
//        Dimension inputSize = new Dimension(210, 30);
        Dimension inputSize = new Dimension(210, 30);

        Font font = new Font("Sans-serif", Font.PLAIN, 20);
        Font titleFont = new Font("Sans-serif", Font.BOLD, 13);
        Border inputBorder = BorderFactory.createLineBorder(Color.black);


        //region Title
        JPanel titlePan = new JPanel(new BorderLayout(100, 0));
        JLabel title = new JLabel("New Account Registration");

        title.setFont(titleFont);
        title.setForeground(Color.BLUE);

        titlePan.add(title, BorderLayout.WEST);
        titlePan.add(Box.createRigidArea(new Dimension(80, 0)));
        //endregion

        //region Name Input
//        JPanel namePan = new JPanel(new BorderLayout(35, 0));
        JPanel namePan = new JPanel();
        GroupLayout test = new GroupLayout(namePan);
        namePan.setLayout(test);
        test.setAutoCreateGaps(true);
        test.setAutoCreateContainerGaps(true);

        JLabel nameLab = new JLabel("Name:");
        JTextField nameInp = new JTextField();
//        namePan.setBounds(0, 10, 380, 40);

        nameInp.setPreferredSize(inputSize);
        nameInp.setFont(font);
        nameInp.setBorder(inputBorder);
//        nameInp.setBackground(Color.);

//        namePan.add(nameLab, BorderLayout.WEST);
//        namePan.add(nameInp, BorderLayout.EAST);
        test.setHorizontalGroup(
                test.createSequentialGroup()
                        .addComponent(nameLab)
                        //.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                        .addComponent(nameInp)
        );
        test.setVerticalGroup(
                test.createSequentialGroup()
                        .addGroup(test.createParallelGroup(GroupLayout.Alignment.BASELINE))
                        .addComponent(nameLab)
                        .addComponent(nameInp)
        );


        //endregion

        //region Email
        JLabel emailLab = new JLabel("Email Address:");
        JPanel emailPan = new JPanel(new BorderLayout(11, 0));
        JTextField emailInp = new JTextField();
        emailPan.setBounds(0, 20, 380, 40);

        emailInp.setPreferredSize(inputSize);
        emailInp.setFont(font);
        emailInp.setBorder(inputBorder);
//        nameInp.setBackground(Color.);

        emailPan.add(emailLab, BorderLayout.WEST);
        emailPan.add(emailInp, BorderLayout.EAST);
        //endregion

        //region Password And Confirm Pwd
        JLabel passwordLab = new JLabel("Create Password:");
        JLabel confirmPasLab = new JLabel("Confirm Password:");

        JPanel pwdPan = new JPanel(new BorderLayout(2, 0));
        JPanel cPwdPan = new JPanel(new BorderLayout(0, 0));

        JTextField passwordInp = new JTextField();
        JTextField cPasswordInp = new JTextField();
        pwdPan.setBounds(0, 30, 380, 40);
        pwdPan.setBorder(inputBorder);
        cPwdPan.setBounds(0, 40, 380, 40);

        passwordInp.setPreferredSize(inputSize);
        cPasswordInp.setPreferredSize(inputSize);
        passwordInp.setFont(font);
        cPasswordInp.setFont(font);
        passwordInp.setBorder(inputBorder);
        cPasswordInp.setBorder(inputBorder);
//        nameInp.setBackground(Color.);

        pwdPan.add(passwordLab, BorderLayout.WEST);
        pwdPan.add(passwordInp, BorderLayout.EAST);

        cPwdPan.add(confirmPasLab, BorderLayout.WEST);
        cPwdPan.add(cPasswordInp, BorderLayout.EAST);

        //endregion

        //region Gender
        JLabel genderLab = new JLabel("Gender:");
        //endregion

        //region Address
        JLabel addressLab = new JLabel("Address:");
        //endregion

        //region State
        JLabel stateLab = new JLabel("State:");
        //endregion

        //region Country
        JLabel countryLab = new JLabel("Country:");
        //endregion

        //region Phone Number
        JLabel phoneNumLab = new JLabel("Phone Num:");
        // endregion



        //region Example
        JLabel lab = new JLabel("Name: ");
        textField = new JTextField(20);
        JButton btn = new JButton("Save");

        btn.addActionListener(e -> {
            btn.setEnabled(false);
            lab.setText("Processing...");

            SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
                @Override
                protected Integer doInBackground() throws Exception {
                    return 0;
                }

                @Override
                protected void done(){
                    try {
                        throw new NumberFormatException("tarstarstarstar");

                    } catch (Exception ex){
                        System.out.printf(ex.getMessage());
                    }

                }
            };
            worker.execute();
        });
        //endregion


        //region Add Component to panel

        this.add(titlePan);
        //
        this.add(namePan);
        this.add(emailPan);
        this.add(pwdPan);
        this.add(cPwdPan);




    }


}




// ---There is no need for placeholders (the text inside the text boxes)
// ---You can also use a picture for the submit / clear button
// ---On submit, display all the data entered in the console.
// ---Your form should look somewhat similar to mine.
// ---Use Mask Formatter for phone no
// ---Print error messages.