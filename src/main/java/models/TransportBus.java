package models;

public class TransportBus {
    private Integer id;
    private String plateNumber;
    private String driverName;
    private Integer capacity;
    private String routeDescription;

    public TransportBus() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getPlateNumber() { return plateNumber; }

    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public String getDriverName() { return driverName; }

    public void setDriverName(String driverName) { this.driverName = driverName; }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public String getRouteDescription() { return routeDescription; }

    public void setRouteDescription(String routeDescription) { this.routeDescription = routeDescription; }
}
