
import javax.swing.*;
import java.awt.*;

public class DrawRectangle extends JPanel implements Cloneable {

    private final Color color;


    public DrawRectangle(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(0, 0, 1000, 500);

    }

    public DrawRectangle clone() throws CloneNotSupportedException{
        final DrawRectangle copy;

        copy = (DrawRectangle) super.clone();

        return copy;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 45);
    }





}
