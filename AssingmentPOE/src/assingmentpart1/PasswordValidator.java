
package assingmentpart1;

/**
 *
 * @author WiehanSmit ST10446545@vcconnect.edu.za ST10446545
 */
public class PasswordValidator {
    
        // Method to check if the password contains a capital letter
    public static boolean containsCapitalLetter(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
    //--------------------------------------------------------------------------

    // Method to check if the password contains a number
    public static boolean containsNumber(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }
    //--------------------------------------------------------------------------

    // Method to check if the password contains a special character
    public static boolean containsSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()-+";
        for (char ch : password.toCharArray()) {
            if (specialCharacters.contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;
    }
    //--------------------------------------------------------------------------

    // Method to check if the password is valid
    public static boolean isValid(String password) {
        return password.length() >= 8 && containsCapitalLetter(password) && containsNumber(password) && containsSpecialCharacter(password);
        
    }
}
//---------------------------- End of File -------------------------------------

