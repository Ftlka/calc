package calculator.jFrame;

import calculator.*;
import calculator.datatypes.complex.ComplexValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.rational.RationalValueParser;
import calculator.datatypes.real.RealValueParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JFrame{
    static Calculator calc;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;

    private AbstractValueParser[] valueParsers;

    public ComboBox()
    {
        setTitle("Calc");
        setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);

        final JPanel comboPanel = new JPanel();

        comboPanel.setLayout(new GridLayout(0,1));
        final JComboBox faceCombo = new JComboBox();

        valueParsers = new AbstractValueParser[]
                {
                    new IntegerValueParser(),
                    new RealValueParser(),
                    new RationalValueParser(),
                    new ComplexValueParser()
                };
        for (AbstractValueParser valueParser : valueParsers)
        {
            faceCombo.addItem(valueParser.getDatatypeName());
        }

        final JTextField textField = new JTextField("Input window",20);
        final JTextField textField2 = new JTextField("Output window", 20);
        textField2.setEditable(false);

        JButton button = new JButton("solve");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        AbstractValueParser parser = valueParsers[faceCombo.getSelectedIndex()];
                        calc = new Calculator(parser);
                        String[] parameters = textField.getText().split(" "); //SPLIT BY SPACES REDO
                        String a = "";
                        try {
                            a = calc.calculate(parameters[0], parameters[1], parameters[2]);
                        } catch(Exception e) {
                            textField.setText(e.getMessage());
                        }
                        textField2.setText(a);
                    }
                });
                //123123
            }
        });

        comboPanel.add(textField);
        comboPanel.add(textField2);
        comboPanel.add(faceCombo);
        comboPanel.add(button);
        add(comboPanel);
    }
}
