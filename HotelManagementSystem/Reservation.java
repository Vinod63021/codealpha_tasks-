class Reservation {
    int bookingId;
    String customerName;
    Room room;
    boolean paymentStatus;

    public Reservation(int bookingId, String customerName, Room room) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.room = room;
        this.paymentStatus = false;
        room.isAvailable = false;
    }
}