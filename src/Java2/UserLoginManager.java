package Java2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class UserLoginManager {
    private static final String CSV_FILE_PATH = "user_logins.csv";
    private static final String CSV_HEADER = "username,password,email";
    public void createInitialFile() throws IOException {
        Path path = Paths.get(CSV_FILE_PATH);
        if (!Files.exists(path)) { //this method throws an IOException
            Files.writeString(path, CSV_HEADER + "\n");
        }
    }
    public void addUser(String username, String password, String email)
            throws InvalidUserException, IOException {
        if (!isUsernameUnique(username)) {
            throw new InvalidUserException("Username already exists");
        }
        validateUser(username, password, email);
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(CSV_FILE_PATH, true))) {
            writer.write(String.format("%s,%s,%s\n",
                    username, password, email));
        }
    }
    private boolean isUsernameUnique(String username) throws IOException {        return !Files.lines(Paths.get(CSV_FILE_PATH))
                .skip(1)
                .map(line -> line.split(",")[0])
                .anyMatch(existingUsername -> existingUsername.equals(username));
    }
    private void validateUser(String username, String password, String email)
            throws InvalidUserException {
        if (username == null || username.length() < 3) {
            throw new InvalidUserException("Invalid username");
        }
        if (password == null || password.length() < 6) {
            throw new InvalidUserException("Weak password");
        }
        if (!email.contains("@")) {
            throw new InvalidUserException("Invalid email format");
        }
    }
    public List<String[]> getAllUsers() throws IOException {
        return Files.lines(Paths.get(CSV_FILE_PATH))
                .skip(1)
                .map(line -> line.split(","))
                .collect(Collectors.toList());
    }
    public void updateUser(String oldUsername, String newUsername,
                           String newPassword, String newEmail) throws IOException, InvalidUserException {
        List<String[]> users = getAllUsers();
        boolean userFound = false;
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(CSV_FILE_PATH))) {
            writer.write(CSV_HEADER + "\n");
            for (String[] user : users) {
                if (user[0].equals(oldUsername)) {
                    validateUser(newUsername, newPassword, newEmail);
                    writer.write(String.format("%s,%s,%s\n",
                            newUsername, newPassword, newEmail));
                    userFound = true;
                } else {
                    writer.write(String.join(",", user) + "\n");
                }
            }
        }
        if (!userFound) {
            throw new InvalidUserException("User not found");
        }
    }
    public static class InvalidUserException extends Exception {
        public InvalidUserException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {
        UserLoginManager manager = new UserLoginManager();
        try {
            manager.createInitialFile();
            manager.addUser("Nishant", "123456", "nishantgarg@gmail.com");
            manager.updateUser("Nishant", "NishantGarg", "new123456", "nishant.garg@tothenew.com");

            System.out.println("Users:");
            manager.getAllUsers().forEach(
                    user -> System.out.println(Arrays.toString(user))
            );
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
