public class Airplane {
    private String id;
    private int capacity;
    
    public Airplane() {
        id = "UNKNOWN";
        capacity = 0;
    }
    
    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
    
    @Override
    public String toString() {
        return StringUtils.stringCleaner(id)+" ("+capacity+" ppl)";
    }
}
