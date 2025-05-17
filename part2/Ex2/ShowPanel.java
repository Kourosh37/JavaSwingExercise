import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ShowPanel extends JPanel {
    private Image image;
    private String imagePath = "sololeveling.jpg";

    public ShowPanel() {
setLayout(new BorderLayout());
setBorder(BorderFactory.createLineBorder(Color.black,2));
loadImage();

    }
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public void loadImage(){
        try{
            image = ImageIO.read(getClass().getResource(imagePath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        repaint();
    }
    public void scaleImage(int width, int height){
        if(image != null)
        {
            Image scaled = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            image = scaled;
            repaint();
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null){
            int x = (getWidth()-image.getWidth(null))/2;
            int y = (getHeight()-image.getHeight(null))/2;
        g.drawImage(image,x,y,this);
        }

    }

}
