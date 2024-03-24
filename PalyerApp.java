package main;

import java.util.ArrayList;

import lib.Player;

/**
 * PlayerApp class provides a method to process a list of players and filter
 * out those who meet certain criteria.
 * 
 * @author Mehdi Sellam
 * 
 */
public class PlayerApp {

    /**
     * Executes the player processing based on the specified criteria.
     *
     * @param participants The list of players to process.
     * @param number       The number to filter players by.
     * @return A formatted string containing the names of valid players.
     */
    public static String execute(ArrayList<Player> participants, int number) {
        StringBuilder result = new StringBuilder();

        for (Player player : participants) {
            if (isValidPlayer(player, number)) {
                result.append(formatPlayerName(player)).append("\n");
            }
        }

        return result.toString();
    }

    /**
     * Checks if a player is valid based on the specified criteria.
     *
     * @param player The player to check.
     * @param number The number to filter players by.
     * @return True if the player is valid, false otherwise.
     */
    private static boolean isValidPlayer(Player player, int number) {
        String surname = player.getName().getFamilyName().toLowerCase();
        String gamerTag = player.getGamerTag().toLowerCase();
        return gamerTag.contains(surname) && gamerTag.endsWith(String.valueOf(number));
    }

    /**
     * Formats the name of a player.
     *
     * @param player The player to format.
     * @return A formatted string containing the player's name.
     */
    private static String formatPlayerName(Player player) {
        String firstName = player.getName().getFirstName().toUpperCase();
        String surname = player.getName().getFamilyName().toLowerCase();
        return firstName + ", " + surname;
    }
}
