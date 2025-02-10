package Java8AndMultiThreading;

import java.util.ArrayList;
import java.util.List;

class TestCases{
    String name;
    String status;
    int priority;
    TestCases(String name, String status, int priority){
        this.name = name;
        this.status = status;
        this.priority = priority;
    }
    public String toString(){
        return "TestCase{name='" + name + "', status='" + status + "', priority=" + priority + '}';
    }
}
@FunctionalInterface
interface TestExecutor{
public void execute(TestCases testCases);
}
public class TestCaseExecutor {
    public static void main(String[] args) {
        List<TestCases> list = new ArrayList<>();
        list.add(new TestCases("Test1", "P", 3));
        list.add(new TestCases("Test2", "P", 1));
        list.add(new TestCases("Test3", "P", 2));
        list.add(new TestCases("Test4", "F", 4));
        TestExecutor priorityExecutor = (TestCases tc) -> System.out.println("Executing" + tc);
        //Lambda can be replaced with method reference  (TestCases tc) -> priorityExecutor.execute(tc)
        list.stream().sorted((tc1,tc2)->Integer.compare(tc2.priority,tc1.priority)).forEach(priorityExecutor::execute);



    }
}
