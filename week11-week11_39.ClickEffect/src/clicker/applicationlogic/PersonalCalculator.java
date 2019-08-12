package clicker.applicationlogic;

public class PersonalCalculator implements Calculator {
    private int value;
    
    @Override
    public int giveValue() {
        return value;
    }

    @Override
    public void increase() {
        value++;
    }
    
}
