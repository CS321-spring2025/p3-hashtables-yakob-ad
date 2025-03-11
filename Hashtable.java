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

    protected HashObject[] table;

    public abstract void insert();

    public abstract void search();
}