package logic;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<String> phoneNumbers;
    private Address address;
    
    
    public Person(String name, String phoneNumber) {
        this.name = name;
        phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(phoneNumber);
        address = new Address();
    }
    
    public Person(String name, Address address) {
        this.name = name;
        phoneNumbers = new ArrayList<String>();
        this.address = address;
    }
    
    public Person(String name, String phoneNumber, Address address) {
        this.name = name;
        phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(phoneNumber);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumber() {
        return phoneNumbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return name+"\n"+"address: "+address+"\n"+phoneNumbers;
    }
}
