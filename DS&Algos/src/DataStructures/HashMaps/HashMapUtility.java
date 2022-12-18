package DataStructures.HashMaps;

import java.util.HashMap;

public class HashMapUtility<K, V> {
    public static void AddKeyToHashMap(HashMap<Character, Integer> hashMap, Character key) {
        int keyFrequencyCount = 0;
        if (hashMap.containsKey(key)) {
            keyFrequencyCount = hashMap.get(key);
            hashMap.put(key, keyFrequencyCount + 1);
        } else {
            hashMap.put(key, 1);
        }
    }

    public static void AddKeyToHashMap(HashMap<String, Integer> hashMap, String key) {
        int keyFrequencyCount = 0;
        if (hashMap.containsKey(key)) {
            keyFrequencyCount = hashMap.get(key);
            hashMap.put(key, keyFrequencyCount + 1);
        } else {
            hashMap.put(key, 1);
        }
    }
}
