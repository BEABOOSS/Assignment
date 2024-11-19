package model;

import java.util.Arrays;

public class User {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String address;
    private String state;
    private String country;
    private String phoneNumber;

    public User(
            String Name,
            String Email,
            String Password,
            String Gender,
            String Address,
            String State,
            String Country,
            String PhoneNumber
    ){
        this.name = Name;
        this.email = Email;
        this.password = Password;
        this.gender = Gender;
        this.address = Address;
        this.state = State;
        this.country = Country;
        this.phoneNumber = PhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}