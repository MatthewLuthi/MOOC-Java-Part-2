package calculator.eventlisteners;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * OuputListener is an event listener for the JTextField output where
 * if the value is of the textField is 0, the user cannot click reset (Z button)
 * @author Mxtt Offline
 */
public class OutputListener implements DocumentListener {
    private JButton zButton;
    private JTextField output;
    
    public OutputListener(JTextField output, JButton zButton) {
        this.output = output;
        this.zButton = zButton;
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        checkOutputValue();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkOutputValue();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkOutputValue();
    }
  
    private boolean isOutputNonZero() {
        if (output.getText().equals("0")) {
            return false;
        }
        
        return true;
    }
    
    private void checkOutputValue() {
        zButton.setEnabled(isOutputNonZero());
    }    
}
