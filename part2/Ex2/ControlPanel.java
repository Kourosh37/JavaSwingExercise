import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final JTextField widthField;
    private final JTextField heightField;
    private final JButton ScaleButton;
    private final ShowPanel showPanel;

    public ControlPanel(ShowPanel showPanel) {
        this.showPanel = showPanel;
        setLayout(new FlowLayout());
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ScaleButton = new JButton("Scale Image");
        widthField = new JTextField(5);
        heightField = new JTextField(5);
        add(new JLabel("Width:"));
        add(widthField);
        add(new JLabel("Height:"));
        add(heightField);
        add(ScaleButton);
        ScaleButton.addActionListener(e -> {
            try {

                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                int maxWidth = showPanel.getWidth();
                int maxHeight = showPanel.getHeight();
                if (width > maxWidth || height > maxHeight) {
                    JOptionPane.showMessageDialog(this, "Width or height must be equal to max Width or Height");

                } else {
                    showPanel.loadImage();
                    showPanel.scaleImage(width, height);
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,   "Please enter valid numbers for width and height");
            }
        }
        );
    }
}
