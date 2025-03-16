/**
 * Subclass that extends Hashtable.java and only 
 * contains differing hash table functionality specific to linear probing. The primary 
 * hash function is h1(k) = k mod m.
 * 
 * @author Yakob Adera
 */
public class LinearProbing extends Hashtable{

    public LinearProbing(int tablesize, double loadFactor) {
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
     * Calculates the probing sequence hash function value using the 
     * hash function
     * {@code h1(objKey) = objKey.hashCode() mod m}
     * where {@code m} is the tablesize.
     * 
     * @param objKey {@code Object} key value
     * @param i probe number
     * @return hash function int output --> (h1(objKey) + i) mod m
     */
    private int probeSequence(Object objKey, int i) {
        return positiveMod(hashFunc1(objKey) + i, tablesize);
    }

    @Override
    public int insert(HashObject newHashObject) {
        totalNumOperations++; // counting the insert operation

        if ((n + 1) <= maxAllowedEntries) { // Check if adding another element exceeds the hash table's maximum capacity
            int probe;
            int i = 0;

            probe = newHashObject.getKey().hashCode(); // initial slot check calculates probe value with hashCode()
            while (i < tablesize) {
                table[probe].incrementProbeCount();
                totalProbeCount++;

                if (table[probe] == null) {
                    n++;
                    table[probe] = newHashObject;
                    table[probe].setStoredIndex(probe); // store the probe index to remember the location in the hash table
                    return probe;
                }
                else {
                    /* Comparing the HashObject in the occupied table slot with the HashObject 
                     * being inserted to determine if they are duplicates. */
                    if (table[probe].equals(newHashObject)) {
                        table[probe].incrementFrequencyCount(); // increment the stored HashObject's frequency count
                        break; // Breaking out of loop because no inserts should occur if a duplicate object is detected
                    }
                    i++;
                }
                probe = probeSequence(newHashObject.getKey(), i); // successive slot checks use probe sequence to probe the table
            }
        }

        return -1;
    }

    @Override
    public HashObject search(HashObject hashObjToFind) {
        totalNumOperations++; // counting the search operation

        int probe;
        int i = 0;

        probe = hashObjToFind.getKey().hashCode(); // initial slot check calculates probe value with hashCode()
        do {
            table[probe].incrementProbeCount();
            totalProbeCount++;

            if (table[probe].equals(hashObjToFind)) { // check if HashObject at probe location matches HashObject of the provided parameter key
                return table[probe]; // return HashObject if keys match
            }
            i++;
            probe = probeSequence(hashObjToFind.getKey(), i); // successive slot checks use probe sequence to find location of key
        } while(table[probe] != null && i < tablesize); // encountering null at probe location means HashObject key was never inserted

        return null;
    }
    
}
