
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.containsKey(plate)) {
            return false;
        }
        
        owners.put(plate, owner);
        return true;
    }
    
    public String get(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            return owners.get(plate);
        }
        
        return null;
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            owners.remove(plate);
            return true;
        }
        
        return false;
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> uniqueOwners = new ArrayList<String>();
        for (String owner : owners.values()) {
            if (!uniqueOwners.contains(owner)) {
                uniqueOwners.add(owner);
            }
        }
        
        for (String owner : uniqueOwners) {
            System.out.println(owner);
        }
    }
}
