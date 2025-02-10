package Collection2;

import java.util.HashMap;
import java.util.Map;

public class ProductDetails {
    public static void main(String[] args) {
        Map<String, Double> productMap = new HashMap<>();
        productMap.put("Milk", 43.00);
        productMap.put("Rice", 79.00);
        productMap.put("Laptop", 1490.00);
        productMap.put("smartphones", 199.00);


        for (Map.Entry<String, Double> entry : productMap.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }
}
