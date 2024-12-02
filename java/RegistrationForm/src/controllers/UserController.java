package controllers;

import dao.UserDAO;
import model.Gender;
import model.States;
import model.User;

import javax.swing.*;

public class UserController {
    private final UserDAO userDAO;

    public UserController(){
        this.userDAO = new UserDAO();
    }


    /**
     * Creates a new user object and then saves it to the table
     *
     * @param name string
     * @param email string
     * @param password string
     * @param gender string
     * @param address string
     * @param states string
     * @param country string
     * @param phoneNumber string
     */
    public void createUser(String name, String email, String password, Gender gender, String address, String states, String country, String phoneNumber){
        User user = new User(name, email, password, gender, address, states, country, phoneNumber);
        //JOptionPane.showMessageDialog(null, "Would you like to save your details?");

        String wantToSave = String.format(
                "Would you like to save this information?%nName: %s%nEmail: %s%nPassword: %s%nGender: %s%nAddress: %s%nState: %s%nCountry: %s%nPhone Number: %s%n",
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getGender(),
                user.getAddress(),
                user.getState(),
                user.getCountry(),
                user.getPhoneNumber());
        int choice = JOptionPane.showConfirmDialog(null, wantToSave, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choice == JOptionPane.YES_OPTION){
            userDAO.saveUser(user);
        }


    }

}
