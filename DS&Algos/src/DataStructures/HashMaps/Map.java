package DataStructures.HashMaps;

import java.util.ArrayList;

public class Map<K, V> {
    // Collection of buckets(Each is a linked list, containing Key-Value pair and the information of next Key(if any)
    ArrayList<MapNode<K, V>> bucketsList;

    /*keysCount: keeps count of no. of keys*/
    private int keysCount;

    /*numberOfBuckets: Number of items(MapNode) in bucketsList*/
    private int numberOfBuckets;

    /*Constructor*/
    public Map() {
        this.bucketsList = new ArrayList<>();
        this.numberOfBuckets = 20;  // by default, there will be 20 buckets
        for (int i = 0; i < numberOfBuckets; i++) {
            this.bucketsList.add(null);
        }
    }

    public int Size() {
        return this.keysCount;
    }

    /*Get index of the Key */
    private int getBucketIndex(K key) {
        // Object's hashcode
        int hashCode = key.hashCode();

        // Compression: (hashCode modulo numberOfBuckets)
        int index = hashCode % numberOfBuckets;
        return index;
    }

    /*1. Get bucket index of the key
    * 2. Add key(if not exists)*/
    public void Insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);

        MapNode<K, V> current = bucketsList.get(bucketIndex);

        // Check if key exists at the given index, update its value if exists
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Reaching here means, key doesn't exist. Now we'll insert a new node at start in the list
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = current;
        bucketsList.set(bucketIndex, newNode);
        keysCount++;

        // Check if ReHashing is needed
        if (LoadFactor() > 0.7) {
            ReHash();
        }
    }

    /*This function searches for the Key in the HashMap
    * 1. Check if Key exists, by bucketIndex*/
    public MapNode SearchKey(K key) {
        MapNode<K, V> mapNode = null;
        MapNode<K, V> current = GetNodeAtBucketIndex(key);
        while (current != null) {
            if (current.key.equals(key)) {
                mapNode = current;
                break;
            }
            current = current.next;
        }
        return mapNode;
    }

    public V DeleteKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> current = bucketsList.get(bucketIndex), previous = null;
        V value = null;
        while (current != null) {
            if (current.key.equals(key)) {
                // Check if key to be deleted is head itself
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    bucketsList.set(bucketIndex, current.next);
                }

                value = current.value;
                this.keysCount--;
                return value;
            }
            previous = current;
            current = current.next;
        }
        return value;
    }

    public V GetValue(K key) {
        MapNode<K, V> current = GetNodeAtBucketIndex(key);
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public double LoadFactor() {
        return ((1.0 * keysCount) / numberOfBuckets);
    }

    private void ReHash() {
        // Hold the current bucketList into a temporary list
        ArrayList<MapNode<K, V>> temp = bucketsList;

        // Double the no. of buckets
        this.numberOfBuckets = 2 * numberOfBuckets;

        // Make current bucketsList point to null
        for (int i = 0; i < numberOfBuckets; i++) {
            bucketsList.add(null);
        }

        // Set keys count to 0, as all keys are null in bucketsList
        this.keysCount = 0;

        // For each existing node, add it's key-value to newly resized list
        for (MapNode<K, V> mapNode : temp) {
            if (mapNode != null) {
                K key = mapNode.key;
                V value = mapNode.value;
                Insert(key, value);
                this.keysCount++;
            }
        }
    }

    /*REGION START: Private utility methods*/
    private MapNode<K, V> GetNodeAtBucketIndex(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> mapNode = bucketsList.get(bucketIndex);
        return mapNode;
    }
    /*REGION ENDS*/
}

