package dummy1;

import java.util.Scanner;

public class ProductDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter delivery area (Local/Remote): ");
        String area = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter order amount: $");
        double orderAmount = scanner.nextDouble();
        if (area.equals("local")) {
            if (orderAmount >= 100) {
                System.out.println("Order Category: Fast Track");
            } else {
                System.out.println("Order Category: Standard Delivery");
            }
        }
        else if (area.equals("remote")) {
            if (orderAmount >= 200) {
                System.out.println("Order Category: Priority Delivery");
            } else {
                System.out.println("Order Category: Normal Delivery");
            }
        } else {
            System.out.println("Area not supported.");
        }
    }
}
