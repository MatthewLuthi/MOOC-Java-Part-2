package logic;

public class Address {
    private String street;
    private String city;
    
    public Address() {
        street = "UNKNOWN";
        city = "UNKNOWN";
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return street+" "+city;
    }
}
