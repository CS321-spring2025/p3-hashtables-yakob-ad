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
    public int insert(Object newKey) {
        int probe;
        int i = 0;
        HashObject newHashObject = new HashObject(newKey);
        while (i < tablesize) {
            probe = probeSequence(newKey, i);
            if (table[probe] == null) {
                table[probe] = newHashObject;
                return probe;
            }
            else {
                i++;
            }
        }

        return -1;
    }

    @Override
    public int search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
