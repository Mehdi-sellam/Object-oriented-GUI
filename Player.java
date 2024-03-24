package lib;

/**
 * The Player class represents a player with a name, a rollable object, and a hypothetical gamerTag.
 * This class is part of a hypothetical game system.
 *
 * The class includes constructors for creating instances with default values
 * and for customizing the name, rollable object, and gamerTag.
 *
 * It also provides methods for accessing and modifying player information, such as rolling the dice.
 * The toString method is implemented to provide a standard string representation of a Player.
 *
 * @author Mehdi Sellam
 */
public class Player implements Comparable<Player> {

    // Fields
    private Name playerName;
    private Rollable rollable; // Updated from PairOfDice to Rollable
    private String gamerTag;

    // Constructors

    /**
     * Default constructor that creates a player with null name, a new PairOfDice, and null gamerTag.
     */
    public Player() {
        playerName = new Name();
        rollable = new PairOfDice(); // Default value for PairOfDice
        gamerTag = "";
    }

    /**
     * Custom constructor that accepts a name and gamertag, creating a new PairOfDice with default values.
     *
     * @param playerName the name of the player
     * @param gamerTag   the gamerTag of the player
     */
    public Player(Name playerName, String gamerTag) {
        this.playerName = playerName;
        this.rollable = new PairOfDice(); // Default value for PairOfDice
        this.gamerTag = gamerTag;
    }

    /**
     * Custom constructor that allows creating a player with specified name, rollable object, and gamertag.
     *
     * @param playerName the name of the player
     * @param rollable   the rollable object associated with the player
     * @param gamerTag   the gamertag of the player
     */
    public Player(Name playerName, String gamerTag, Rollable rollable) {
        this.playerName = playerName;
        this.rollable = rollable;
        this.gamerTag = gamerTag;
    }
    
    

    // Methods
    
    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public Name getName() {
        return playerName;
    }

    /**
     * Sets the name of the player.
     *
     * @param playerName the new name for the player
     */
    public void setName(Name playerName) {
        this.playerName = playerName;
    }

    /**
     * Returns the rollable object associated with the player.
     *
     * @return the rollable object
     */
    public Rollable getRollable() {
        return rollable;
    }

    /**
     * Rolls the dice associated with the player.
     */
    public void rollDice() {
        rollable.roll();
    }

    /**
     * Returns the current score of the player's dice.
     *
     * @return the current score
     */
    public int getDiceScore() {
        return rollable.getScore();
    }

    /**
     * Sets the gamerTag of the player.
     *
     * @param gamerTag the new gamerTag for the player
     */
    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    /**
     * Returns the gamerTag of the player.
     *
     * @return the gamerTag
     */
    public String getGamerTag() {
        return gamerTag;
    }

    /**
     * Sets the full name of the player using a space-separated string.
     *
     * @param fullName the full name string
     */
    public void setFullPlayerName(String fullName) {
        String[] names = fullName.split(" ");
        if (names.length >= 2) {
            playerName = new Name(names[0], names[1]);
        }
    }

    /**
     * Generates a gamerTag based on the given number.
     *
     * @param num the number used to generate the gamerTag
     */
    /**
     * Generates a gamerTag based on the given number.
     *
     * @param num the number used to generate the gamerTag
     */
    public void generateGamerTag(int num) {
        if (num > 0 && num <= 100) {
            String reversedName = playerName.getFirstName().toLowerCase() + playerName.getFamilyName().toLowerCase();
            gamerTag = reversedName + num;
        }
    }



    /**
     * Sets the full name of the player using separate first and family names.
     *
     * @param firstName the first name
     * @param familyName the family name
     */
    public void setFullPlayerName(String firstName, String familyName) {
        playerName = new Name(firstName, familyName);
    }

    @Override
    public String toString() {
        return "Player{" +
                "Name=" + playerName +
                ", Rollable=" + rollable +
                ", GamerTag='" + gamerTag + '\'' +
                '}';
    }

    @Override
    public int compareTo(Player otherPlayer) {
        int nameComparison = this.playerName.compareTo(otherPlayer.playerName);
        if (nameComparison == 0) {
            return this.gamerTag.compareTo(otherPlayer.gamerTag);
        }
        return nameComparison;
    }
}
