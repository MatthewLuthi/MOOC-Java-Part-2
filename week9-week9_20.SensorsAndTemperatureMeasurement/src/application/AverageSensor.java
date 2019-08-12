package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        sensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("Average sensor must be on or not equal to null");
        }

        int reading = 0;
        for (Sensor sensor : sensors) {
            reading += sensor.measure();
        }

        reading /= sensors.size();
        readings.add(reading);
        return reading;
    }

    public List<Integer> readings() {
        return readings;
    }
}
