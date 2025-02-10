package Collection2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteration {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("First", 50);
        map.put("Second", 30);
        map.put("Third", 20);
        map.put("Fourth", 10);
        System.out.println("Using Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            if (entry.getValue() < 20) {
                iterator.remove();
            }
        }
        System.out.println("\nUsing entrySet() in for-each:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("\nUsing forEach() method:");
        map.forEach((key, value) ->
                System.out.println("Key: " + key + ", Value: " + value)
        );
    }
}
