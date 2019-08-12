package calculator.eventlisteners;

import calculator.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public abstract class ButtonListener implements ActionListener {
    private Calculator calculator;
    private JTextField input;
    private JTextField output;
    
    public ButtonListener(Calculator calculator, JTextField input, JTextField output) {
        this.calculator = calculator;
        this.input = input;
        this.output = output;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        input.setText("");
    }
    
    protected int validateInput() {
        try {
            return Integer.parseInt(input.getText());
            
        } catch (NumberFormatException e) {
            input.setText("");
            return 0;
        }
    }
    
    public Calculator getCalculator() {
        return calculator;
    }
    
    public JTextField getInput() {
        return input;
    }
    
    public JTextField getOutput() {
        return output;
    }
}
