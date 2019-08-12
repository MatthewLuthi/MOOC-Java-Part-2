package calculator.eventlisteners;

import calculator.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AddListener extends ButtonListener {   
    public AddListener(Calculator calculator, JTextField input, JTextField output) {
        super(calculator, input, output);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //int inputValue = Integer.parseInt(getInput().getText());
        int inputValue = validateInput();
        getCalculator().add(inputValue);
        
        String outputValue = Integer.toString(getCalculator().getValue());
        getOutput().setText(outputValue);
        
        super.actionPerformed(e);
    }
}
