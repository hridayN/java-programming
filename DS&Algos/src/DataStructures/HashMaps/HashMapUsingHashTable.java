package DataStructures.HashMaps;

import java.util.HashMap;
import java.util.Set;

public class HashMapUsingHashTable {
    static HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

    public static void main(String[] args) {
        // Size is O(1)
        int size = stringIntegerHashMap.size();
        System.out.println(String.format("Hash map current size is: %d", size));

        // Insertion: O(1)
        stringIntegerHashMap.put("K1", 1);
        size = stringIntegerHashMap.size();
        System.out.println(String.format("Hash map current size is: %d", size));

        if (stringIntegerHashMap.containsKey("K1")) {
            // Get is O(1)
            int value = stringIntegerHashMap.get("K1");
            System.out.println(String.format("K1 has value: %d", value));
        }

        stringIntegerHashMap.put("K2", 2);
        size = stringIntegerHashMap.size();
        System.out.println(String.format("Hash map current size is: %d", size));

        // Remove a key: O(1)
        stringIntegerHashMap.remove("K1");
        size = stringIntegerHashMap.size();
        System.out.println(String.format("Hash map current size is: %d", size));

        stringIntegerHashMap.put("K3", 3);

        // Get all keys: O(n)
        Set<String> keys = stringIntegerHashMap.keySet();
        for(String key: keys) {
            System.out.print(key);
        }
    }
}
