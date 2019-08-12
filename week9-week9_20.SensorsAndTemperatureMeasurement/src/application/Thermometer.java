package application;

import java.util.Random;

public class Thermometer implements Sensor {
    private boolean on;
    
    public Thermometer() {
        on = false;
    }
    
    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void on() {
        on = true;
    }

    @Override
    public void off() {
        on = false;
    }

    @Override
    public int measure() {
        if (isOn()) {
            int min = -30;
            int max = 30;
            
            Random r = new Random();
            return r.nextInt(max - min + 1) + min;
        }
        
        throw new IllegalStateException("Thermometer is off");
    }
    
}
