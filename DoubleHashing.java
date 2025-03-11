/**
 * Subclass that extends Hashtable.java and only contains differing hash table 
 * functionality specific to double hashing. The primary hash function is 
 * h1(k) = k mod m and the secondary hash function is 
 * h2(k) = 1 + (k mod (m − 2)) mod m.
 * 
 * @author Yakob Adera
 */
public class DoubleHashing extends Hashtable{

    @Override
    public void insert() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
