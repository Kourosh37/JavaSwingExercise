import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("image Scaler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        ShowPanel showPanel = new ShowPanel();
        ControlPanel controlPanel = new ControlPanel(showPanel);
        add(showPanel,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        setVisible(true);
    }


}
