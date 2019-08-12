package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume;
    
    public BulkTank() {
        capacity = 2000;
        volume = 0;
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
        volume = 0;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        double newAmount = amount + volume;
        if (newAmount < capacity) {
            volume += amount;
        } else {
            volume = capacity;
        }
    }
    
    public double getFromTank(double amount) {
        double amountTaken = volume - amount;
        if (amountTaken < 0) {
            volume = 0;
        } else {
           volume -= amount; 
        }
        
        return amount;
    }
    
    @Override
    public String toString() {
        return Math.ceil(volume)+"/"+Math.ceil(capacity);
    }
}
