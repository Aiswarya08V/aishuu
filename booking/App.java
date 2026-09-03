package com.booking;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystem bookingSystem = new BookingSystem();
        
        System.out.println("=== Event Ticket Booking System ===");
        
        while (true) {
            System.out.print("\nEnter Customer Name (or type 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Ticket Category (Regular, Premium, VIP): ");
            String category = scanner.nextLine();

            System.out.print("Enter Number of Tickets: ");
            int numberOfTickets;
            try {
                numberOfTickets = Integer.parseInt(scanner.nextLine());
                if (numberOfTickets <= 0) {
                    System.out.println("Ticket quantity must be greater than zero. Try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter a whole integer value.");
                continue;
            }

            try {
                double finalCost = bookingSystem.calculateTotalCost(category, numberOfTickets);
                System.out.println("\n------- BOOKING DETAILS -------");
                System.out.println("Customer Name  : " + name);
                System.out.println("Ticket Category: " + category.toUpperCase());
                System.out.println("No. of Tickets : " + numberOfTickets);
                if (numberOfTickets > 5) {
                    System.out.println("Discount State : 10% Bulk Discount Applied");
                } else {
                    System.out.println("Discount State : No Discount Applied");
                }
                System.out.printf("Total Amount   : Rs. %.2f\n", finalCost);
                System.out.println("---------------------------------");
            } catch (IllegalArgumentException e) {
                System.out.println("Booking Error: " + e.getMessage());
            }
        }
        System.out.println("\nSystem stopped.");
        scanner.close();
    }
}
