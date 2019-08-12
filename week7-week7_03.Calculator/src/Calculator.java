public class Calculator {
    private Reader reader;
    private int calculations;
    
    public Calculator() {
        reader = new Reader();
        calculations = 0;
    }
    
    public void start() {
        while (true) {
            System.out.println("Command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }
            
            if (command.equals("sum")) {
                sum();
                calculations++;
            } else if (command.equals("difference")) {
                difference();
                calculations++;
            } else if (command.equals("product")) {
                product();
                calculations++;
            }
        }
        
        statistics();
    }
    
    private void sum() {
        int[] values = readInput();
        int sum = values[0] + values[1];
        System.out.println("sum of the values "+sum);
    }
    
    private void difference() {
        int[] values = readInput();
        int difference = values[0] - values[1];
        System.out.println("difference of the values "+difference);
    }
    
    private void product() {
        int[] values = readInput();
        int product = values[0] * values[1];
        System.out.println("product of the values "+product);
    }
    
    private void statistics() {
        System.out.println("Calculations done "+calculations);
    }
    
    private int[] readInput() {
        int[] values = new int[2];
        
        System.out.print("value1: ");
        values[0] = reader.readInteger();
        System.out.print("value2: ");
        values[1] = reader.readInteger();
        return values;
    }
    
}
