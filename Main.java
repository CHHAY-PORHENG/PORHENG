package User;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Username: " + username;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return username.equals(user.username) && password.equals(user.password);
    }
}

public class Main {
    private Map<String, User> userMap;
    private Scanner scanner;

    public Main() {
        this.userMap = readFromFile();
        this.scanner = new Scanner(System.in);
    }

    public void handleBusBooking() {
        System.out.println("Welcome to the online bus booking system!");

        // Display destination options
        System.out.println("\nA. Select your destination:");
        System.out.println("   1- Phnom Penh -> Siem Reap");
        System.out.println("   2- Phnom Penh -> Sihanoukville");
        System.out.println("   3- Phnom Penh -> Kampong Thom");
        System.out.println("   4- Phnom Penh -> Battambang");

        // Display destination option from province back to Phnom Penh
        System.out.println("\n. Select your destination: ");
        System.out.println("   5- Siem Reap -> Phnom Penh");
        System.out.println("   6- Sihanoukville -> Phnom Penh");
        System.out.println("   7- Kampong Thom -> Phnom Penh");
        System.out.println("   8- Battambang -> Phnom Penh");

        // Get destination choice from the user
        System.out.print("Enter the number corresponding to your destination: ");
        int destinationChoice = scanner.nextInt();
        scanner.nextLine();

        // Display time options based on destination choice
        String selectedDestination = getDestinationFromChoice(destinationChoice);
        System.out.println("\nB. Select your time:");

        // Display Seats number for user to choice
        System.out.println("C.Select your number of seats: ");
        int numberOfSeats = scanner.nextInt();
        scanner.nextLine();
        double seatCalculator = numberOfSeats * 13.00;

        String selectedTime = getTimeFromDestination(selectedDestination);
        System.out.println("   - " + selectedTime);

        // Get payment option from the user
        System.out.println("\nD. Select your payment:");
        System.out.println("   1- Visa");
        System.out.println("   2- Master Card");
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
        System.out.println("Total Amount: " + seatCalculator);
        System.out.println("Payment: " + selectedPayment);
        System.out.println("Booking Date and Time: " + formattedDateTime);
    }

    private static String getDestinationFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "Phnom Penh -> Siem Reap";
            case 2:
                return "Phnom Penh -> Sihanoukville";
            case 3:
                return "Phnom Penh -> Kampong Thom";
            case 4:
                return "Phnom Penh -> Battambang";
            case 5:
                return "Siem Reap -> Phnom Penh";
            case 6:
                return "Sihanoukville -> Phnom Penh";
            case 7:
                return "Kampong Thom -> Phnom Penh";
            case 8:
                return "Battambang -> Phnom Penh";
            default:
                return "Invalid destination";
        }
    }

    private static String getTimeFromDestination(String destination) {
        switch (destination) {
            case "Phnom Penh -> Siem Reap":
                return "14:00 - 18:45 (5h 45m)";
            case "Phnom Penh -> Sihanoukville":
                return "14:00 - 17:00 (4h 00m)";
            case "Phnom Penh -> Kampong Thom":
                return "7:30 - 10:00 (3h 30m)";
            case "Phnom Penh -> Battambang":
                return "8:00 - 12:30 (5h 30m)";
            case "Siem Reap -> Phnom Penh":
                return "14:00 - 18:45 (5h 45m)";
            case "Sihanoukville -> Phnom Penh":
                return "14:00 - 17:00 (4h 00m)";
            case "Kampong Thom -> Phnom Penh":
                return "7:30 - 10:00 (3h 30m)";
            case "Battambang -> Phnom Penh":
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

    public void register(String username, String password) {
        User newUser = new User(username, password);
        userMap.put(username, newUser);
        saveToFile();
    }

    public boolean login(String username, String password) {
        User user = userMap.get(username);
        return user != null && user.equals(new User(username, password));
    }

    public void changeInformation(String username, String password) {
        User user = userMap.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful! What information would you like to change?");
            System.out.println("1. Change username");
            System.out.println("2. Change password");
            System.out.println("3. Change both");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    user.setUsername(newUsername);
                    saveToFile();
                    System.out.println("Username changed successfully!");
                    break;

                case 2:
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    user.setPassword(newPassword);
                    saveToFile();
                    System.out.println("Password changed successfully!");
                    break;

                case 3:
                    System.out.print("Enter new username: ");
                    String updatedUsername = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String updatedPassword = scanner.nextLine();
                    user.setUsername(updatedUsername);
                    user.setPassword(updatedPassword);
                    saveToFile();
                    System.out.println("Username and password changed successfully!");
                    break;

                default:
                    System.out.println("Invalid choice. No changes made.");
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("user_data.txt"))) {
            for (User user : userMap.values()) {
                writer.println(user.getUsername() + "/" + user.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, User> readFromFile() {
        Map<String, User> users = new HashMap<>();
        try (Scanner scanner = new Scanner(new File("user_data.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("/");
                if (parts.length == 2) {
                    users.put(parts[0], new User(parts[0], parts[1]));
                }
            }
        } catch (FileNotFoundException e) {

        }
        return users;
    }

    public void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Change Information");
            System.out.println("4. Book a Bus");
            System.out.println("5. Quit");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();
                    main.register(regUsername, regPassword);
                    System.out.println("User registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    boolean loginResult = main.login(loginUsername, loginPassword);
                    if (loginResult) {
                        System.out.println("Login successful!");

                        // Display additional options for logged-in users
                        main.displayLoggedInMenu();
                    } else {
                        System.out.println("Login failed. Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    String changeUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String changePassword = scanner.nextLine();
                    main.changeInformation(changeUsername, changePassword);
                    break;

                case 4:
                    main.handleBusBooking();
                    break;

                case 5:
                    System.out.println("Quitting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 5);

        // Close the scanner and any other resources
        main.closeScanner();
        scanner.close();
    }

    private void displayLoggedInMenu() {
        // Additional options for logged-in users
        System.out.println("\nWelcome to the online bus booking system!");
        System.out.println("1. Select your destination");
        System.out.println("2. Quit");

        int busChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (busChoice) {
            case 1:
                handleBusBooking();
                break;
            case 2:
                System.out.println("Quitting the bus booking system. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }
}
