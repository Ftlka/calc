package calculator.jFrame;

import javax.swing.*;
import java.awt.*;

public class Program {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComboBox frame = new ComboBox(); //Creating frame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //What happens when the frame closes
                frame.setVisible(true); //Show it
            }
        });
    }
}
