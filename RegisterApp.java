package main;

import lib.Name;
import lib.Register;

/**
 * RegisterApp class provides a method to update a register and generate emails
 * based on specific criteria.
 * 
 * @author Mehdi Sellam
 */
public class RegisterApp {

    /**
     * Executes the register processing based on the specified criteria.
     *
     * @param nm    The name to add to the register.
     * @param regst The register to update.
     * @return A formatted string containing emails generated from the register.
     */
    public static String execute(Name nm, Register regst) {
        regst.removeName(1);
        regst.addName(nm);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < regst.sizeOfRegister(); i++) {
            Name currentName = regst.getName(i);
            if (hasCharacterInFirstName(currentName, 'a') || hasCharacterInFirstName(currentName, 'e')) {
                result.append(formatEmail(currentName)).append("\n");
            }
        }

        return result.toString();
    }

    /**
     * Checks if a name has a specific character in the first name.
     *
     * @param name      The name to check.
     * @param character The character to check for.
     * @return True if the character is present, false otherwise.
     */
    private static boolean hasCharacterInFirstName(Name name, char character) {
        String firstName = name.getFirstName().toLowerCase();
        return firstName.indexOf(character) != -1;
    }

    /**
     * Formats an email based on the specified criteria.
     *
     * @param name The name to generate the email from.
     * @return A formatted email string.
     */
    private static String formatEmail(Name name) {
        char firstChar = name.getFirstName().toLowerCase().charAt(0);
        String surname = name.getFamilyName().substring(0, 3).toLowerCase();
        return String.format("%c.%s@email.com", firstChar, surname);
    }
}

