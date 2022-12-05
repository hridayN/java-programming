package DataStructures.HashMaps;

// K: Key, V: Value
public class MapNode<K, V> {
    K key;
    V value;
    MapNode<K, V> next;

    public MapNode(K k, V v) {
        this.key = k;
        this.value = v;
    }
}
