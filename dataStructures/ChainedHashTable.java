package dataStructures;

/**
 * Chained Hash table implementation
 *
 * @param <K> Generic Key, must extend comparable
 * @param <V> Generic Value
 * @author AED  Team
 * @version 1.0
 */

public class ChainedHashTable<K extends Comparable<K>, V>
        extends HashTable<K, V> {
    /**
     * Serial Version UID of the Class.
     */
    static final long serialVersionUID = 0L;

    /**
     * The array of dictionaries.
     */
    protected Dictionary<K, V>[] table;


    /**
     * Constructor of an empty chained hash table,
     * with the specified initial capacity.
     * Each position of the array is initialized to a new ordered list
     * maxSize is initialized to the capacity.
     *
     * @param capacity defines the table capacity.
     */
    @SuppressWarnings("unchecked")
    public ChainedHashTable(int capacity) {
        int arraySize = HashTable.nextPrime((int) (1.1 * capacity));
        // Compiler gives a warning.
        table = (Dictionary<K, V>[]) new Dictionary[arraySize];
        for (int i = 0; i < arraySize; i++)
            table[i] = new OrderedDoubleList<K, V>();
        maxSize = capacity;
        currentSize = 0;
    }


    public ChainedHashTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Returns the hash value of the specified key.
     *
     * @param key to be encoded
     * @return hash value of the specified key
     */
    protected int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public V find(K key) {
        return table[this.hash(key)].find(key);
    }

    @Override
    public V insert(K key, V value) {
        if (this.isFull())
            this.rehash();
        return table[this.hash(key)].insert(key, value);
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        Dictionary<K, V> newTable[];
        int arraySize = HashTable.nextPrime((int) (1.1 * this.size() * 2));
        newTable = (Dictionary<K, V>[]) new Dictionary[arraySize];
        System.arraycopy(this.table, 0, newTable, 0, this.size());
        for (int i = this.size(); i < arraySize; i++) {
            newTable[i] = new OrderedDoubleList<>();
        }
        this.table = newTable;
        this.maxSize *= 2;
    }

    @Override
    public V remove(K key) {
        return table[this.hash(key)].remove(key);
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        Entry<K, V> current;
        Iterator<Entry<K, V>> itera;
        OrderedDictionary<K, V> list = new OrderedDoubleList<>();
        for (Dictionary<K, V> dictionary : table) {
            itera = dictionary.iterator();
            while (itera.hasNext()) {
                current = itera.next();
                list.insert(current.getKey(), current.getValue());
            }
        }
        return list.iterator();
    }
}
































