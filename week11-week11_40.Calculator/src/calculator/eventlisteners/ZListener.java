package calculator.eventlisteners;

import calculator.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ZListener extends ButtonListener {
    public ZListener(Calculator calculator, JTextField input, JTextField output) {
        super(calculator, input, output);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        getCalculator().clear();
        getInput().setText("0");
        getOutput().setText("0");
        
        super.actionPerformed(e);
    }
    
}
