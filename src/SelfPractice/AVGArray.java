package SelfPractice;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class AVGArray {
    public static void main(String[] args) {
        int[] a = {2,4,6,7,8,2};
        System.out.println(Arrays.stream(a).anyMatch(num -> num == 2));

    }
}
