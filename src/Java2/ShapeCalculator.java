package Java2;

import java.text.DecimalFormat;

public class ShapeCalculator {
    public abstract static class Shape {
        protected DecimalFormat df = new DecimalFormat("#.##");
        public abstract double area();
        public abstract double perimeter();
        public abstract void validate();
    }
    public static class Circle extends Shape {
        private double radius;
        public Circle(double radius) {
            this.radius = radius;
            validate();
        }
        @Override
        public void validate() {
            if (radius <= 0) {
                throw new IllegalArgumentException("Radius must be positive");
            }
        }
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
        public String toString() {
            return String.format("Circle: Radius = %.2f, Area = %.2f, Perimeter = %.2f",
                    radius, area(), perimeter());
        }
    }
    public static class Rectangle extends Shape {
        private double length;
        private double width;
        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
            validate();
        }
        @Override
        public void validate() {
            if (length <= 0 || width <= 0) {
                throw new IllegalArgumentException("Length and width must be positive");
            }
        }
        @Override
        public double area() {
            return length * width;
        }
        @Override
        public double perimeter() {
            return 2 * (length + width);
        }

        public String toString() {
            return String.format("Rectangle: Length = %.2f, Width = %.2f, Area = %.2f, Perimeter = %.2f",
                    length, width, area(), perimeter());
        }
    }
    public static class Triangle extends Shape {
        private double side1;
        private double side2;
        private double side3;
        public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            validate();
        }
        @Override
        public void validate() {
            if (side1 <= 0 || side2 <= 0 || side3 <= 0 ||
                    side1 + side2 <= side3 ||
                    side1 + side3 <= side2 ||
                    side2 + side3 <= side1) {
                throw new IllegalArgumentException("Invalid triangle sides");
            }
        }
        @Override
        public double area() {
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }
        @Override
        public double perimeter() {
            return side1 + side2 + side3;
        }

        public String toString() {
            return String.format("Triangle: Sides = %.2f, %.2f, %.2f, Area = %.2f, Perimeter = %.2f",
                    side1, side2, side3, area(), perimeter());
        }
    }
    public static void main(String[] args) {
        try {
            Shape[] shapes = {
                    new Circle(5),
                    new Rectangle(4, 6),
                    new Triangle(3, 4, 5)
            };
            for (Shape shape : shapes) {
                System.out.println(shape);
            }
            new Circle(-1);  // Should throw exception
        } catch (IllegalArgumentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
}
