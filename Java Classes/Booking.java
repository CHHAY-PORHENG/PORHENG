// Booking class
public class Booking {
    private int bookingId;
    private User user;
    private TransportService transportService;
    private Bus bus;
    private Payment payment;

    // Constructor
    public Booking(int bookingId, User user, TransportService transportService, Bus bus, Payment payment) {
        this.bookingId = bookingId;
        this.user = user;
        this.transportService = transportService;
        this.bus = bus;
        this.payment = payment;
    }

    // Getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TransportService getTransportService() {
        return transportService;
    }

    public void setTransportService(TransportService transportService) {
        this.transportService = transportService;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}