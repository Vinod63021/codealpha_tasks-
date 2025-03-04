import java.util.*;

public class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static int bookingCounter = 1;

    public static void main(String[] args) {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Make Payment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    processPayment(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 1000));
        rooms.add(new Room(102, "Double", 1500));
        rooms.add(new Room(103, "Suite", 2500));
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("Room " + room.roomNumber + " (" + room.category + ") - Rs." + room.price);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        viewAvailableRooms();
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                reservations.add(new Reservation(bookingCounter++, name, room));
                System.out.println("Booking successful!");
                return;
            }
        }
        System.out.println("Room not available or invalid.");
    }

    private static void viewReservations() {
        System.out.println("\nBooking Details:");
        for (Reservation res : reservations) {
            System.out.println("Booking ID: " + res.bookingId + ", Name: " + res.customerName + ", Room: " + res.room.roomNumber + " (" + res.room.category + "), Paid: " + res.paymentStatus);
        }
    }

    private static void processPayment(Scanner scanner) {
        System.out.print("Enter Booking ID to make payment: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();
        
        for (Reservation res : reservations) {
            if (res.bookingId == bookingId) {
                if (!res.paymentStatus) {
                    res.paymentStatus = true;
                    System.out.println("Payment successful!");
                } else {
                    System.out.println("Payment already made.");
                }
                return;
            }
        }
        System.out.println("Invalid Booking ID.");
    }
}