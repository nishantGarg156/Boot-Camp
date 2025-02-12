package Java8AndMultiThreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
//remark: referenced from chatgpt

public class LogProcessor1 {
    public static void main(String[] args) {
        List<String> logFiles = List.of("log1.txt", "log2.txt", "log3.txt"); // Add file paths
        processLogsAsync(logFiles);
    }
    private static void processLogsAsync(List<String> logFiles) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(logFiles.size());

        List<CompletableFuture<FileProcessingResult>> futures = logFiles.stream()
                .map(file -> CompletableFuture.supplyAsync(() -> processLogFile(file), executor))
                .collect(Collectors.toList());
        List<FileProcessingResult> results = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        executor.shutdown();


        long totalTime = System.currentTimeMillis() - startTime;
        generateSummary(results, totalTime);
    }

    private static FileProcessingResult processLogFile(String fileName) {
        long startTime = System.currentTimeMillis();
        String outputFileName = "processed_" + fileName;

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            List<String> filteredLines = lines.stream()
                    .filter(line -> line.contains("ERROR"))  // Change the condition as needed
                    .collect(Collectors.toList());

            Files.write(Paths.get(outputFileName), filteredLines);

            long timeTaken = System.currentTimeMillis() - startTime;
            return new FileProcessingResult(fileName, filteredLines.size(), timeTaken);
        } catch (IOException e) {
            System.err.println("Error processing file: " + fileName);
            return new FileProcessingResult(fileName, 0, -1); // Indicate failure
        }
    }

    private static void generateSummary(List<FileProcessingResult> results, long totalTime) {
        System.out.println("\n===== SUMMARY REPORT =====");
        for (FileProcessingResult result : results) {
            System.out.println("File: " + result.fileName +
                    " | Processed Lines: " + result.linesProcessed +
                    " | Time Taken: " + result.timeTaken + "ms");
        }
        System.out.println("Total Processing Time: " + totalTime + "ms");
    }

}
class FileProcessingResult {
    String fileName;
    int linesProcessed;
    long timeTaken;

    public FileProcessingResult(String fileName, int linesProcessed, long timeTaken) {
        this.fileName = fileName;
        this.linesProcessed = linesProcessed;
        this.timeTaken = timeTaken;
    }
}

