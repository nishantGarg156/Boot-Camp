package Java8AndMultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Filter{
    public boolean filter(String s);
}
class FilterTest{
     String Name ;
    String status;
    int Executiontime;
    public FilterTest(String Name, String status, int Executiontime){
        this.Name = Name;
        this.status = status;
        this.Executiontime = Executiontime;

    }
    public String toString(String name , String status, int Executiontime ){
        return "TestCase{name='" + name + "', status='" + status + "', executionTime=" + Executiontime + " ms}";
    }



}

public class FilterTestCAse {

    public static void main(String[] args) {
        List<FilterTest> list =new ArrayList<>();
        list.add(new FilterTest("test1", "passes", 120));
        list.add(new FilterTest("test2", "failed", 124));
        list.add(new FilterTest("test3", "passes", 220));
        list.add(new FilterTest("test4", "passes", 20));
    // sorting testcases on basis of Status
        List<FilterTest> result =  list.stream().filter(t -> "passes".equals(t.status)).collect(Collectors.toList());
       // for(FilterTest f : result){
        //   System.out.println(f.Name+" : "+f.Executiontime + " : " + f.status);
        //  }

     // sorting testcases on basis of Executiontime
        result.sort(Comparator.comparing(t->t.Executiontime));
        for(FilterTest f : result){
            System.out.println(f.Name+" : "+f.Executiontime + " : " + f.status);
        }
        //Summary:-
        long passedTestCase = list.stream().filter(t-> "passes".equals(t.status)).count();
        long failedTestCase = list.stream().filter(t-> "failed".equals(t.status)).count();
        List<FilterTest> passedTestCases = list.stream().filter(t-> "passes".equals(t.status)).collect(Collectors.toList());
        List<FilterTest> failedTestCases = list.stream().filter(t-> "failed".equals(t.status)).collect(Collectors.toList());

        System.out.println("Summary:");
        System.out.println("Total Passed Test Cases: " + passedTestCase);
        for(FilterTest f : passedTestCases){
            System.out.println(f.Name+" : "+f.Executiontime + " : " + f.status);
        }

        System.out.println("Total Failed Test Cases: " + failedTestCase);
        for(FilterTest f : failedTestCases){
            System.out.println(f.Name+" : "+f.Executiontime + " : " + f.status);
        }




    }
}
