// BUS CLASS INHERITS FROM TRANSPORTSERVICE
public class Bus extends TransportService{
    private String busNumber;
    private int totalSeats;
    private int availableSeats;

    // CONSTRUCTOR
    public Bus(int serviceId, ServiceType serviceType, String busNumber, int totalSeats, int availableSeats){
        super(serviceId, serviceType);
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    // GETTERS AND SETTERS
    public String getBusNumber(){
        return busNumber;
    }

    public void setBusNumber(String busNumber){
        this.busNumber = busNumber;
    }

    public int getTotalSeats(){
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats){
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats(){
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats){
        this.availableSeats = availableSeats;
    }

    @Override
    public String getDescription(){
        return "Bus service";
    }

    // METHOD TO UPDATE AVAILABLE SEATS
    public void updateAvailableSeats(int bookedSeats){
        availableSeats -= bookedSeats;
    }
}
