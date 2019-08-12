package calculator.applicationlogic;

public class SimpleCalculator implements Calculator {
    private int value;
    
    public SimpleCalculator() {
        value = 0;
    }
    
    @Override
    public void add(int n) {
        value += n;
    }

    @Override
    public void subtract(int n) {
        value -= n;
    }

    @Override
    public void clear() {
        value = 0;
    }

    @Override
    public int getValue() {
        return value;
    }
    
}
