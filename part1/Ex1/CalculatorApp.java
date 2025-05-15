import javax.swing.*;
import java.awt.*;
public class CalculatorApp extends JFrame {
public CalculatorApp() {
    setTitle("Graphic Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,400);
    setLocationRelativeTo(null);
    DisplayPanel displayPanel = new DisplayPanel();
    ButtonPanel buttonPanel = new ButtonPanel(displayPanel);
    setLayout(new BorderLayout());
    add(displayPanel,BorderLayout.NORTH);
    add(buttonPanel,BorderLayout.CENTER);
    setVisible(true);
}


}
