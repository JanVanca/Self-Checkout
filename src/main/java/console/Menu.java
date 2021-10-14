package console;

import core.Settings;
import database.exception.LoginException;
import database.service.impl.Login;

import java.util.Scanner;

public class Menu {

    private final Console console = new Console();
    private final Settings settings = new Settings();
    private final Login login = new Login();


    /**
     * Starts the self-service cash register and launches the basic menu.
     */
    public void start() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        logInToTheDatabase();
        System.out.println("Welcome to self-service cash");
        while (choice != 5) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Start");
            System.out.println("2. Slovensky");
            System.out.println("3. English");
            System.out.println("4. Administrator");
            System.out.println("5. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    startCash(login, settings);
                    break;
                case 2:
                    settings.setSlovakLanguage();
                    break;
                case 3:
                    settings.setEnglishLanguage();
                    break;
                case 4:
                    logInUser();
                    break;
            }
        }
    }

    /**
     * Stars console.
     */
    private void startCash(Login login, Settings settings) {
        console.start(login, settings);

    }

    /**
     * Log in to the database.
     */
    private void logInToTheDatabase() {
        try {
            login.logInToTheDatabase();
        } catch (LoginException e) {
            System.out.println("Failed login to database" + e);
            e.printStackTrace();
        }
    }

    /**
     * Log user in to the database.
     */
    private void logInUser() {
        Scanner input = new Scanner(System.in);
        String username = "";
        String password = "";
        if (login.isLoggedToDatabase()) {
            System.out.println("Enter username: ");
            username = input.nextLine().trim();
            System.out.println("Enter password: ");
            password = input.nextLine().trim();
            try {
                login.logInUser(username, password);
            } catch (LoginException e) {
                System.out.println("Login failed.");
                e.printStackTrace();
            }

            if (!login.isAdminLogged()) {
                System.out.println("Login failed. Wrong username or password");
            }
        }
    }
}
