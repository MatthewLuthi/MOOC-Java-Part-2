package logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class PhoneBook {
    private Map<String, Person> contactDetails;

    public PhoneBook() {
        contactDetails = new HashMap<String, Person>();
    }

    private boolean exists(String name) {
        if (contactDetails.containsKey(name)) {
            return true;
        }

        return false;
    }

    public void addNumber(String name, String phoneNumber) {
        if (exists(name)) {
            contactDetails.get(name).addPhoneNumber(phoneNumber);
        } else {
            contactDetails.put(name, new Person(name, phoneNumber));
        }
    }

    public void searchNumber(String name) {
        if (exists(name)) {
            for (String number : getPhoneNumbers(name)) {
                System.out.println(number);
            }
        } else {
            System.out.println("  not found");
        }
    }

    public void searchPersonByPhoneNumber(String phoneNumber) {
        Iterator it = contactDetails.entrySet().iterator();
        boolean phoneNumberAndNamePairExist = false;

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if (pair.getValue().getClass() == Person.class) {
                Person person = (Person) pair.getValue();

                if (person.getPhoneNumber().contains(phoneNumber)) {
                    System.out.println(pair.getKey());
                    phoneNumberAndNamePairExist = true;
                }
            }

            it.remove(); //Avoids a concurrentModificationException
        }

        if (!phoneNumberAndNamePairExist) {
            System.out.println("  not found");
        }
    }

    public void addAddress(String name, String street, String city) {
        if (exists(name)) {
            contactDetails.get(name).setAddress(new Address(street, city));
        } else {
            contactDetails.put(name, new Person(name, new Address(street, city)));
        }
    }

    public void searchForPersonalInfo(String name) {
        printPersonInfo(name);
    }

    private void printPersonInfo(String name) {
        if (exists(name)) {
            if (getAddress(name).getStreet().contains("UNKNOWN")
                    || getAddress(name).getCity().contains("UNKNOWN")) {
                System.out.println("  address unknown");
            } else {
                System.out.println("  address: " + getAddress(name));
            }

            if (getPhoneNumbers(name).isEmpty()) {
                System.out.println("  phone number not found");
            } else {
                System.out.println("  phone numbers:");
                for (String number : getPhoneNumbers(name)) {
                    System.out.println("   " + number);
                }
            }
        } else {
            System.out.println("  not found");
        }
    }

    public void filteredListing(String keyword) {
        boolean keywordFound = false;
        SortedMap<String, Person> alphabeticOrderOfPersonObj = new TreeMap();
        
        for (String name : contactDetails.keySet()) {
            if (personKeywordCheck(name, keyword)) {
                alphabeticOrderOfPersonObj.put(name, contactDetails.get(name));
                keywordFound = true;
            }
        }
        
        for (String name : alphabeticOrderOfPersonObj.keySet()) {
            System.out.println("\n  "+name);
            printPersonInfo(name);
        }
        
        if (!keywordFound) {
            if (contactDetails.isEmpty() || !keywordFound) {
                System.out.println("  keyword not found");
            } else {
                for (String name : contactDetails.keySet()) {
                    System.out.println("\n  "+name);
                    printPersonInfo(name);
                }
            }
        }
    }
    
    private boolean personKeywordCheck(String name, String keyword) {
        Person person = contactDetails.get(name);
        
        if (person.getName().contains(keyword) || getAddress(name).getStreet().contains(keyword)
                || getAddress(name).getCity().contains(keyword)) {
            return true;
        }
        
        return false;
    }

    private List<String> getPhoneNumbers(String name) {
        return contactDetails.get(name).getPhoneNumber();
    }

    private Address getAddress(String name) {
        if (exists(name)) {
            return contactDetails.get(name).getAddress();
        }

        return new Address();
    }

    public Map<String, Person> getPhoneBook() {
        return contactDetails;
    }
}
