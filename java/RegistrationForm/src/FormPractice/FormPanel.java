package FormPractice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    public FormPanel(){
        Dimension inputSize = new Dimension(210, 30);
        Font font = new Font("Sans-serif", Font.PLAIN, 15);
        Font titleFont = new Font("Sans-serif", Font.BOLD, 20);
        Border inputBorder = BorderFactory.createLineBorder(Color.black);
        int inputCols = 12;

        //region Title
        JPanel titlePan = new JPanel(new BorderLayout(100, 0));
        JLabel title = new JLabel("New Account Registration");

        title.setFont(titleFont);
        title.setForeground(Color.BLUE);

        titlePan.add(title, BorderLayout.WEST);
        titlePan.add(Box.createRigidArea(new Dimension(80, 0)));
        //endregion

        //region Name Input
        JPanel namePan = new JPanel(new SpringLayout());
        JLabel nameLab = new JLabel("Name:");
        namePan.add(nameLab);
        JTextField nameInp = new JTextField(inputCols);
        nameInp.setPreferredSize(inputSize);
        nameLab.setLabelFor(nameInp);
        namePan.add(nameInp);
        nameLab.setFont(font);
        nameInp.setBorder(inputBorder);
        SpringUtilities.makeCompactGrid(namePan, 1, 2, 6, 6, 60, 6);
        //endregion

        //region Email
        JPanel emailPan = new JPanel(new SpringLayout());
        JLabel emailLab = new JLabel("Email Address:");
        emailPan.add(emailLab);
        JTextField emailInp = new JTextField(inputCols);
        emailInp.setPreferredSize(inputSize);
        emailLab.setLabelFor(emailInp);
        emailPan.add(emailInp);
        emailLab.setFont(font);
        emailInp.setBorder(inputBorder);
        SpringUtilities.makeCompactGrid(emailPan, 1, 2, 6, 6, 30, 6);

        //endregion

        //region Password And Confirm Pwd
        JPanel pwdPan = new JPanel(new SpringLayout());
        JLabel passwordLab = new JLabel("Create Password:");
        pwdPan.add(passwordLab);
        JTextField passwordInp = new JTextField(inputCols);
        pwdPan.add(passwordInp);
        passwordLab.setLabelFor(passwordInp);
        passwordInp.setPreferredSize(inputSize);
        passwordLab.setFont(font);
        SpringUtilities.makeCompactGrid(pwdPan, 1, 2, 6, 6, 30, 6);

        JPanel cPwdPan = new JPanel(new SpringLayout());
        JLabel cPwdLab = new JLabel("Confirm Password:");
        cPwdPan.add(cPwdLab);
        JTextField cPwdInp = new JTextField(inputCols);
        cPwdLab.setLabelFor(cPwdInp);
        cPwdPan.add(cPwdInp);
        cPwdLab.setPreferredSize(inputSize);
        cPwdLab.setFont(font);
        cPwdInp.setBorder(inputBorder);
        SpringUtilities.makeCompactGrid(cPwdPan, 1, 2, 6, 6, 30, 6);

        //endregion

        //region Gender
        JPanel genderPan = new JPanel(new SpringLayout());
        JLabel genderLab = new JLabel("Gender:");
        genderLab.setFont(font);
        ButtonGroup gender = new ButtonGroup();
        genderPan.add(genderLab);
        JRadioButton male = new JRadioButton("Male");
        genderPan.add(male);
        gender.add(male);
        male.setFont(font);
        JRadioButton female = new JRadioButton("Female");
        genderPan.add(female);
        gender.add(female);
        female.setFont(font);

        SpringUtilities.makeCompactGrid(genderPan, 1, 3, 6, 6, 30, 6);

        //endregion

        //region Address
        JPanel addressPan = new JPanel(new SpringLayout());
        JLabel addressLab = new JLabel("Address:");
        addressPan.add(addressLab);
        addressLab.setFont(font);
        JTextField addressInp = new JTextField(inputCols);
        addressPan.add(addressInp);
        addressInp.setFont(font);
        addressInp.setPreferredSize(inputSize);
        addressInp.setBorder(inputBorder);
        addressLab.setLabelFor(addressInp);

        addressPan.add(addressLab);
        addressPan.add(addressInp);

        SpringUtilities.makeCompactGrid(addressPan, 1, 2, 6, 6, 30, 6);

        //endregion

        //region State
        JPanel statePan = new JPanel(new SpringLayout());
        JLabel stateLab = new JLabel("State:");
        stateLab.setFont(font);
        statePan.add(stateLab);
        String[] provinces = {""};
        JComboBox<String> combo = new JComboBox<String>();
        //endregion

        //region Country
        JLabel countryLab = new JLabel("Country:");
        //endregion

        //region Phone Number
        JLabel phoneNumLab = new JLabel("Phone Num:");
        // endregion

        //region Example
//        JLabel lab = new JLabel("Name: ");
//        textField = new JTextField(20);
//        JButton btn = new JButton("Save");
//
//        btn.addActionListener(e -> {
//            btn.setEnabled(false);
//            lab.setText("Processing...");
//
//            SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
//                @Override
//                protected Integer doInBackground() throws Exception {
//                    return 0;
//                }
//
//                @Override
//                protected void done(){
//                    try {
//                        throw new NumberFormatException("tarstarstarstar");
//
//                    } catch (Exception ex){
//                        System.out.printf(ex.getMessage());
//                    }
//
//                }
//            };
//            worker.execute();
//        });
        //endregion


        //region Add Component to panel

        this.add(titlePan);
        //
        this.add(namePan);
        //
        this.add(emailPan);
        //
        this.add(pwdPan);
        this.add(cPwdPan);
        //
        this.add(genderPan);
        //
        this.add(addressPan);




    }


}




// ---There is no need for placeholders (the text inside the text boxes)
// ---You can also use a picture for the submit / clear button
// ---On submit, display all the data entered in the console.
// ---Your form should look somewhat similar to mine.
// ---Use Mask Formatter for phone no
// ---Print error messages.