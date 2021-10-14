package database.service.impl;

import database.exception.LoginException;

import java.sql.*;

import static database.Constants.*;

public class Login {

    private Connection connection;
    private boolean isLoggedToDatabase = false;
    private boolean isAdminLogged = false;

    /**
     * Log in to the database.
     * @throws LoginException Own Login Exception.
     */
    public void logInToTheDatabase() throws LoginException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            setLoggedToDatabase(true);
        } catch (SQLException e) {
            setLoggedToDatabase(false);
            throw new LoginException("Database login error", e);
        }
    }

    /**
     * Log in user to database.
     * @param name Entered username.
     * @param password Entered password.
     * @throws LoginException Own Login Exception.
     */
    public void logInUser(String name, String password) throws LoginException {
        try {
            PreparedStatement ps = connection.prepareStatement(USERLOGIN);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                setAdminLogged(true);
            }
        } catch (SQLException e) {
            setAdminLogged(false);
            throw new LoginException("Error to log in. Wrong username or password", e);
        }
    }


    public boolean isLoggedToDatabase() {
        return isLoggedToDatabase;
    }


    private void setLoggedToDatabase(boolean loggedToDatabase) {
        isLoggedToDatabase = loggedToDatabase;
    }


    public boolean isAdminLogged() {
        return isAdminLogged;
    }

    public void setAdminLogged(boolean adminLogged) {
        isAdminLogged = adminLogged;
    }

    public Connection getConnection() {
        return connection;
    }

}
