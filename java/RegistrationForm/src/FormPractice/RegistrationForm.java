package FormPractice;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationForm extends JFrame {
    private JFormattedTextField pNumField;
    static final String frameTitle = "New Account Registration";
    private static final String NOT_SELECTED = "Did not specify";
    public RegistrationForm(){

        //region settings
        this.setSize(400, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(frameTitle);
        this.setLayout(new BorderLayout());
        //endregion

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

        //region State
        JLabel stateLab = new JLabel("State: ");
        String[] provinces = {"Select a State", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon", "Nunavut", "Northwest Territories"};
        JComboBox<String> stateCBox = new JComboBox<String>(provinces);
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
        //JTextField pNumField = new JTextField(INPUT_COLS);

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
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.printf("%nName: %s", nameValidation(nameField.getText()));
                    System.out.printf("%nEmail: %s", emailValidation(emailField.getText()));
                    System.out.printf("%nPassword: %s", passwordValidation(pwdField.getPassword(), cPwdField.getPassword()));
                    System.out.printf("%nGender: %s", getGenderSelected(male, female));
                    System.out.printf("%nState: %s", getSelectedState(stateCBox));
                    System.out.printf("%nStreet: %s", addressValidation(addrField.getText()));
                    System.out.printf("%nCountry: %s", countryValidation(countryField.getText()));
                    System.out.printf("%nPhone Number: %s", phoneNumberValidation(pNumField.getText()));

                } catch (IllegalArgumentException ex) {
                    System.out.printf("%nError: %s", ex.getMessage());
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                pwdField.setText("");
                cPwdField.setText("");
                genderGrBtn.clearSelection();
                addrField.setText("");
                stateCBox.setSelectedIndex(0);
                countryField.setText("");
                pNumField.setValue(null);
            }
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

    private static String nameValidation(String name) {
        Pattern stringVerification = Pattern.compile("[A-Za-z]+");
        Matcher matcher = stringVerification.matcher(name);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'Name' was not entered correctly");
        }
        return name;
    }

    private static String emailValidation(String email) {
        Pattern stringVerification = Pattern.compile("(?!\\.)[\\w\\-_.]*[^.](@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])");
        Matcher matcher = stringVerification.matcher(email);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'email' was not entered correctly");
        }
        return email;
    }

    private static String passwordValidation(char[] password, char[] cPassword) {
        final int MINIMUM_LENGTH = 5;
        if(password.length < MINIMUM_LENGTH){
            throw new IllegalArgumentException("Field 'password' please enter a longer password. To ensure that your information is not stolen.");
        } else if(!Arrays.equals(password, cPassword)){
            throw new IllegalArgumentException("Fields 'password' do not match. Please ensure that you enter the same password in both fields");
        }

        return  Arrays.toString(password).replaceAll("\\[|]|,|\\s", "");
    }

    private static String getGenderSelected(JRadioButton male, JRadioButton female){
        if (male.isSelected()){
            return "Male";
        }
        if (female.isSelected()) {
            return "Female";
        }

        return NOT_SELECTED;

    }

    private static String getSelectedState(JComboBox<String> box){
        final int NOT_ALLOWED = 0;
        int selectedIndex = box.getSelectedIndex();
        if(selectedIndex != NOT_ALLOWED){
            return (String)box.getSelectedItem();
        }
        return NOT_SELECTED;
    }

    private static String addressValidation(String address) {
        Pattern addrPattern = Pattern.compile("[\\w\\s]+,[\\w\\s]+");
        String addr = address.trim();
        Matcher matcher = addrPattern.matcher(addr);
        if(addr.isEmpty()){
            return NOT_SELECTED;
        } else if(!matcher.matches()) {
            throw new IllegalArgumentException("Field 'address' please use the required pattern shown in the tooltip");
        }

        return addr;
    }

    private static String countryValidation(String country) {
        Pattern stringVerification = Pattern.compile("[A-Za-z]+");
        String countryTrimmed = country.trim();
        Matcher matcher = stringVerification.matcher(countryTrimmed);
        if(countryTrimmed.isEmpty()){
            return NOT_SELECTED;
        } else if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'country' was not entered correctly");
        }
        return countryTrimmed;
    }

    private static String phoneNumberValidation(String phoneNumber) {
        String trimmed = phoneNumber.trim();
        if (trimmed.isEmpty()){
            return NOT_SELECTED;
        } else if(trimmed.length() != 12) {
            throw new IllegalArgumentException("Field 'phone number' please enter your full phone number");
        }
        return trimmed;
    }
}



