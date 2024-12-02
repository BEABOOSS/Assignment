package controllers;

import model.States;

import javax.swing.*;


import static validators.FormValidator.*;


/**
 * Controls events from the form submit and clear
 */
public class FormController {
    private final String errMessageTitle = "Form Validation ERROR";
//    private final Border blackLine = BorderFactory.createLineBorder(Color.RED);
//    private final Border paddingBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
//    private final Border errorBorder = BorderFactory.createCompoundBorder(blackLine, paddingBorder);

    //region Submit form

    /**
     * @param nameField name
     * @param emailField email
     * @param pwdField password
     * @param cPwdField confirm password
     * @param male male radio button
     * @param female female radio button
     * @param stateCBox stat combo box
     * @param addrField address
     * @param countryField country
     * @param pNumField phone Number
     */
    public void submitForm(
            JTextField nameField,
            JTextField emailField,
            JPasswordField pwdField,
            JPasswordField cPwdField,
            JRadioButton male,
            JRadioButton female,
            JComboBox<String> stateCBox,
            JTextField addrField,
            JTextField countryField,
            JFormattedTextField pNumField
    ){
        try {
            UserController userController = new UserController();
            userController.createUser(
                    nameValidation(nameField),
                    emailValidation(emailField),
                    passwordValidation(pwdField, cPwdField),
                    getGenderSelected(male, female),
                    addressValidation(addrField),
                    getSelectedState(stateCBox),
                    countryValidation(countryField),
                    phoneNumberValidation(pNumField)
            );


        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), errMessageTitle, JOptionPane.ERROR_MESSAGE);
        }
    }
    //endregion

    //region Clear
    public void clearForm(
            JTextField nameField,
            JTextField emailField,
            JPasswordField pwdField,
            JPasswordField cPwdField,
            ButtonGroup genderGrBtn,
            JComboBox<String> stateCBox,
            JTextField addrField,
            JTextField countryField,
            JFormattedTextField pNumField
    ){

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

    //endregion
}
