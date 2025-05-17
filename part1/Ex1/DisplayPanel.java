import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
public class DisplayPanel extends JPanel {
    private JTextField displayField;
    public DisplayPanel() {
setLayout( new BorderLayout());
displayField = new JTextField();
setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
displayField.setFont(new Font("Arial",Font.PLAIN,24));
displayField.setHorizontalAlignment(JTextField.LEFT);
add(displayField,BorderLayout.CENTER);
}
public String getDisplay() {
        return displayField.getText();
}
public void setDisplay(String display) {
        displayField.setText(display);
}
}
