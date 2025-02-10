package Java8AndMultiThreading;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum ErrorSeverity{
    LOW, MEDIUM, HIGH
}
public class ErrorLogs {
     private String message;
     private int errorcode;
     private ErrorSeverity severity;

     public ErrorLogs(String message, int errorcode, ErrorSeverity severity) {
         this.message = message;
         this.errorcode = errorcode;
         this.severity = severity;
     }
     public String getMessage() {
         return message;
     }
    public ErrorSeverity getSeverity() {
         return severity;
    }
     public int getErrorcode() {
         return errorcode;
     }

     public String toString() {
         return severity + " " + message;
     }



}

class LogProcessor{
     public void processor(List<ErrorLogs> logs){
         // groupingBy method returns a map
         Map<ErrorSeverity, List<ErrorLogs>> severityGroupedLogs =  logs.stream().filter(log -> log.getErrorcode() >0 ).collect(Collectors.groupingBy(ErrorLogs:: getSeverity));
         severityGroupedLogs.forEach((severity , ErrorLogs ) -> {
             System.out.println("severity = " + severity);
             System.out.println("errorLogs = " + ErrorLogs);
         });


     }

     public static void main(String[] args) {
         LogProcessor processor = new LogProcessor();
         List<ErrorLogs> logs = Arrays.asList(
                 new ErrorLogs("Database connection failed", 500, ErrorSeverity.HIGH),
                 new ErrorLogs("Timeout error", 504, ErrorSeverity.HIGH),
                 new ErrorLogs("Invalid input", 400, ErrorSeverity.MEDIUM),
                 new ErrorLogs("Permission denied", 403, ErrorSeverity.HIGH),
                 new ErrorLogs("Resource not found", 404, ErrorSeverity.LOW),
                 new ErrorLogs("Database connection failed", 500, ErrorSeverity.MEDIUM)
         );
         processor.processor(logs);

     }

}
