package database;

public class Constants {

    /**
     * Database login data.
     */
    public static final String URL = "jdbc:mysql://localhost:3306/cash?serverTimezone=GMT";
    public static final String USER = "root";
    public static final String PASSWORD = "";


    /**
     * User login data.
     */
    public static final String USERLOGIN = "select * FROM users WHERE name=? AND password=?";
}
