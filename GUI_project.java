
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class GUI_project extends JFrame {
    public static String TextFieldAnswer1="";
    public static int Stopper1=0;
        
    
    private JMenuBar menuBar;
    private JTextArea APCshow;
    private JTextArea EnzoShow;
    private JTextArea SilentShow;
    private JTextArea TechShow;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField imageShower;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    //Constructor 
    public GUI_project(Assassins warrior, Assassins tech, Assassins silent, String ACRtxt, boolean vsble){
        
    
        this.setTitle("GUI_project");
        this.setSize(650,700);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(650,700));
        contentPane.setBackground(new Color(171,152,152));


        APCshow = new JTextArea();
        APCshow.setBounds(321,114,299,500);
        APCshow.setBackground(new Color(255,255,255));
        APCshow.setForeground(new Color(0,0,0));
        APCshow.setEnabled(true);
        APCshow.setFont(new Font("Monospaced",0,10));
        APCshow.setText("Advance Program Replay \nHere you can update in real-time what just happened in your journey! \nAll you have to do is press the UPDATE button!");
        APCshow.setBorder(BorderFactory.createBevelBorder(1));
        APCshow.setVisible(true);
        
        //***************************************************************************
        APCshow.addKeyListener(new KeyListener() {            
        public void keyTyped(KeyEvent e) {
            //      
        }

        @Override
         public void keyPressed(KeyEvent e) {
            System.out.println("test");
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                APCshow.setText(StartGame.APCtxt);
                System.out.println("Enter is pressed");
        }
    }
        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub      
        }
    });

    //********************************************************
    
        
        JTextField testField = new JTextField(10);
        testField.setBounds(100,450,150,100);
        testField.setBackground(new Color(255,255,255));
        testField.setForeground(new Color(0,0,0));
        testField.setEnabled(true);
        testField.setFont(new Font("Serif",0,10));
        testField.setText("TYPE ANSWERS HERE");
        testField.setVisible(true);
        testField.addKeyListener(new KeyListener() {            
                public void keyTyped(KeyEvent e) {
                      
                }
        
                
                        @Override
                public void keyPressed(KeyEvent e) {
                   if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                        TextFieldAnswer1 = testField.getText();
                        Stopper1=1;
                        testField.setText("");
                        
                }
            }
                @Override
                public void keyReleased(KeyEvent e) {
                    // TODO Auto-generated method stub      
                }
            }); 
    
        EnzoShow = new JTextArea();
        EnzoShow.setBounds(5,108,150,100);
        EnzoShow.setBackground(new Color(255,255,255));
        EnzoShow.setForeground(new Color(0,0,0));
        EnzoShow.setEnabled(true);
        EnzoShow.setFont(new Font("Serif",0,10));
        EnzoShow.setText("Enzo the Hand-to-Hand Specialist: \n Health Points:" + warrior.getHP() + "\n Damage Points: " + warrior.getDmg()+ "\n Accuracy Chance: "+ warrior.getAcc() 
        + "% \n Carrying Capacity: " + warrior.getMaxCapacity() + "\n Evading Chance: " +warrior.getEvadeChance()+"%");
        EnzoShow.setBorder(BorderFactory.createBevelBorder(1));
        EnzoShow.setVisible(true);

        SilentShow = new JTextArea();
        SilentShow.setBounds(5,212,150,100);
        SilentShow.setBackground(new Color(255,255,255));
        SilentShow.setForeground(new Color(0,0,0));
        SilentShow.setEnabled(true);
        SilentShow.setFont(new Font("Serif",0,10));
        SilentShow.setText("Hibana the Stealth Specialist: \n Health Points:" + silent.getHP() + "\n Damage Points: " + silent.getDmg()+ "\n Accuracy Chance: "+ silent.getAcc() 
        + "% \n Carrying Capacity: " + silent.getMaxCapacity() + "\n Evading Chance: " +warrior.getEvadeChance()+"%");
        SilentShow.setBorder(BorderFactory.createBevelBorder(1));
        SilentShow.setVisible(true);

        TechShow = new JTextArea();
        TechShow.setBounds(161,109,150,100);
        TechShow.setBackground(new Color(255,255,255));
        TechShow.setForeground(new Color(0,0,0));
        TechShow.setEnabled(true);
        TechShow.setFont(new Font("Serif",0,10));
        TechShow.setText("Roberto the Gadgets Specialist : \n Health Points:" + tech.getHP() + "\n Damage Points: " + tech.getDmg()+ "\n Accuracy Chance: "+ tech.getAcc() 
        + "% \n Carrying Capacity: " + tech.getMaxCapacity() + "\n Evading Chance: " +tech.getEvadeChance()+"%");
        TechShow.setBorder(BorderFactory.createBevelBorder(1));
        TechShow.setVisible(true);

        button1 = new JButton();
        button1.setBounds(307,55,7,342);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("");
        button1.setVisible(true);

        button2 = new JButton();
        button2.setBounds(5,53,622,14);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("");
        button2.setVisible(true);
        
        button3 = new JButton();
        button3.setBounds(161,212,150,100);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("Update");
        button3.setVisible(true);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                APCshow.setText(StartGame.APCtxt);
                ScenarioDisplay.ChangeImage();
            }
        });
        
       

        try
        {
         final BufferedImage image = ImageIO.read(new File("/D:/Idan/OOPcodes/Photos/AssassinsFinalMini.png"));
         imageShower = new JTextField(){
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int centerPoint = (getHeight() - image.getHeight())/2;
            g.drawImage(image, 0, centerPoint, this);
        }
    }; 
    } 
    catch (IOException e)
    {
      // log the exception
      // re-throw if desired
    }
  
        imageShower.setBounds(69,313,179,80);
        imageShower.setBackground(new Color(255,255,255));
        imageShower.setForeground(new Color(0,0,0));
        imageShower.setEnabled(true);
        imageShower.setFont(new Font("sansserif",0,12));
        imageShower.setText("");
        imageShower.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(17,6,599,37);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,102));
        label1.setEnabled(true);
        label1.setFont(new Font("Serif",0,48));
        label1.setText("Assassins Creed Resurrection");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(25,70,282,37);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("Monospaced",0,18));
        label2.setText("Character Information");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(414,81,132,23);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("Monospaced",0,32));
        label3.setText("A.C.R."); //Advanced Combat Replay
        label3.setVisible(true);
        

        //adding components to contentPane panel
        contentPane.add(APCshow);
        contentPane.add(EnzoShow);
        contentPane.add(SilentShow);
        contentPane.add(TechShow);
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(imageShower);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(testField);


        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(10,150);
        this.pack();
        this.setVisible(vsble);
        
        
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");


        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }



     

}