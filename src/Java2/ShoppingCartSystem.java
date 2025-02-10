package Java2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSystem {
    public abstract static class Product {
        protected String name;
        protected double basePrice;
        public Product(String name, double basePrice) {
            this.name = name;
            this.basePrice = basePrice;
        }
        public abstract double calculatePrice();
        public abstract String getDetails();
    }
    public static class Electronics extends Product {
        private String brand;
        private int warrantyMonths;
        public Electronics(String name, double basePrice, String brand, int warrantyMonths) {
            super(name, basePrice);
            this.brand = brand;
            this.warrantyMonths = warrantyMonths;
        }
        @Override
        public double calculatePrice() {
            return basePrice * 1.10;
        }
        @Override
        public String getDetails() {
            return String.format("Electronics: %s (%s) - Warranty: %d months",
                    name, brand, warrantyMonths);
        }
    }
    public static class Clothing extends Product {
        private String size;
        private String material;
        public Clothing(String name, double basePrice, String size, String material) {
            super(name, basePrice);
            this.size = size;
            this.material = material;
        }
        @Override
        public double calculatePrice() {
            return basePrice * 1.05;
        }
        @Override
        public String getDetails() {
            return String.format("Clothing: %s (Size: %s, Material: %s)",
                    name, size, material);
        }
    }
    public static class Grocery extends Product {
        private String category;
        private boolean isPerishable;
        public Grocery(String name, double basePrice, String category, boolean isPerishable) {
            super(name, basePrice);
            this.category = category;
            this.isPerishable = isPerishable;
        }
        @Override
        public double calculatePrice() {
            return basePrice * (isPerishable ? 1.02 : 1.01);
        }
        @Override
        public String getDetails() {
            return String.format("Grocery: %s (Category: %s, Perishable: %b)",
                    name, category, isPerishable);
        }
    }
    public static class ShoppingCart {
        private List<Product> products = new ArrayList<>();
        private DecimalFormat df = new DecimalFormat("#.00");
        public void addProduct(Product product) {
            products.add(product);
        }
        public void displayCart() {
            double total = 0;
            System.out.println("Shopping Cart Contents:");
            for (Product product : products) {
                double price = product.calculatePrice();
                total += price;
                System.out.println(product.getDetails() +
                        " - Price: $" + df.format(price));
            }
            System.out.println("Total Cart Value: $" + df.format(total));
        }
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Electronics("Smartphone", 500, "Samsung", 12));
        cart.addProduct(new Clothing("T-Shirt", 20, "M", "Cotton"));
        cart.addProduct(new Grocery("Milk", 3, "Dairy", true));
        cart.displayCart();
    }
}
