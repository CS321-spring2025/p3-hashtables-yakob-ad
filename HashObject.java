/**
 * Contains a generic key object (declared as {@code Object} key), 
 * frequency count (to count duplicates), and probe count. Overrides both 
 * the {@code equals} and the {@code toString} methods and has a 
 * {@code getKey} method that returns an {@code Object} type. Make sure that 
 * the {@code equals} method actually compares the key values using the 
 * {@code equals} method on the keys.
 * 
 * @author Yakob Adera
 */
public class HashObject {

    private Object key; // key field
    private int frequencyCount; // counts the frequency at which the same HashObject is detected during an insert operation
    private int probeCount; // counts the number of times the HashObject is probed/located in a hash
    private int storedIndex; // tracks the specific index where the object is stored in a hash table

    /**
     * Overloaded constructor for {@code HashObject}
     * 
     * @param key reference to an object of any class
     */
    public HashObject(Object key) {
        this.key = key;
        this.frequencyCount = 1;
        this.probeCount = 0;
        this.storedIndex = -1;
    }
    
    /**
     * Gets the Object type
     * 
     * @return HashObject's {@code key}
     */
    public Object getKey() {
        return key;
    }

    /**
     * Sets the storedIndex variable that keeps track of HashObject's probe location
     * 
     * @param storedIndex hash table index where HashObject is stored
     */
    public void setStoredIndex(int storedIndex) {
        this.storedIndex = storedIndex;
    }

    /**
     * Gets the storedIndex variable that keeps track of HashObject's probe location
     * 
     * @return hash table index where HashObject is stored; -1 by default if storedIndex was never set/changed
     */
    public int getStoredIndex() {
        return storedIndex;

    }

    /**
     * Increments HashObject's frequency count
     */
    public void incrementFrequencyCount() {
        frequencyCount++;
    }

    /**
     * Gets the frequency count
     * 
     * @return frequency count
     */
    public int getFrequencyCount() {
        return frequencyCount;
    }

    /**
     * Increments HashObject's probe count
     */
    public void incrementProbeCount() {
        probeCount++;
    }
    
    /**
     * Gets the probe count
     * 
     * @return probe count
     */
    public int getProbeCount() {
        return probeCount;
    }

    @Override
    public boolean equals(Object hashObject) {
        // do they both have the same references?
        if (this == hashObject) {
            return true;
        }

        // is the parameter a null pointer reference? Does it have the same object type as this class instance
        if (hashObject == null || this.getClass() != hashObject.getClass()) {
            return false;
        }

        HashObject otherHashObj = (HashObject) hashObject;

        return this.key.equals(otherHashObj.getKey());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("table[").append(storedIndex).append("]: ").append(key).append(" ").append(frequencyCount).append(" ").append(probeCount);
        return sb.toString();
    }
}
