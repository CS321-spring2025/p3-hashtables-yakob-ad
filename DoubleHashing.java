/**
 * Subclass that extends Hashtable.java and only contains differing hash table 
 * functionality specific to double hashing. The primary hash function is 
 * h1(k) = k mod m and the secondary hash function is 
 * h2(k) = 1 + (k mod (m − 2)) mod m.
 * 
 * @author Yakob Adera
 */
public class DoubleHashing extends Hashtable{

    private int hashFunc1;
    private int hashFunc2;

    public DoubleHashing(int tablesize, double loadFactor) {
        super(tablesize, loadFactor);
    }

    private int hashFunc1(Object objKey) {
        return positiveMod (objKey.hashCode(), tablesize);
    }

    private int hashFunc2(Object objKey) {
        return 1 + positiveMod (objKey.hashCode(), tablesize - 2);
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
