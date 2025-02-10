package Java2;

import java.util.ArrayList;
import java.util.List;

public class CollectionOperationsLogger {
    public class OperationLogger {
        private List<String> operationLog = new ArrayList<>();
        public void log(String operation) {
            operationLog.add(operation + " at " + System.currentTimeMillis());
        }
        public void displayLog() {
            System.out.println("Operation Log:");
            operationLog.forEach(System.out::println);
        }
    }
    public void demonstrateAutoboxing() {
        OperationLogger logger = new OperationLogger();
        List<Integer> integerList = new ArrayList<>();
        logger.log("Started autoboxing demonstration");
        int[] primitiveValues = {10, 20, 30, 40, 50};
        for (int value : primitiveValues) {
            integerList.add(value);  // Automatic conversion
            logger.log("Added primitive value: " + value);
        }
        int sum = 0;
        logger.log("Started unboxing demonstration");
        for (Integer num : integerList) {
            sum += num;  // Automatic conversion back to primitive
            logger.log("Unboxed and added: " + num);
        }
        System.out.println("List: " + integerList);
        System.out.println("Sum: " + sum);
        logger.displayLog();
    }
    public static void main(String[] args) {
        CollectionOperationsLogger demo = new CollectionOperationsLogger();
        demo.demonstrateAutoboxing();
    }
}
