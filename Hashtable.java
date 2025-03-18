import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Defines an abstract hash table class using an array of HashObject and all of 
 * the common hash table functionality should be in this abstract parent class 
 * and the subclasses would only have the functionality that is specific to the 
 * subclasses. For example, the abstract insert and search methods should be in 
 * the base Hashtable class.
 * 
 * @author Yakob Adera
 */
abstract class Hashtable {

    protected HashObject[] table; // table to store the hash objects
    protected int n; // number of unique HashObject objects stored in the hash table
    protected int tablesize; // total number of slots in the table
    protected int maxAllowedEntries; // maximum limit for hash table entries based on the load factor and tablesize
    protected double loadFactor; // load factor = n / tablesize
    protected int totalProbeCount; // sum of all the probes made during all insert and search operations 
    protected int totalNumInsertOperations; // total number of hash table insert() operations performed
    protected int totalNumDuplicatesDetected; // total number of times a duplicate HashObject is detected during insert()

    /**
     * Constructor for {@code Hashtable} that initializes the fields storing values for the 
     * max table size, load factor, maximum number of hash table slots that can be occupied, 
     * and the average number of probes.
     * 
     * @param tablesize length of the {@code HashObject} array
     * @param loadFactor ratio of the total number of stored elements in the table to 
     *                   the total number of slots available in the table
     */
    public Hashtable(int tablesize, double loadFactor) {
        this.tablesize = tablesize;
        this.loadFactor = loadFactor;
        this.maxAllowedEntries = (int) Math.ceil(tablesize * loadFactor);
        this.n = 0;
        this.totalProbeCount = 0;
        this.totalNumInsertOperations = 0;
        this.totalNumDuplicatesDetected = 0;

        // initialize array with tablesize and populate it with null pointers
        table = new HashObject[tablesize];
        for (int i = 0; i < tablesize; i++) table[i] = null;
    }

    /**
     * Inserts a new {@code HashObject} containing the {@code Object} field from {@code newHashObject} into the 
     * hash table, employing open addressing to resolve collisions. The key is hashed using {@code hashCode()}
     * to find a slot to probe. Upon a collision, the algorithm probes the hash table using a subclass-defined 
     * probing sequence until it finds an empty slot.
     * 
     * @param newHashObject {@code HashOject} to be inserted
     * @return the probe value if empty slot is found and insertion is successful; 
     *         -1 if the insertion doesn't occur due to a duplicate HashObject being detected;
     *         -2 if the insertion fails due to the hash table exceeding its maximum (load factor) storage capacity
     *              or if the whole table is probed without finding a location to insert the element
     */
    public abstract int insert(HashObject newHashObject);

    /** 
     * Searches the hash table by hashing the key {@code Object keyToFind} using a subclass-defined 
     * probing sequence function. This function generates multiple successive slots to probe until 
     * either the {@code HashObject} array element with the matching {@code Object} key is found, 
     * or the entire table is probed without finding a match.
     * 
     * @param keyToFind {@code Object} key value to search for
     * @return {@code HashObject} with the matching key in the table, or {@code null} if no match is found.
     */
    public abstract HashObject search(Object keyToFind);

    /**
     * <p>Ensures that a modulus operation always returns a positive integer.
     * 
     * <p>For example, 11 mod 7 ≡ 4. What about -11 mod 7? It is 3 because -11 = 7 (-2) + 3. 
     * In Java, -11 % 7 = -4 (because % is a remainder and not a modulus operator). We 
     * can add 7 to get the proper modulus. So we have -4 + 7 = 3.
     * 
     * @param dividend integer value in (dividend mod divisor)
     * @param divisor integer value in (dividend mod divisor)
     * @return positive modulus integer of the java operation (dividend % divisor)
     */
    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
    }

    /**
     * Get the total number of insert operations performed on the hash table
     * 
     * @return total number of insert operations
     */
    public int getTotalNumInsertOperations() {
        return totalNumInsertOperations;
    }

    /**
     * Get the total number of duplicates detected when inserting elements into the hash table
     * 
     * @return total number of duplicates (identical {@code HashObject} objects) detected
     */
    public int getTotalNumDuplicatesDetected() {
        return totalNumDuplicatesDetected;
    }

    /**
     * Determines the average number of probes by dividing the total number of probe made during insertion
     * by the total number of unique insertions made into the hash table
     * 
     * @return The ratio of the total number of probes to the number of unique inserts
     */
    public double getAvgNumProbes() {
        return totalProbeCount / (double) n;
    }

    /**
     * Gets the value for the maximum number of entries allowed into the hash table 
     * based on the product of the load factor and table size capacity
     * 
     * @return maximum number of allowed hash table entries
     */
    public int getMaxAllowedEntries() {
        return maxAllowedEntries;
    }

    /**
     * Dumps {@code Hashtable} contents into a file using PrintWriter class
     * @param fileName name of the dump file
     * @throws FileNotFoundException
     */
    public void dumpToFile(String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        // loop through the hash table, and print non-null entries
        // using toString() method in the HashObject class
        for (int i = 0; i < tablesize; i++) {
            if (table[i] != null) out.println(table[i].toString());
        }
        
        out.close();
    }

        
}