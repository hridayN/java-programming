package DataStructures.HashMaps;

// K: Key, V: Value
public class MapNode<K, V> {
    /*Key: Unique key*/
    K key;

    /*Value: value of the Key*/
    V value;

    /*Next: Stores the info of the next key*/
    MapNode<K, V> next;

    /*Constructor*/
    public MapNode(K k, V v) {
        this.key = k;
        this.value = v;
    }
}
