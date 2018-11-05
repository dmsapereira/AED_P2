package dataStructures;

public class OrderedDoubleList<K extends Comparable<K>, V> implements OrderedDictionary<K, V> {
    static final long serialVersionUID = 0L;
    protected DListNode<Entry<K, V>> head;
    protected DListNode<Entry<K, V>> tail;
    protected Comparator comparator;
    private int size;


    public OrderedDoubleList() {
        head = null;
        tail = null;
        this.size = 0;
        this.comparator = new InsertionOrder();
    }

    public OrderedDoubleList(Comparator<Entry<K, V>> comparator) {
        head = null;
        tail = null;
        this.size = 0;
        this.comparator = comparator;
    }

    @Override
    public Entry<K, V> minEntry() throws EmptyDictionaryException {
        return this.tail.getElement();
    }

    @Override
    public Entry<K, V> maxEntry() throws EmptyDictionaryException {
        return this.head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public V find(K key) {
        DListNode<Entry<K, V>> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.getElement().getKey().equals(key))
                return current.getElement().getValue();
            current = current.getNext();
        }
        return null;
    }

    private void insertNodeBefore(DListNode<Entry<K, V>> newNode, DListNode<Entry<K, V>> current) {
        if (current.getPrevious() != null) {
            current.getPrevious().setNext(newNode);
            newNode.setPrevious(current.getPrevious());
        }
        newNode.setNext(current);
        current.setPrevious(newNode);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V insert(K key, V value) {
        DListNode<Entry<K, V>> newNode = new DListNode(new EntryClass<>(key, value));
        if (this.find(key) == null) {
            DListNode<Entry<K, V>> current = this.head;
            for (int i = 0; i < this.size; i++) {
                if (comparator.compare(newNode.getElement(), current.getElement()) < 0) {
                    this.insertNodeBefore(newNode, current);
                    return null;
                }
                current=current.getNext();
            }
            return null;
        } else
            return this.find(key);
    }

    @Override
    public V remove(K key) {
        if(this.find(key)==null)
            return null;
        else{
            DListNode<Entry<K,V>> current=this.head;
            for(int i=0;i<this.size;i++){
                if(current.getElement().getKey().equals(key)){
                    current.getNext().setPrevious(current.getPrevious());
                    current.getPrevious().setNext(current.getNext());
                    return current.getElement().getValue();
                }
                current=current.getNext();
            }
            return null;
        }
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new DoublyLLIterator<>(this.head, this.tail);
    }
}
