/**
 * Subclass that extends Hashtable.java and only 
 * contains differing hash table functionality specific to linear probing. The primary 
 * hash function is h1(k) = k mod m.
 * 
 * @author Yakob Adera
 */
public class LinearProbing extends Hashtable{

    private int hashFunc1;

    public LinearProbing(int tablesize, double loadFactor) {
        super(tablesize, loadFactor);
    }

    /**
     * 
     * @param objKey
     * @return
     */
    private int hashFunc1(Object objKey) {
        return positiveMod (objKey.hashCode(), tablesize);
    }

    @Override
    public void insert(Object newKey) {
    }

    @Override
    public void search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
