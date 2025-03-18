/**
 * Subclass that extends Hashtable.java and only contains differing hash table 
 * functionality specific to double hashing. The primary hash function is 
 * h1(k) = k mod m and the secondary hash function is 
 * h2(k) = 1 + (k mod (m − 2)) mod m.
 * 
 * @author Yakob Adera
 */
public class DoubleHashing extends Hashtable{

    /**
     * Overloaded constructor for Double Hashing
     * 
     * @param tablesize size of the hash table array
     * @param loadFactor ratio of the maximum number of allowed table entries to the size of the hash table (tablesize)
     */
    public DoubleHashing(int tablesize, double loadFactor) {
        super(tablesize, loadFactor);
    }

    /**
     * Hash function {@code h1(objKey) = objKey.hashCode() mod m}
     * 
     * @param objKey {@code Object} key value
     * @return int: {@code h1(objKey) = objKey.hashCode() mod m}
     */
    private int hashFunc1(Object objKey) {
        return positiveMod (objKey.hashCode(), tablesize);
    }

    /**
     * Hash function {@code h2(objKey) = 1 + (objKey.hashCode() mod (m - 2))}
     * 
     * @param objKey {@code Object} key value
     * @return int: {@code h2(objKey) = 1 + (objKey.hashCode() mod (m - 2))}
     */
    private int hashFunc2(Object objKey) {
        return 1 + positiveMod (objKey.hashCode(), tablesize - 2);
    }

    /**
     * Calculates the probing sequence hash function value using the 
     * hash functions
     * {@code h1(objKey) = objKey.hashCode() mod m} and 
     * {@code h2(objKey) = 1 + (objKey.hashCode() mod (m - 2))}
     * where {@code m} is the tablesize.
     * 
     * @param objKey {@code Object} key value
     * @param i probe number
     * @return hash function int output --> {@code (h1(k) + i * h2(k)) mod m
     */
    private int probeSequence(Object objKey, int i) {
        return positiveMod(hashFunc1(objKey) + i * hashFunc2(objKey), tablesize);
    }

    @Override
    public int insert(HashObject newHashObject) {
        if ((n + 1) <= maxAllowedEntries) { // Check if adding another element exceeds the hash table's maximum capacity
            totalNumInsertOperations++; // counting the insert operation

            int probe;
            int i = 0;

            probe = hashFunc1(newHashObject.getKey()); // initial slot check calculates probe value with primary hash function
            while (i < tablesize) {
                newHashObject.incrementProbeCount(); // incrementing probe count of element being inserted
                totalProbeCount++;
                
                if (table[probe] == null) {
                    n++;
                    table[probe] = newHashObject;
                    table[probe].setStoredIndex(probe); // store the probe index to remember the location in the hash table
                    return probe;
                }
                else if (table[probe].equals(newHashObject.getKey())){
                    /* Compared the HashObject in the occupied table slot with the HashObject 
                    * being inserted and determined that they are duplicates. */
                    totalNumDuplicatesDetected++;
                    table[probe].incrementFrequencyCount(); // increment the stored HashObject's frequency count

                    // Exclude all probe attempts made to detect the duplicate
                    totalProbeCount -= newHashObject.getProbeCount();

                    return -1; // Exiting function because no inserts should occur if a duplicate object is detected
                }
                i++;
                probe = probeSequence(newHashObject.getKey(), i); // successive slot checks use probe sequence to probe the table
            }
        }

        return -2;
    }

    @Override
    public HashObject search(Object keyToFind) {
        int probe;
        int i = 0;

        probe = hashFunc1(keyToFind); // initial slot check calculates probe value with hashFunc1()
        while(table[probe] != null && i < tablesize) { // encountering null at probe location means HashObject key was never inserted
            if (table[probe].equals(keyToFind)) { // check if HashObject at probe location matches HashObject of the provided parameter key
                return table[probe]; // return HashObject if keys match
            }
            i++;
            probe = probeSequence(keyToFind, i); // successive slot checks use probe sequence to find location of key
        }

        return null;
    }

}
