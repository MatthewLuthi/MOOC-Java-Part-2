package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(new JLabel("Are you?"));
        
//        JRadioButton yes = new JRadioButton("Yes!");
//        JRadioButton no = new JRadioButton("No!");
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        ButtonGroup buttons1 = new ButtonGroup();
        buttons1.add(yes);
        buttons1.add(no);
        container.add(yes);
        container.add(no);
        
        container.add(new JLabel("Why?"));
        
        JRadioButton idk = new JRadioButton("No reason.");
        JRadioButton fun = new JRadioButton("Because it is fun!");
        //JCheckBox idk = new JCheckBox("No reason.");
        //JCheckBox fun = new JCheckBox("Because it is fun!");
        ButtonGroup buttons2 = new ButtonGroup();
        buttons2.add(idk);
        buttons2.add(fun);
        container.add(idk);
        container.add(fun);
        
        container.add(new JButton("Done!"));
    }


    public JFrame getFrame() {
        return frame;
    }
}
