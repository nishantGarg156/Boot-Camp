package Java2;

import java.util.Arrays;
import java.util.Collections;

public class TestScoreAnalyzer {
    private double[] scores;
    public TestScoreAnalyzer(double[] inputScores) {
        this.scores = Arrays.copyOf(inputScores, inputScores.length);
    }
    public double findHighestScore() {
        return Arrays.stream(scores).max().orElse(Double.NaN);
    }
    public double findLowestScore() {
        return Arrays.stream(scores).min().orElse(Double.NaN);
    }
    public double calculateAverageScore() {
        return Arrays.stream(scores).average().orElse(Double.NaN);
    }
    public double[] getSortedScoresAscending() {
        double[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);
        return sortedScores;
    }
    public double[] getSortedScoresDescending() {
        Double[] boxedScores = Arrays.stream(scores).boxed().toArray(Double[]::new);
        Arrays.sort(boxedScores, Collections.reverseOrder());
        return Arrays.stream(boxedScores).mapToDouble(Double::doubleValue).toArray();
    }
    public void displayAnalysis() {
        System.out.println("Score Analysis:");
        System.out.printf("Highest Score: %.2f\n", findHighestScore());
        System.out.printf("Lowest Score: %.2f\n", findLowestScore());
        System.out.printf("Average Score: %.2f\n", calculateAverageScore());
        System.out.print("\nScores (Ascending): ");
        Arrays.stream(getSortedScoresAscending()).forEach(score -> System.out.printf("%.2f ", score));
        System.out.print("\nScores (Descending): ");
        Arrays.stream(getSortedScoresDescending()).forEach(score -> System.out.printf("%.2f ", score));
    }
    public static void main(String[] args) {
        double[] testScores = {85.5, 92.3, 78.7, 90.1, 88.6, 76.4};
        TestScoreAnalyzer analyzer = new TestScoreAnalyzer(testScores);
        analyzer.displayAnalysis();
    }
}
