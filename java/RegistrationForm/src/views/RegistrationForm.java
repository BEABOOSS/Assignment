package views;

import controllers.FormController;
import model.States;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Console;
import java.text.ParseException;

public class RegistrationForm extends JPanel {
    private JFormattedTextField pNumField;
    private FormController formController;
    public RegistrationForm(){
        this.setLayout(new BorderLayout());

        //region constant
        final int INPUT_COLS = 10;
        final Font font = new Font("Sans-serif", Font.PLAIN, 15);
        final Font titleFont = new Font("Sans-serif", Font.BOLD, 20);
        final Dimension requiredFieldSize = new Dimension(210, 30);

        final Border blackLine = BorderFactory.createLineBorder(Color.black);
        final Border paddingBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        final Border inputBorder = BorderFactory.createCompoundBorder(blackLine, paddingBorder);
        final String RED_STAR = "*";

        //endregion

        //region Panel
        final JPanel topPan = new JPanel();
        final JPanel centerPan = new JPanel();
        final JPanel bottomPan = new JPanel();
        final GroupLayout layout = new GroupLayout(centerPan);
        topPan.setOpaque(false);
        centerPan.setOpaque(false);
        bottomPan.setOpaque(false);

        centerPan.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //endregion

        //region Title
        final JLabel title = new JLabel("New Account Registration");

        title.setFont(titleFont);
        title.setForeground(Color.BLUE);

        topPan.add(title);
        //endregion

        //region Name
        JLabel nameLab = new JLabel("Name: " + RED_STAR);
        JTextField nameField = new JTextField(INPUT_COLS);
        nameLab.setFont(font);
        nameField.setFont(font);
        nameField.setPreferredSize(requiredFieldSize);
        nameField.setBorder(inputBorder);
        nameField.setBackground(Color.PINK);



        //endregion

        //region Email
        JLabel emailLab = new JLabel("Email: " + RED_STAR);
        JTextField emailField = new JTextField(INPUT_COLS);
        emailLab.setFont(font);
        emailField.setFont(font);
        emailField.setPreferredSize(requiredFieldSize);
        emailField.setBorder(inputBorder);
        emailField.setBackground(Color.PINK);

        //endregion

        //region Password
        JLabel pwdLab = new JLabel("Create Password: " + RED_STAR);
        JPasswordField pwdField = new JPasswordField(INPUT_COLS);
        pwdLab.setFont(font);
        pwdField.setFont(font);
        pwdField.setPreferredSize(requiredFieldSize);
        pwdField.setBorder(inputBorder);
        pwdField.setBackground(Color.PINK);

        JLabel cPwdLab = new JLabel("Confirm Password: " + RED_STAR);
        JPasswordField cPwdField = new JPasswordField(INPUT_COLS);

        cPwdLab.setFont(font);
        cPwdField.setFont(font);
        cPwdField.setPreferredSize(requiredFieldSize);
        cPwdField.setBorder(inputBorder);
        cPwdField.setBackground(Color.PINK);

        //endregion

        //region Gender
        JLabel genderLab = new JLabel("Gender: ");
        ButtonGroup genderGrBtn = new ButtonGroup();
        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");
        genderGrBtn.add(male);
        genderGrBtn.add(female);

        genderLab.setFont(font);
        male.setFont(font);
        female.setFont(font);
        //endregion

        //region Address
        JLabel addrLab = new JLabel("Address: ");
        JTextField addrField = new JTextField(INPUT_COLS);

        addrLab.setFont(font);
        addrField.setFont(font);
        addrField.setPreferredSize(requiredFieldSize);
        addrField.setBorder(inputBorder);
        //endregion

        //region States
        JLabel stateLab = new JLabel("States: ");
        //String[] provinces = {"Select a States", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon", "Nunavut", "Northwest Territories"};
        JComboBox<String> stateCBox = new JComboBox<String>();
        for(States state : States.values()){
            stateCBox.addItem(state.getDisplayName());
        }


        stateCBox.setFont(font);
        stateLab.setFont(font);

        //endregion

        //region Country
        JLabel countryLab = new JLabel("Country: ");
        JTextField countryField = new JTextField(INPUT_COLS);
        countryLab.setFont(font);
        countryField.setFont(font);
        countryField.setPreferredSize(requiredFieldSize);
        countryField.setBorder(inputBorder);
        //endregion

        //region Phone Number
        JLabel pNumLab = new JLabel("Phone Num: ");

        try {
            MaskFormatter phoneNumFormat = new MaskFormatter("### ### ####");
            pNumField = new JFormattedTextField(phoneNumFormat);
        } catch (ParseException e){
            System.err.println(e.getMessage());
        }

        pNumLab.setFont(font);
        pNumField.setFont(font);
        pNumField.setPreferredSize(requiredFieldSize);
        pNumField.setBorder(inputBorder);
        //endregion

        //region Buttons
        JButton submitBtn = new JButton("Submit");
        JButton clearBtn = new JButton("Clear");

        bottomPan.add(submitBtn);
        bottomPan.add(clearBtn);
        //endregion

        //region EventListener
        submitBtn.addActionListener((ActionEvent e)-> {
            formController = new FormController();
            formController.submitForm(nameField, emailField, pwdField, cPwdField, male, female, stateCBox, addrField, countryField, pNumField);
        });

        clearBtn.addActionListener((ActionEvent e) -> {
            formController = new FormController();
            formController.clearForm(nameField, emailField, pwdField, cPwdField, genderGrBtn, stateCBox, addrField, countryField, pNumField);
        });
        //endregion


        //region horizontal alignment
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameLab)
                        .addComponent(emailLab)
                        .addComponent(pwdLab)
                        .addComponent(cPwdLab)
                        .addComponent(genderLab)
                        .addComponent(addrLab)
                        .addComponent(stateLab)
                        .addComponent(countryLab)
                        .addComponent(pNumLab)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameField)
                        .addComponent(emailField)
                        .addComponent(pwdField)
                        .addComponent(cPwdField)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(male)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(female)
                        )
                        .addComponent(addrField)
                        .addComponent(stateCBox)
                        .addComponent(countryField)
                        .addComponent(pNumField)
                )
        );
        //endregion


        //region vertical alignment
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLab)
                        .addComponent(nameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailLab)
                        .addComponent(emailField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pwdLab)
                        .addComponent(pwdField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cPwdLab)
                        .addComponent(cPwdField))
                //
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(genderLab)
                        .addComponent(male)
                        .addComponent(female))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addrLab)
                        .addComponent(addrField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(stateLab)
                        .addComponent(stateCBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(countryLab)
                        .addComponent(countryField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pNumLab)
                        .addComponent(pNumField))
        );
        //endregion


        this.add(topPan, BorderLayout.NORTH);
        this.add(centerPan, BorderLayout.CENTER);
        this.add(bottomPan, BorderLayout.SOUTH);

    }
}







