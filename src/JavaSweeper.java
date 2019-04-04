import sweeper.Box;
import java.awt.*;
import javax.swing.*;

public class JavaSweeper extends JFrame
{
    private final int COL = 15;
    private final int ROW = 1;
    private final int IMAGE_SIZE = 50;
    private JPanel panel;

    public static void main(String[] args) 
    {
        new JavaSweeper().setVisible(true);
    }
    
    private JavaSweeper()            
    {
        setImages();
        initPanel();
        initFrame();
    }
    
    private void initPanel() 
    {
        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                for (Box  box : Box.values()) 
                {
                    g.drawImage((Image)box.image, box.ordinal() * IMAGE_SIZE, 0, this);
                }
            }                   
        };
        panel.setPreferredSize(new Dimension(COL * IMAGE_SIZE, ROW * IMAGE_SIZE));
        add(panel);
    };
    
    private void setImages()
    {
        for (Box  box : Box.values()) 
        {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jawa Sweeper");        
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
    
    private Image getImage(String name)
    {        
        ImageIcon icon = new ImageIcon("res\\img\\" + name + ".png");
        return icon.getImage();
    };


            
    
}
