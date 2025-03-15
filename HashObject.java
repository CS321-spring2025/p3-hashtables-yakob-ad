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

    private Object key;
    private int frequencyCount;
    private int probeCount;
    private StringBuilder outputString;

    /**
     * Overloaded constructor for {@code HashObject}
     * 
     * @param key reference to an object of any class
     */
    public HashObject(Object key) {
        this.key = key;
        this.frequencyCount = 1;
        this.probeCount = 0;
        this.outputString = new StringBuilder();
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
    public boolean equals(Object object) {
        // do they both have the same references?
        if (this == object) {
            return true;
        }

        // is the parameter a null pointer reference or doesn't have the same object type as the key
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        return this.key.equals(object);
    }

    @Override
    public String toString() {
        return new String();
    }
}
