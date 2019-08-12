package farmsimulator;

public class Cow implements Alive, Milkable {
    private String name;
    private double amount;
    private double capacity;

    public Cow() {
        name = NAMES[GetRandom.generate(0, 30)];
        amount = 0;
        capacity = GetRandom.generate(15, 40);
    }

    public Cow(String name) {
        this.name = name;
        amount = 0;
        capacity = GetRandom.generate(15, 40);
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name+" "+Math.ceil(amount)+"/"+Math.ceil(capacity);
    }

    @Override
    public void liveHour() {
        double newAmount = GetRandom.generate(0.7, 2.0);
        boolean overCapacity = ((newAmount+amount) > capacity);
        
        if (overCapacity) {
            amount = capacity;
        } else {
            amount += newAmount;
        }
    }

    @Override
    public double milk() {
        double milkAmount = amount;
        amount = 0;
        return milkAmount;
    }

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
}
