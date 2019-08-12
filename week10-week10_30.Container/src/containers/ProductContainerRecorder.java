package containers;

public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory containerHistory;
    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        containerHistory = new ContainerHistory();
        addToTheContainer(initialVolume);
    }
    
    public String history() {
        return containerHistory.toString();
    }
   
    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        containerHistory.add(getVolume());
    }
    
    @Override
    public double takeFromTheContainer(double amount) {
        double amountTaken = super.takeFromTheContainer(amount);
        containerHistory.add(getVolume());
        return amountTaken;
    }
    
    public void printAnalysis() {
        System.out.println("Product: "+super.getName());
        System.out.println("History: "+containerHistory.toString());
        System.out.println("Greatest product amount: "+containerHistory.maxValue());
        System.out.println("Smallest product amount: "+containerHistory.minValue());
        System.out.println("Average: "+containerHistory.average());
        System.out.println("Greatest change: "+containerHistory.greatestFluctuation());
        System.out.println("Variance: "+containerHistory.variance());
    }
}
