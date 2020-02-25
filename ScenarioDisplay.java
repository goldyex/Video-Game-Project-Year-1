
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class ScenarioDisplay extends JFrame
{
	public static ImageIcon firstImg;
	public static JLabel image;	
	public int i = 0;
	public static String imgLocation="D:/Idan/OOPcodes/Photos/Open2.png";;
	
	
     public ScenarioDisplay() {
          super("Display Scenario Image");

          Container container = getContentPane();
          container.setLayout( new FlowLayout() );
          //container.setLayout(null);
          
          //JButton btn = new JButton("change");

          firstImg = new ImageIcon(imgLocation);
          image = new JLabel(firstImg);
          container.add(image);
          

          setSize(400,400);
          setLocation(700,250);
          setVisible(true);
          
     }
     
     public static void ChangeImage(){
        image.removeAll(); 		
        firstImg = new ImageIcon(imgLocation);
        image.setIcon(firstImg);}
     public static void main( String args[] )
     {
          ScenarioDisplay application = new ScenarioDisplay();
          application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}