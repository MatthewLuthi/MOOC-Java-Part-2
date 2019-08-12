
public class Flight {
    private Airplane airplane;
    private String departureAirportCode;
    private String destinationAirportCode;

    public Flight(Airplane airplane, String departureAirportCode, String destinationAirportCode) {
        this.airplane = airplane;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }
    
    @Override
    public String toString() {
        return airplane.toString()+" ("+StringUtils.stringCleaner(departureAirportCode)+
                "-"+StringUtils.stringCleaner(destinationAirportCode)+")";
    }
}
