
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JavaSweeper extends JFrame{

    public static void main(String[] args) 
    {
        new JavaSweeper().setVisible(true);
    }
    
    public JavaSweeper()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jawa Sweeper");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
            
    
}
