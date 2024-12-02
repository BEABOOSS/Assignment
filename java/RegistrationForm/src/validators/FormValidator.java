package validators;

import model.Gender;
import model.States;

import javax.swing.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Validates the fields from the form
 */
public class FormValidator {
    private static final String NOT_SPECIFIED = "N/A";
    private static final int MAX_LENGTH = 120;


    /**
     * @param input name field
     * @return name
     * @throws IllegalArgumentException if the input is not well entered
     */
    public static String nameValidation(JTextField input) {
        Pattern stringVerification = Pattern.compile("[A-Za-z]+");
        String name = input.getText();
        Matcher matcher = stringVerification.matcher(name);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'name' was not entered correctly");
        }
        if(name.length() > MAX_LENGTH){
            throw new IllegalArgumentException("Field 'name' exceeds the maximum length by " + (name.length() - MAX_LENGTH));
        }
        return name;
    }

    /**
     * @param input email field
     * @return email
     * @throws IllegalArgumentException if the input is not well entered
     */
    public static String emailValidation(JTextField input) {
        String email = input.getText();
        Pattern stringVerification = Pattern.compile("(?!\\.)[\\w\\-_.]*[^.](@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])");
        Matcher matcher = stringVerification.matcher(email);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'email' was not entered correctly");
        }
        if(email.length() > MAX_LENGTH){
            throw new IllegalArgumentException("Field 'email' exceeds the maximum length by " + (email.length() - MAX_LENGTH));
        }
        return email;
    }

    /**
     * @param inputA password field
     * @param inputB password field
     * @return password
     * @throws IllegalArgumentException if the input don't match
     */
    public static String passwordValidation(JPasswordField inputA, JPasswordField inputB) {
        char[] password = inputA.getPassword();
        char[] cPassword = inputB.getPassword();

        final int MINIMUM_LENGTH = 5;
        if(password.length < MINIMUM_LENGTH){
            throw new IllegalArgumentException("Field 'password' please enter a longer password. To ensure that your information is not stolen.");
        }
        if(!Arrays.equals(password, cPassword)){
            throw new IllegalArgumentException("Fields 'password' do not match. Please ensure that you enter the same password in both fields");
        }

        return  Arrays.toString(password).replaceAll("\\[|]|,|\\s", "");
    }

    /**
     * @param male male field
     * @param female female field
     * @return phone Number
     */
    public static Gender getGenderSelected(JRadioButton male, JRadioButton female){
        if (male.isSelected()){
            return Gender.Male;
        }
        if (female.isSelected()) {
            return Gender.Female;
        }

        return Gender.Other;

    }

    /**
     * @param box combo
     * @return the state selected
     */
    public static String getSelectedState(JComboBox<String> box){
        final int NOT_ALLOWED = 0;
        int selectedIndex = box.getSelectedIndex();
        if(selectedIndex != NOT_ALLOWED){
            return States.getName((String)box.getSelectedItem());
        }
        return null;
    }

    /**
     * @param input address field
     * @return address
     */
    public static String addressValidation(JTextField input) {
        String address = input.getText().trim();
        if(address.isEmpty()){
            return NOT_SPECIFIED;
        }

        if(address.length() > MAX_LENGTH){
            throw new IllegalArgumentException("Field 'address' exceeds the maximum length by " + (address.length() - MAX_LENGTH));
        }
        return address;
    }

    /**
     * @param input country field
     * @return country
     * @throws IllegalArgumentException if the input is not well entered
     */
    public static String countryValidation(JTextField input) {
        String country = input.getText().trim();
        Pattern stringVerification = Pattern.compile("[A-Za-z]+");
        Matcher matcher = stringVerification.matcher(country);
        if(country.isEmpty()){
            return NOT_SPECIFIED;
        }
        if(!matcher.matches()){
            throw new IllegalArgumentException("Field 'country' was not entered correctly");
        }

        if(country.length() > MAX_LENGTH){
            throw new IllegalArgumentException("Field 'country' exceeds the maximum length by " + (country.length() - MAX_LENGTH));
        }
        return country;
    }

    /**
     * @param input formatted field
     * @return phone Number
     * @throws IllegalArgumentException if the input is not well entered
     */
    public static String phoneNumberValidation(JFormattedTextField input) {
        String phoneNumber = input.getText().trim();
        if (phoneNumber.isEmpty()){
            return NOT_SPECIFIED;
        }
        if(phoneNumber.length() != 12) {
            throw new IllegalArgumentException("Field 'phone number' please enter your full phone number");
        }
        return phoneNumber;
    }

}
