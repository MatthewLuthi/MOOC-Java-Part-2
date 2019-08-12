package calculator.eventlisteners;

import calculator.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SubtractListener extends ButtonListener {
    
    public SubtractListener(Calculator calculator, JTextField input, JTextField output) {
        super(calculator, input, output);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        //int subtractValue = Integer.parseInt(getInput().getText());
        int subtractValue = validateInput();
        getCalculator().subtract(subtractValue);
        
        String outputValue = Integer.toString(getCalculator().getValue());
        getOutput().setText(outputValue);
        
        super.actionPerformed(e);
    }  
}
