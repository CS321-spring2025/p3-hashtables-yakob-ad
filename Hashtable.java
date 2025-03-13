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
    protected int tablesize; // number of slots in the table
    protected double loadFactor; // load factor = n / tablesize
    protected double avgNumProbes; // average number of probes

    public Hashtable(int tablesize, double loadFactor) {
        this.tablesize = tablesize;
        this.loadFactor = loadFactor;
        this.n = (int) Math.ceil(loadFactor * tablesize);

        // initialize array with tablesize and populate it with null pointers
        table = new HashObject[tablesize];
        for (int i = 0; i < tablesize; i++) table[i] = null;
    }

    public abstract int insert(Object newKey);

    public abstract int search();

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