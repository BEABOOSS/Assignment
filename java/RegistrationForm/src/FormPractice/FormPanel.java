package FormPractice;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormPanel extends JPanel {
    private JFormattedTextField phoneNumInp;
    public FormPanel() {
        //region Variables
        final Dimension requiredFieldSize = new Dimension(210, 40);
        final Dimension inputFieldSize = new Dimension(210, 30);
        final Font font = new Font("Sans-serif", Font.PLAIN, 15);
        final Font titleFont = new Font("Sans-serif", Font.BOLD, 20);
        final Border inputBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black),
                BorderFactory.createEmptyBorder(0, 5, 0, 2));
        Border requiredBorder = BorderFactory.createTitledBorder(inputBorder,"Required");
        final int inputCols = 12;
        //endregion

        //region Title
        JPanel titlePan = new JPanel(new BorderLayout(100, 0));
        JLabel title = new JLabel("New Account Registration");

        title.setFont(titleFont);
        title.setForeground(Color.BLUE);

        titlePan.add(title, BorderLayout.WEST);
        titlePan.add(Box.createRigidArea(new Dimension(30, 0)));
        //endregion

        //region Name Input
        JPanel namePan = new JPanel(new SpringLayout());
        JLabel nameLab = new JLabel("Name:");
        namePan.add(nameLab);
        JTextField nameInp = new JTextField(inputCols);

        nameInp.setPreferredSize(requiredFieldSize);
        nameLab.setLabelFor(nameInp);
        namePan.add(nameInp);
        nameLab.setFont(font);
        nameInp.setBorder(requiredBorder);
        SpringUtilities.makeCompactGrid(namePan, 1, 2, 6, 0, 60, 0);
        //endregion

        //region Email
        JPanel emailPan = new JPanel(new SpringLayout());
        JLabel emailLab = new JLabel("Email Address:");
        emailPan.add(emailLab);
        JTextField emailInp = new JTextField(inputCols);
        emailInp.setPreferredSize(requiredFieldSize);
        emailLab.setLabelFor(emailInp);
        emailPan.add(emailInp);
        emailLab.setFont(font);
        emailInp.setBorder(requiredBorder);
        SpringUtilities.makeCompactGrid(emailPan, 1, 2, 6, 0, 30, 0);

        //endregion

        //region Password And Confirm Pwd
        JPanel pwdPan = new JPanel(new SpringLayout());
        JLabel passwordLab = new JLabel("Create Password:");
        pwdPan.add(passwordLab);
        JPasswordField passwordInp = new JPasswordField(inputCols);
        passwordLab.setLabelFor(passwordInp);
        pwdPan.add(passwordInp);
        passwordInp.setPreferredSize(requiredFieldSize);
        passwordLab.setFont(font);
        passwordInp.setBorder(requiredBorder);
        SpringUtilities.makeCompactGrid(pwdPan, 1, 2, 6, 0, 30, 0);

        //
        JPanel cPwdPan = new JPanel(new SpringLayout());
        JLabel cPwdLab = new JLabel("Confirm Password:");
        cPwdPan.add(cPwdLab);
        JPasswordField cPwdInp = new JPasswordField(inputCols);
        cPwdLab.setLabelFor(cPwdInp);
        cPwdPan.add(cPwdInp);
        cPwdInp.setPreferredSize(requiredFieldSize);
        cPwdLab.setFont(font);
        cPwdInp.setBorder(requiredBorder);
        SpringUtilities.makeCompactGrid(cPwdPan, 1, 2, 0, 0, 20, 0);
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

        SpringUtilities.makeCompactGrid(genderPan, 1, 3, 6, 0, 30, 0);

        //endregion

        //region Address
        JPanel addressPan = new JPanel(new SpringLayout());
        JLabel addressLab = new JLabel("Address:");
        addressPan.add(addressLab);
        addressLab.setFont(font);
        JTextField addressInp = new JTextField(inputCols);
        addressPan.add(addressInp);
        addressInp.setFont(font);
        addressInp.setPreferredSize(inputFieldSize);
        addressInp.setBorder(inputBorder);
        addressLab.setLabelFor(addressInp);

        addressPan.add(addressLab);
        addressPan.add(addressInp);

        SpringUtilities.makeCompactGrid(addressPan, 1, 2, 6, 0, 30, 0);

        //endregion

        //region State
        JPanel statePan = new JPanel(new SpringLayout());
        JLabel stateLab = new JLabel("State:");
        stateLab.setFont(font);
        statePan.add(stateLab);
        String[] provinces = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon", "Nunavut", "Northwest Territories"};

        JComboBox<String> combo = new JComboBox<String>(provinces);
        statePan.add(combo);
        SpringUtilities.makeCompactGrid(statePan, 1, 2, 6, 0, 30, 0);

        //endregion

        //region Country
        JPanel countryPan = new JPanel(new SpringLayout());
        JLabel countryLab = new JLabel("Country:");
        countryPan.add(countryLab);
        countryLab.setFont(font);
        JTextField countryInp = new JTextField(inputCols);
        countryPan.add(countryInp);
        countryInp.setFont(font);
        countryInp.setPreferredSize(inputFieldSize);
        countryInp.setBorder(inputBorder);
        countryLab.setLabelFor(countryInp);

        countryPan.add(countryLab);
        countryPan.add(countryInp);

        SpringUtilities.makeCompactGrid(countryPan, 1, 2, 6, 0, 30, 0);

        //endregion

        //region Phone Number
        JPanel phoneNumPan= new JPanel(new SpringLayout());
        JLabel phoneNumLab = new JLabel("Phone Number:");
        phoneNumPan.add(phoneNumLab);
        phoneNumLab.setFont(font);

        try {
            MaskFormatter phoneNumFormat = new MaskFormatter("### ### ####");
            phoneNumInp = new JFormattedTextField(phoneNumFormat);


        } catch (ParseException e){
            System.err.println(e.getMessage());
        }

        phoneNumPan.add(phoneNumInp);
        assert phoneNumInp != null;
        phoneNumInp.setPreferredSize(inputFieldSize);
        phoneNumInp.setBorder(inputBorder);
        phoneNumInp.setColumns(inputCols);

        phoneNumLab.setLabelFor(phoneNumInp);

        phoneNumPan.add(phoneNumLab);
        phoneNumPan.add(phoneNumInp);
        SpringUtilities.makeCompactGrid(phoneNumPan, 1, 2, 6, 0, 30, 0);


        //endregion

        //region Submit/Clear
        JPanel buttonPan = new JPanel(new SpringLayout());
        JButton submit = new JButton("Submit");
        buttonPan.add(submit);
        JButton clear = new JButton("Clear");
        buttonPan.add(clear);
        SpringUtilities.makeCompactGrid(buttonPan, 1, 2, 6, 6, 30, 6);

        //endregion

        //region EventListener
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.printf("%nName: %s", nameValidation(nameInp.getText()));
                    System.out.printf("%nEmail: %s", emailValidation(emailInp.getText()));
                    System.out.printf("%nPassword: %s", passwordValidation(passwordInp.getPassword(), cPwdInp.getPassword()));
                    getGenderSelected(male, female);
                    System.out.printf("%nStreet: %s", addressValidation(addressInp.getText()));
                    System.out.printf("%nCountry: %s", countryValidation(countryInp.getText()));
                    System.out.printf("%nPhone Number: %s", phoneNumberValidation(phoneNumInp.getText()));

                } catch (IllegalArgumentException ex) {
                    System.out.printf("%nError: %s", ex.getMessage());
                }

            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameInp.setText("");
                emailInp.setText("");
                passwordInp.setText("");
                cPwdInp.setText("");
                gender.clearSelection();
                addressInp.setText("");
                combo.setSelectedIndex(0);
                countryInp.setText("");
            }
        });


//        clear.addActionListener(e -> {
//            clear.setEnabled(false);
//            //lab.setText("Processing...");
//            SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
//                @Override
//                protected Integer doInBackground() throws Exception {
//                    return 0;
//                }
//
//                @Override
//                protected void done(){
//                    try {
//                        throw new NumberFormatException("Bee Boop");
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
        //
        this.add(statePan);
        //
        this.add(countryPan);
        //
        this.add(phoneNumPan);
        //
        this.add(buttonPan);
        //endregion

    }

    //region Validation Methods

    /**
     * Returns a strings that is checked with a regex pattern
     * to see if it meats the requirements
     * @param name String
     * @throws IllegalArgumentException throw when the name entered does not meat requirements
     * @return string
     */
    private static String nameValidation(String name)throws IllegalArgumentException{
        Pattern stringVerification = Pattern.compile("[A-Za-z]+");
        Matcher matcher = stringVerification.matcher(name);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'Name' was not entered correctly");
        }
        return name;
    }

    /**
     * Returns a strings that is checked with a regex pattern
     * to see if it meats the requirements
     * @param email String
     * @throws IllegalArgumentException throw when the email does not meet requirements
     * @return email
     */
    private static String emailValidation(String email)throws IllegalArgumentException{
        Pattern stringVerification = Pattern.compile("(?!\\.)[\\w\\-_.]*[^.](@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])");
        Matcher matcher = stringVerification.matcher(email);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'email' was not entered correctly");
        }
        return email;
    }

    /**
     * Returns a strings
     * @param password password
     * @param cPassword confirmed password
     * @throws IllegalArgumentException throw when password is too short or when both passwords don't match
     * @return password
     */
    private static String passwordValidation(char[] password, char[] cPassword)throws IllegalArgumentException{
        int MINIMUM_LENGTH = 5;
        if(password.length < MINIMUM_LENGTH){
            throw new IllegalArgumentException("Field 'password' please enter a longer password. To ensure that your information is not stolen.");
        } else if(!Arrays.equals(password, cPassword)){
            throw new IllegalArgumentException("Fields 'password' do not match. Please ensure that you enter the same password in both fields");
        }

        return  Arrays.toString(password).replaceAll("\\[|\\]|,|\\s", "");
    }

    private static void getGenderSelected(JRadioButton male, JRadioButton female){
        if (male.isSelected()){
            System.out.printf("%nGender: Male");
        } else if (female.isSelected()) {
            System.out.printf("%nGender: Female");
        } else {
            System.out.printf("%nGender: ");
        }
    }

    /**
     * Returns a strings
     * @param address address String
     * @throws IllegalArgumentException throw when address string is not correctly formatted ex."123 st StreetName, City"
     * @return password
     */
    private static String addressValidation(String address)throws IllegalArgumentException {
        Pattern addrPattern = Pattern.compile("[\\w\\s]+,[\\w\\s]+");
        String addr = address.trim();
        Matcher matcher = addrPattern.matcher(addr);
        if(addr.isEmpty()){
            return addr;
        } else if(!matcher.matches()) {
            throw new IllegalArgumentException("Field 'address' please use the required pattern shown in the tooltip");
        }

        return addr;
    }

    /**
     * Returns a strings that is checked with a regex pattern
     * to see if it meats the requirements
     * @param country String
     * @throws IllegalArgumentException throw when the country's name does not follow the regex pattern "\w";
     * @return string
     */
    private static String countryValidation(String country)throws IllegalArgumentException{
        Pattern stringVerification = Pattern.compile("[A-Za-z]+");
        String countryTrimmed = country.trim();
        Matcher matcher = stringVerification.matcher(countryTrimmed);
        if(countryTrimmed.isEmpty()){
            return countryTrimmed;
        } else if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'country' was not entered correctly");
        }
        return countryTrimmed;
    }

    /**
     * Returns a strings that is checked with a regex pattern
     * to see if it meats the requirements
     * @param phoneNumber String
     * @throws IllegalArgumentException throw when phone number is not entered complete
     * @return string
     */
    private static String phoneNumberValidation(String phoneNumber)throws IllegalArgumentException{
        String trimmed = phoneNumber.trim();
        if (trimmed.isEmpty()){
            return trimmed;
        } else if(trimmed.length() != 12) {
            throw new IllegalArgumentException("Field 'phone number' please enter your full phone number");
        }
        return trimmed;
    }

    //endregion
}




// ---There is no need for placeholders (the text inside the text boxes)
// ---You can also use a picture for the submit / clear button
// ---On submit, display all the data entered into the console.
// ---Your form should look somewhat similar to mine.
// ---Use Mask Formatter for phone no
// ---Print error messages.