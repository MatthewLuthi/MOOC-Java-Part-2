
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.latinName != null ? this.latinName.hashCode() : 0);
        hash = 29 * hash + this.ringingYear;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Bird other = (Bird) obj;     
        return (latinName.equals(other.latinName) && ringingYear == other.ringingYear); 
    }

    
    
    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


