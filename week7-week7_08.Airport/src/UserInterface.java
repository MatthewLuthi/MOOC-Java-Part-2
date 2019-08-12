
import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private AirportPanel airportPanel;
    private FlightService flightService;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        airportPanel = new AirportPanel();
        flightService = new FlightService(airportPanel);
        
        /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TEMP CODE ############### */
        //airportPanel.addAirplane(new Airplane("g-owac", 101));
    }
    
    public void start() {
        airportPanelStart();
        flightServicePanelStart();
    }
    
    public void airportPanelStart() {
        System.out.println(" Airport panel");
        System.out.println("---------------");
        
        while (true) {
            if (!readAirportInput()) {
                break;
            }
        }
    }
    
    public boolean readAirportInput() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
        System.out.print("> ");
        String input = reader.nextLine();
        if (input.contains("x")) {
            return false;
        }
        
        handleAirportInput(input);
        return true;
    }
    
    public void handleAirportInput (String input) {
        if (input.contains("1")) {
            addAirplaneToPanel();
        } else if (input.contains("2")) {
            addFlightToPanel();
        }
    }
    
     public void flightServicePanelStart() {
        System.out.println("\n Flight service");
        System.out.println("----------------");
        
        while (true) {
            if (!readFlightServiceInput()) {
                break;
            }
        }
    }
     
     public boolean readFlightServiceInput() {
         System.out.println("\nChoose operation:");
         System.out.println("[1] Print planes");
         System.out.println("[2] Print flights");
         System.out.println("[3] Print plane info");
         System.out.println("[x] Quit");
         System.out.print("> ");
         
         String input = reader.nextLine();
         if (input.contains("x")) {
             return false;
         }
         
         handleFlightServiceInput(input);
         return true;
     }
     
     public void handleFlightServiceInput(String input) {
         if (input.contains("1")) {
             flightService.printPlanes();
         } else if (input.contains("2")) {
             flightService.printFlights();
         } else if (input.contains("3")) {
             System.out.print("Give plane ID: ");
             String planeID = reader.nextLine();
             flightService.printPlaneInfo(planeID);
         }
     }
    
    public void addAirplaneToPanel() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        
        planeID = StringUtils.stringCleaner(planeID);
        
        Airplane airplane = new Airplane(planeID, capacity);
        airportPanel.addAirplane(airplane);
    }
    
    public void addFlightToPanel() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departure = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = reader.nextLine();
        
        planeID = StringUtils.stringCleaner(planeID);
        departure = StringUtils.stringCleaner(departure);
        destination = StringUtils.stringCleaner(destination);
        
        Airplane airplane = airportPanel.searchAirplane(planeID);
        Flight flight = new Flight(airplane, departure, destination);
        airportPanel.addFlight(flight);  
    }
}
