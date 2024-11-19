package dao;

import model.User;

import javax.swing.*;
import java.sql.*;

/**
 * Database operation for User saveUser
 */
public class UserDAO {
    //MysqlDataSource dataSource = new MysqlDataSource();
    private final String DB_URL = "jdbc:mysql://localhost:3306/registration";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "";


    /**
     * Takes in a user object then sends the information of the object to be saved in the database
     * @param user User object
     */
    public void saveUser(User user){

        String sqlQuery = "INSERT INTO users VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preState =  conn.prepareStatement(sqlQuery);
        ) {
            if(!doesUserTableExist()){
                createTable();
            }

            // driver the make the connection
            Class.forName("com.mysql.cj.jdbc.Driver");

            preState.setString(1, user.getName());
            preState.setString(2, user.getEmail());
            preState.setString(3, user.getPassword());
            preState.setString(4, user.getGender());
            preState.setString(5, user.getAddress());
            preState.setString(6, user.getState());
            preState.setString(7, user.getCountry());
            preState.setString(8, user.getPhoneNumber());


            // execute the query
            preState.executeUpdate();
            // confirmation of update

        } catch (SQLException sqlException){
            System.err.printf("%nSQL ERROR CODE: %d%nERROR MESSAGE: %s%n%n END", sqlException.getErrorCode(), sqlException.getMessage());
            JOptionPane.showMessageDialog(null, "Seems something went wrong please try again", "BD ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "OOPS...", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createTable(){

        String sqlQuery = "CREATE TABLE users "
        + "(user_ID INTEGER PRIMARY KEY AUTO_INCREMENT,"
        + " username VARCHAR(120),"
        + " email VARCHAR(120),"
        + " password VARCHAR(120),"
        + " gender VARCHAR(120),"
        + " address VARCHAR(120),"
        + " state VARCHAR(120),"
        + " country VARCHAR(120),"
        + " phoneNumber VARCHAR(12)"
        + ");";

        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preState =  conn.prepareStatement(sqlQuery);
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");


            preState.executeUpdate();
            System.out.println("Table created");
        } catch (SQLException sqlException){
            System.err.printf("%nSQL ERROR CODE: %d%nERROR MESSAGE: %s%n%n END", sqlException.getErrorCode(), sqlException.getMessage());
            JOptionPane.showMessageDialog(null, "Seems something went wrong please try again", "BD ERROR", JOptionPane.ERROR_MESSAGE);
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "OOPS...", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean doesUserTableExist(){
        String sqlQuery = "SELECT * FROM users";

        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preState =  conn.prepareStatement(sqlQuery);
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");


            preState.execute();
            return true;
        } catch (SQLException sqlException){
            if(sqlException.getErrorCode() == 1146){
                return false;
            }
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "OOPS...", JOptionPane.ERROR_MESSAGE);
            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "OOPS...", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
