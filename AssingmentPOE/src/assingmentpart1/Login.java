
package assingmentpart1;

import javax.swing.JOptionPane;

/**
 *
 * @author WiehanSmit ST10446545@vcconnect.edu.za ST10446545
 */
public class Login {
    
    //Declarations
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    //--------------------------------------------------------------------------

    public Login() {
        // Default constructor
    }
    //--------------------------------------------------------------------------
    //Checks the Username

    public boolean checkUserName(String username) {
        return username != null && username.length() <= 5 && username.contains("_");
    }
    //--------------------------------------------------------------------------
    // Checks the password complexity

    public boolean checkPasswordComplexity(String password) {
        // Password must be at least 8 characters long, contain a capital letter, a number, and a special character
        return password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9].*");
    }
    //--------------------------------------------------------------------------
    //RegisterUser for the username and password

    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        //----------------------------------------------------------------------

        // Registration successful
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        return "Registration successful!";
    }
    //--------------------------------------------------------------------------

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }
    //--------------------------------------------------------------------------
    //Login Status 

    public String returnLoginStatus() {
        if (username != null && password != null) {
            return "Login successful! Welcome, " + firstName + " " + lastName + ". It's great to see you again.";
        } else {
            return "Failed login. You need to create an account first!";
        }
    }
}
//---------------------------- End of File -------------------------------------

