package User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BusBookingSystem {
    public void handleBusBooking(Scanner scanner) {
        System.out.println("Welcome to the online bus booking system!");

        // Display destination options
        System.out.println("\n1. Select your destination:");
        System.out.println("   - Phnom Penh to Siem Reap");
        System.out.println("   - Phnom Penh to Sihanoukville");
        System.out.println("   - Phnom Penh to Kampong Thom");
        System.out.println("   - Phnom Penh to Battambang");

        // Display destination option from province back to Phnom Penh
        System.out.println("\n2. Select your destination: ");
        System.out.println("   - Siem Reap to Phnom Penh");
        System.out.println("   - Sihanoukville to Phnom Penh");
        System.out.println("   - Kampong Thom to Phnom Penh");
        System.out.println("   - Battambang to Phnom Penh");

        // Get destination choice from the user
        System.out.print("Enter the number corresponding to your destination: ");
        int destinationChoice = scanner.nextInt();
        scanner.nextLine();

        // Display time options based on destination choice
        String selectedDestination = getDestinationFromChoice(destinationChoice);
        System.out.println("\n2. Select your time:");

        // Display Seats number for user to choice
        System.out.println("Select your number of seats: ");
        int numberOfSeats = scanner.nextInt();
        scanner.nextLine();
        double seatCalculator = numberOfSeats * 13.00;

        String selectedTime = getTimeFromDestination(selectedDestination);
        System.out.println("   - " + selectedTime);

        // Get payment option from the user
        System.out.println("\n3. Select your payment:");
        System.out.println("   - Visa");
        System.out.println("   - Master Card");
        System.out.print("Enter the number corresponding to your payment option: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        String selectedPayment = getPaymentFromChoice(paymentChoice);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Display selected information
        System.out.println("\nThank you for booking with us!");
        System.out.println("Destination: " + selectedDestination);
        System.out.println("Time: " + selectedTime);
        System.out.println("Total Price: " + seatCalculator);
        System.out.println("Payment: " + selectedPayment);
        System.out.println("Booking Date and Time: " + formattedDateTime);
    }

    private static String getDestinationFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "Phnom Penh to Siem Reap";
            case 2:
                return "Phnom Penh to Sihanoukville";
            case 3:
                return "Phnom Penh to Kampong Thom";
            case 4:
                return "Phnom Penh to Battambang";
            case 5:
                return "Siem Reap to Phnom Penh";
            case 6:
                return "Sihanoukville to Phnom Penh";
            case 7:
                return "Kampong Thom to Phnom Penh";
            case 8:
                return "Battambang to Phnom Penh";            
            default:
                return "Invalid destination";
        }
    }

    private static String getTimeFromDestination(String destination) {
        switch (destination) {
            case "Phnom Penh to Siem Reap":
                return "14:00 - 18:45 (5h 45m)";
            case "Phnom Penh to Sihanoukville":
                return "14:00 - 17:00 (4h 00m)";
            case "Phnom Penh to Kampong Thom":
                return "7:30 - 10:00 (3h 30m)";
            case "Phnom Penh to Battambang":
                return "8:00 - 12:30 (5h 30m)";
            case "Siem Reap to Phnom Penh":
                return "14:00 - 18:45 (5h 45m)";
            case "Sihanoukville to Phnom Penh":
                return "14:00 - 17:00 (4h 00m)";
            case "Kampong Thom to Phnom Penh":
                return "7:30 - 10:00 (3h 30m)";
            case "Battambang to Phnom Penh":
                return "8:00 - 12:30 (5h 30m)";    
            default:
                return "Invalid destination";
        }
    }

    private static String getPaymentFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "Visa";
            case 2:
                return "Master Card";
            default:
                return "Invalid payment option";
        }
    }
}
