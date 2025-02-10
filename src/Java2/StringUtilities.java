package Java2;
import java.util.regex.Pattern;
public class StringUtilities {
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
    public static int safeParseInt(String input, int defaultValue) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    public static double safeParseDouble(String input, double defaultValue) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    public static String capitalizeFirstLetter(String input) {
        if (isNullOrEmpty(input)) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
 class UtilityTestRunner {
    public static void main(String[] args) {
        System.out.println("Email Validation Tests:");
        System.out.println("Valid email test: " +
                StringUtilities.isValidEmail("test.user@example.com"));
        System.out.println("Invalid email test: " +
                StringUtilities.isValidEmail("invalid-email"));
        System.out.println("\nNull/Empty String Tests:");
        System.out.println("Null string test: " +
                StringUtilities.isNullOrEmpty(null));
        System.out.println("Empty string test: " +
                StringUtilities.isNullOrEmpty(""));
        System.out.println("Valid string test: " +
                StringUtilities.isNullOrEmpty("  "));
        System.out.println("\nSafe Parsing Tests:");
        System.out.println("Valid int parsing: " +
                StringUtilities.safeParseInt("123", 0));
        System.out.println("Invalid int parsing: " +
                StringUtilities.safeParseInt("abc", 0));
        System.out.println("\nCapitalization Tests:");
        System.out.println("Capitalize test: " +
                StringUtilities.capitalizeFirstLetter("hello"));
    }
}
