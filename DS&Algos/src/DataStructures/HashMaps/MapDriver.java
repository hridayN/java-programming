package DataStructures.HashMaps;

public class MapDriver {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<String, Integer>();
        /*System.out.println("keysCount: " + map.keysCount);
        map.Insert("a1", 1);
        System.out.println("keysCount: " + map.keysCount);
        MapNode<String, Integer> mapNode = map.SearchKey("a1");
        System.out.println("mapNode value: " + mapNode.value);

        map.Insert("a2", 2);
        System.out.println("keysCount: " + map.keysCount);

        mapNode = map.SearchKey("a2");
        System.out.println("mapNode value: " + mapNode.value);

        map.Insert("x1", 3);
        System.out.println("keysCount: " + map.keysCount);
        System.out.println(String.format("%d deleted successfully", map.DeleteKey("a2")));
        System.out.println("keysCount: " + map.keysCount);
        // mapNode = map.SearchKey("a2");
        // System.out.println("keysCount: " + map.keysCount);
        // System.out.println("mapNode value: " + mapNode.value);*/

        // Rehash
        System.out.println(String.format("Load factor: %f", map.LoadFactor()));
        for (int i = 0; i < 20; i++) {
            map.Insert("abc" + i, i + 1);
            System.out.println(String.format("Load factor: %.2f", map.LoadFactor()));
            System.out.println(String.format("No of keys: %d", map.Size()));
        }
    }
}
