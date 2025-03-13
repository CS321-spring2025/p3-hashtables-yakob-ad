/**
 * Subclass that extends Hashtable.java and only contains differing hash table 
 * functionality specific to double hashing. The primary hash function is 
 * h1(k) = k mod m and the secondary hash function is 
 * h2(k) = 1 + (k mod (m − 2)) mod m.
 * 
 * @author Yakob Adera
 */
public class DoubleHashing extends Hashtable{

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
