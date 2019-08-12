package calculator.ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
    private JButton addButton, subtractButton, zButton;
    
    public MenuPanel() {
        super(new GridLayout(1, 3));
        createComponents();
    }
    
    private void createComponents() {
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        zButton = new JButton("Z");
        zButton.setEnabled(false);
        
        add(addButton);
        add(subtractButton);
        add(zButton);
    }
    
    public JButton getAddButton() {
        return addButton;
    }
    
    public JButton getSubtractButton() {
        return subtractButton;
    }
    
    public JButton getZButton() {
        return zButton;
    }
    
    public List<JButton> getButtons() {
        List<JButton> buttons = new ArrayList<JButton>();
        buttons.add(addButton);
        buttons.add(subtractButton);
        buttons.add(zButton);
        
        return buttons;
    }
}
