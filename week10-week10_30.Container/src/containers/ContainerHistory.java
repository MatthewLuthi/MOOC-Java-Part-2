package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {
    private List<Double> containerHistory;
    
    public ContainerHistory() {
        containerHistory = new ArrayList<Double>();
    }
    
    private boolean isEmpty() {
        if (containerHistory.isEmpty()) {
            return true;
        }
        
        return false;
    }
    
    public double maxValue() {
        if (isEmpty()) {
            return 0;
        }
        
        return Collections.max(containerHistory);
    }
    
    public double minValue() {
        if (isEmpty()) {
            return 0;
        }
        
        return Collections.min(containerHistory);
    }
    
    private double sum() {
        double sum = 0;
        for (Double value : containerHistory) {
            sum += value;
        }
        
        return sum;
    }
    
    public double average() {
        if (isEmpty()) {
            return 0;
        }
        
        return sum() / containerHistory.size();
    }
    
    public double greatestFluctuation() {
        if (isEmpty() || containerHistory.size() == 1) {
            return 0;
        }
        
        double greatestFluctuation = 0;
        for (int i = 0; i < containerHistory.size()-1; i++) {
            double fluctuation = Math.abs(containerHistory.get(i) - containerHistory.get(i+1));
            
            if (fluctuation > greatestFluctuation) {
                greatestFluctuation = fluctuation;
            }
        }
      
        return greatestFluctuation;
    }
    
    //Use population variance formula e.g. from wikipedia
    public double variance() {
        if (isEmpty() || containerHistory.size() == 1) {
            return 0;
        }
        
        double sumSquared = ((sum() * sum()) / containerHistory.size());
        
        double individualValuesSquared = 0;
        for (Double value : containerHistory) {
            individualValuesSquared += (value * value);
        }
        
        double squaresSubtracted = individualValuesSquared - sumSquared;
        
        return squaresSubtracted / (containerHistory.size()-1);
    }
    
    public void add(double situation) {
        containerHistory.add(situation);
    }
    
    public void reset() {
        containerHistory.clear();
    }
    
    @Override
    public String toString() {
        return containerHistory.toString();
    }
}
