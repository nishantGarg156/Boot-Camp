package Java8AndMultiThreading;

public class TestCase extends Thread {
    private String testName;
    private boolean testPassed;

    TestCase(String testName) {
        this.testName = testName;
        this.testPassed = false;
    }

    public void run() {
        try {
            System.out.println(testName + ": Test started");
            Thread.sleep(3000);
            testPassed = Math.random() > 0.3;
            System.out.println(testName + ": Test " +
                    (testPassed ? "PASSED" : "FAILED"));
        } catch (InterruptedException e) {
            System.out.println(testName + ": Test interrupted");
        }
    }


}

class OATestAutomation extends Thread {
    public static void  main(String[] args) throws InterruptedException {
        TestCase[] testCases = {
                new TestCase("TEST1"),
                new TestCase("TEST2"),
                new TestCase("TEST3"),
        };
        for (TestCase testCase : testCases) {
            testCase.start();
        }
        for (TestCase testCase : testCases) {
            testCase.join();
            System.out.println(testCase.getName() + " Thread Status: " +
                    (testCase.isAlive() ? "Still Running" : "Completed"));
        }
    }

}
