package calculator.ui;

import calculator.eventlisteners.AddListener;
import calculator.applicationlogic.Calculator;
import calculator.eventlisteners.OutputListener;
import calculator.eventlisteners.SubtractListener;
import calculator.eventlisteners.ZListener;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private Calculator calculator;
    private MenuPanel menu;
    private JTextField input;
    private JTextField output;

    public GraphicCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));

        input = new JTextField("0");

        output = new JTextField("0");
        output.setEnabled(false);
        
        menu = new MenuPanel();
        menu.getAddButton().addActionListener(new AddListener(calculator, input, output));
        menu.getSubtractButton().addActionListener(new SubtractListener(calculator, input, output));
        menu.getZButton().addActionListener(new ZListener(calculator, input, output));

        output.getDocument().addDocumentListener(new OutputListener(output, menu.getZButton()));

        container.add(output);
        container.add(input);
        container.add(menu);
    }

    public JFrame getFrame() {
        return frame;
    }
}
