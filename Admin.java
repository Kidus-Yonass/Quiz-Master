//Filename: Admin.java
//Authors: Kidus, Nebiy
//Date Created: May 2026
//Purpose: Represents an admin user. Extends User and handles login validation against users.txt.

import java.time.LocalDate;

public class Admin extends User {

    private String username;
    private String password;

    public Admin(String username, String password) {
        super(username, 0, "N/A", LocalDate.now().toString());
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    //Checks entered credentials against all entries in users.txt
    public static boolean login(String enteredUsername, String enteredPassword) {
        String[][] users = FileHandler.loadUsers();
        for (int i = 0; i < users.length; i++) {
            if (users[i].length == 2
                    && users[i][0].trim().equals(enteredUsername.trim())
                    && users[i][1].trim().equals(enteredPassword.trim())) {
                return true;
            }
        }
        return false;
    }
}
