package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Aggregation of Names.
 * 
 *
 * @author Mehdi Sellam
 *
 */
public class Register implements Iterable<Name> {

    // Fields
    private ArrayList<Name> nameList;
    private final int registerCapacityRoom;

    // Constructors

    /**
     * Constructs a Register with a specified room capacity.
     *
     * @param registerCapacityRoom the room capacity of the register
     */
    public Register(int registerCapacityRoom) {
        nameList = new ArrayList<>();
        this.registerCapacityRoom = registerCapacityRoom;
    }

    /**
     * Constructs a Register with a default room capacity of 20.
     */
    public Register() {
        nameList = new ArrayList<>();
        this.registerCapacityRoom = 20;
    }

    // Methods

    /**
     * Gets the room capacity of the register.
     *
     * @return the room capacity
     */
    public int getRoomCapacity() {
        return registerCapacityRoom;
    }

    /**
     * Adds a name to the register.
     *
     * @param name the name to be added
     */
    public void addName(Name name) {
        if (nameList.size() < registerCapacityRoom) {
            nameList.add(name);
        } 
    }

    /**
     * Adds a list of names to the register.
     *
     * @param namesToAdd the list of names to be added
     */
    public void addNames(ArrayList<Name> namesToAdd) {
        if (nameList.size() + namesToAdd.size() <= registerCapacityRoom) {
            nameList.addAll(namesToAdd);
        } 
    }

    /**
     * Removes a name from the register at the specified index.
     *
     * @param index the index of the name to be removed
     * @return the removed name
     */
    public Name removeName(int index) {
        return nameList.remove(index);
    }

    /**
     * Gets the name at the specified index in the register.
     *
     * @param index the index of the name
     * @return the name at the specified index
     */
    public Name getName(int index) {
        return nameList.get(index);
    }

    /**
     * Gets the size of the register.
     *
     * @return the size of the register
     */
    public int sizeOfRegister() {
        return nameList.size();
    }

    /**
     * Clears all names from the register.
     */
    public void clearRegister() {
        nameList.clear();
    }

    /**
     * Checks if the register is empty.
     *
     * @return true if the register is empty, false otherwise
     */
    public boolean isRegisterEmpty() {
        return nameList.isEmpty();
    }

    /**
     * Searches the register for names with the specified first name initial.
     *
     * @param firstCharacter the first character of the first name to search for
     * @return true if a name is found, false otherwise
     */
    public boolean searchRegisterByFirstNameInitial(char firstCharacter) {
        for (Name n : nameList) {
            if (n.getFirstName().charAt(0) == firstCharacter) {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts the occurrences of a specified first name in the register.
     *
     * @param targetFirstName the first name to count
     * @return the number of occurrences
     */
    public int countFirstNameOccurrences(String targetFirstName) {
        int count = 0;
        for (Name n : nameList) {
            if (n.getFirstName().equalsIgnoreCase(targetFirstName)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Sorts the names in the register based on the natural order of the Name class.
     * 
     * It is strongly recommended (though not required) that natural orderings be consistent with equals.
     * Therefore, the logic used in this method should be consistent with the logic used in the compareTo and equals methods.
     */
    public void sortRegister() {
        Collections.sort(nameList);
    }

    /**
     * Returns a string representation of the register.
     *
     * @return a string representation of the register
     */
    @Override
    public String toString() {
        return "Register:[Room capacity=" + registerCapacityRoom + ", Names=" + nameList + "]";
    }

    /**
     * Returns an iterator over the elements in this register in proper sequence.
     *
     * @return an iterator over the elements in this register
     */
    @Override
    public Iterator<Name> iterator() {
        return nameList.iterator();
    }
}
