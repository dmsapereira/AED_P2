package dataStructures;

public class EntryClass<K extends Comparable<K>,V> implements Entry<K,V>,Comparable<Entry> {
    private K key;
    private V value;

    public EntryClass(K key, V value){
        this.key=key;
        this.value=value;
    }
    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Entry element) {
        return element.getKey().compareTo(this.key);
    }
}
