package com.booking;

public class BookingSystem {
    public static final String REGULAR = "regular";
    public static final String PREMIUM = "premium";
    public static final String VIP = "vip";

    /**
     * Calculates the total ticket cost based on category, quantity, and bulk discount.
     * Rule: 10% discount applied to the entire purchase if buying more than 5 tickets.
     */
    public double calculateTotalCost(String category, int numberOfTickets) {
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException("Number of tickets must be greater than zero.");
        }

        double pricePerTicket;

        switch (category.toLowerCase().trim()) {
            case REGULAR:
                pricePerTicket = 500.0;
                break;
            case PREMIUM:
                pricePerTicket = 1200.0;
                break;
            case VIP:
                pricePerTicket = 2500.0;
                break;
            default:
                throw new IllegalArgumentException("Unknown Ticket Category: " + category);
        }

        double subtotal = pricePerTicket * numberOfTickets;

        // Apply 10% discount if tickets purchased exceed 5
        if (numberOfTickets > 5) {
            subtotal = subtotal * 0.90;
        }

        return subtotal;
    }
}
