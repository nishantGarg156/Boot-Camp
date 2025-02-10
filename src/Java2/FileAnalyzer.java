package Java2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FileAnalyzer {
    private String fileContent;
    private Map<String, Integer> wordFrequency;
    public FileAnalyzer(String filePath) throws IOException {
        readFile(filePath);
        calculateWordFrequency();
    }
    private void readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        fileContent = content.toString().trim();
    }
    private void calculateWordFrequency() {
        wordFrequency = new HashMap<>();
        String[] words = fileContent.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
    }
    public void printWordFrequency() {
        System.out.println("Word Frequency:");
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    public String getUppercaseContent() {
        return fileContent.toUpperCase();
    }
    public String getReversedContent() {
        return new StringBuilder(fileContent).reverse().toString();
    }
    public String replaceWords(Map<String, String> replacements) {
        String modifiedContent = fileContent;
        for (Map.Entry<String, String> replacement : replacements.entrySet()) {
            modifiedContent = modifiedContent.replaceAll(
                    "\\b" + replacement.getKey() + "\\b",
                    replacement.getValue()
            );
        }
        return modifiedContent;
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter file path");
            String filePath = scanner.nextLine();
            FileAnalyzer analyzer = new FileAnalyzer(filePath);
            analyzer.printWordFrequency();
            System.out.println("\nUppercase Content:");
            System.out.println(analyzer.getUppercaseContent());
            System.out.println("\nReversed Content:");
            System.out.println(analyzer.getReversedContent());
            System.out.print("\nEnter number of word replacements: ");
            int replacementCount = scanner.nextInt();
            scanner.nextLine();
            Map<String, String> replacements = new HashMap<>();
            for (int i = 0; i < replacementCount; i++) {
                System.out.print("Enter word to replace: ");
                String oldWord = scanner.nextLine();
                System.out.print("Enter replacement word: ");
                String newWord = scanner.nextLine();
                replacements.put(oldWord, newWord);
            }
            System.out.println("\nReplaced Content:");
            System.out.println(analyzer.replaceWords(replacements));
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

