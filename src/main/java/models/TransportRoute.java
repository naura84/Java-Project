package models;

public class TransportRoute {
    private Integer id;
    private String name;
    private String stops; // JSON
    private Boolean active;

    public TransportRoute() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStops() { return stops; }

    public void setStops(String stops) { this.stops = stops; }

    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }
}
