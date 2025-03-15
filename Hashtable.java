/**
 * Defines an abstract hash table class using an array of HashObject and all of 
 * the common hash table functionality should be in this abstract parent class 
 * and the subclasses would only have the functionality that is specific to the 
 * subclasses. For example, the insert and search methods should be in the base 
 * Hashtable class.
 * 
 * @author Yakob Adera
 */
abstract class Hashtable {

    protected HashObject[] table; // table to store the hash objects
    protected int n; // number of hash table slots that can be occupied while maintaining load factor
    protected int tablesize; // total number of slots in the table
    protected double loadFactor; // load factor = n / tablesize
    protected double avgNumProbes; // average number of probes

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
        this.n = (int) Math.ceil(loadFactor * tablesize);
        this.avgNumProbes = 0;

        // initialize array with tablesize and populate it with null pointers
        table = new HashObject[tablesize];
        for (int i = 0; i < tablesize; i++) table[i] = null;
    }

    /**
     * Inserts a new {@code HashObject} containing the {@code Object} field {@code newKey} into the 
     * hash table, employing open addressing to resolve collisions. Upon a collision, the algorithm 
     * probes the hash table using a subclass-defined probing sequence until it finds an empty slot.
     * 
     * @param newKey {@code Object} key of new {@code HashObject} to be inserted
     * @return the probe value if empty slot is found and insertion is successful; -1 otherwise if insertion fails.
     */
    public abstract int insert(Object newKey);

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
     * @param dividend 
     * @param divisor
     * @return 
     */
    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
    }
        
}