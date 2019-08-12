import java.util.ArrayList;

public class AirportPanel {
    private ArrayList<Airplane> airplanes;
    private ArrayList<Flight> flights;
    
    public AirportPanel() {
        airplanes = new ArrayList<Airplane>();
        flights = new ArrayList<Flight>();
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }
    
    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }
    
    public Airplane searchAirplane(String planeID) {
        for (Airplane airplane : airplanes) {
            if (airplane.getId().contains(planeID)) {
                return airplane;
            }
        }
        
        return null;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
    
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
}
