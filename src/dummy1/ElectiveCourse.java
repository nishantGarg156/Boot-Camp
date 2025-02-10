package dummy1;
import java.util.Scanner;
public class ElectiveCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your academic year (3 or 4): ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter your branch (CSE/IT/ECE/Other): ");
        String branch = scanner.nextLine().trim().toUpperCase();
        switch (year) {
            case 3:
                System.out.println("Elective courses: Advanced English, Algebra");
                break;
            case 4:
                switch (branch) {
                    case "CSE":
                    case "IT":
                        System.out.println("Elective courses: Machine Learning, Big Data");
                        break;
                    case "ECE":
                        System.out.println("Elective courses: Antenna Engineering");
                        break;
                    default:
                        System.out.println("Elective courses: Optimization");
                        break;}
                break;
                default:
                System.out.println("Not Eligible for Elective courses");
                break;
        }
         }
}
