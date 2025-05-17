import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private static final String[] BUTTONS =

    {
        "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "C", "(", ")", "b"
    };

    public ButtonPanel(DisplayPanel display) {
        setLayout(new GridLayout(5, 4, 1, 1));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ActionListener actionListener = e -> {
            String cmd = ((JButton) e.getSource()).getText();
            if (cmd.equals("=")) {
                String Expr = display.getDisplay();
                String result = EvalUtil.eval(Expr);
                display.setDisplay(result);
            } else if (cmd.equals("C")) {
                display.setDisplay("");
            } else if (cmd.equals("b")) {
                if (display.getDisplay().length() > 0) {
                    display.setDisplay(display.getDisplay().substring(0, display.getDisplay().length() - 1));
                }
            } else {
                display.setDisplay(display.getDisplay() + cmd);
            }
        };
        for (String button : BUTTONS) {
            JButton btn = new JButton(button);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.addActionListener(actionListener);
            add(btn);
        }

    }

}