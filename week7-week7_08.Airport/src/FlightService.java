public class FlightService {
    private AirportPanel airportPanel;
    
    public FlightService(AirportPanel airportPanel) {
        this.airportPanel = airportPanel;
    }
    
    public void printPlanes() {
        for (Airplane airplane : airportPanel.getAirplanes()) {
            System.out.println(airplane);
        }
    }
    
    public void printFlights() {
        for (Flight flight : airportPanel.getFlights()) {
            System.out.println(flight);
        }
    }
    
    public void printPlaneInfo(String planeID) {
        planeID = StringUtils.stringCleaner(planeID);
        for (Airplane airplane : airportPanel.getAirplanes()) {
            if (airplane.getId().contains(planeID)) {
                System.out.println(airplane);
            }
        }
    }
}
