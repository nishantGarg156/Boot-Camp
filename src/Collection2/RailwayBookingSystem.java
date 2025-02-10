package Collection2;
import java.util.*;
public class RailwayBookingSystem {
    private Queue<String> ticketQueue;
    public RailwayBookingSystem() {
        ticketQueue = new LinkedList<>();
    }
    public void bookTicket(String customerName) {
        ticketQueue.offer(customerName);
        System.out.println(customerName + " has booked a ticket.");
    }
    public void serveCustomer() {
        if (!ticketQueue.isEmpty()) {
            String servedCustomer = ticketQueue.poll();
            System.out.println(servedCustomer + " has been served.");
        } else {
            System.out.println("No customers in the queue.");
        }
    }
    public void showQueue() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No customers in the queue.");
        } else {
            System.out.println("Customers in queue: " + ticketQueue);
        }
    }
    public static void main(String[] args) {
        RailwayBookingSystem bookingSystem = new RailwayBookingSystem();
        bookingSystem.bookTicket("Nishant");
        bookingSystem.bookTicket("Bhaskar");
        bookingSystem.bookTicket("Rishab");
        bookingSystem.showQueue();
        bookingSystem.serveCustomer();
        bookingSystem.serveCustomer();
        bookingSystem.showQueue();
    }
}
