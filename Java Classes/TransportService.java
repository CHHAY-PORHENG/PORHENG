// TRANSPORTSERVICE CLASS 
public class TransportService{
    private int serviceId;
    private ServiceType serviceType;

    // CONSTRUCTOR
    public TransportService(int serviceId, ServiceType serviceType){
        this.serviceId = serviceId;
        this.serviceType = serviceType;
    }

    // GETTERS AND SETTERS
    public int gerServicdId(){
        return serviceId;
    }

    public void setServiceId(int serviceId){
        this.serviceId = serviceId;
    }

    public ServiceType getServiceType(){
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType){
        this.serviceType = serviceType;
    }

    public String getDescription(){
        return "Transport service";
    }
}

