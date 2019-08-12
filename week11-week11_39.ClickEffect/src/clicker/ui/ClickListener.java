package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ClickListener implements ActionListener {
    private Calculator calculator;
    private JLabel countLabel;
    
    public ClickListener(Calculator calculator, JLabel countLabel) {
        this.calculator = calculator;
        this.countLabel = countLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.increase();
        countLabel.setText(Integer.toString(calculator.giveValue()));
    }
    
}
