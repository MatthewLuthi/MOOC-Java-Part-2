package moving.domain;

public class Item implements Thing, Comparable<Item> {
    private String name;
    private int volume;
    
    public Item(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name+" ("+volume+" dm^3)";
    }

    @Override
    public int compareTo(Item otherItem) {
        return getVolume() - otherItem.getVolume();
    }
}
