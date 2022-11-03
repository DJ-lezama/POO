import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Desktop extends JFrame
{
    private JDesktopPane theDesktop;

    // set up GUI11
  public Desktop()    
  {    
    super( "Desktop");       
    // create menu bar, menu and menu item    
    JMenuBar bar = new JMenuBar();    
    JMenu beginMenu = new JMenu( "Begin Game");   
    JMenuItem newFrame = new JMenuItem( "Start");
    JMenuItem credits = new JMenuItem("Credits");
    JMenuItem instructions = new JMenuItem("Instructions");
    beginMenu.add( newFrame ); 
    beginMenu.add(instructions);  
    beginMenu.add(credits);
    bar.add( beginMenu );    
    setJMenuBar( bar );       
    // set up desktop
    ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
    Image image = icon.getImage();
    
    theDesktop = new JDesktopPane()
    {
      public void paintComponent(Graphics g)
      {
        g.drawImage(image, 0,0, getWidth(), getHeight(), this);
      }
    };
    getContentPane().add( theDesktop );
    // set up listener for newFrame menu item    
    newFrame.addActionListener( new ActionListener() 
    {
      // anonymous inner class33
      // display new internal window
      public void actionPerformed( ActionEvent event ) 
      {    
        // create internal frame   
        //JInternalFrame frame = new JInternalFrame( "Internal Frame", true, true, true, true);

        //llamar al internal frame
        PlayerTurnsInternalFrame newTurn = new PlayerTurnsInternalFrame();      
        // attach panel to internal frame content pane   
        newTurn.pack();  
        //newTablero.pack(); 
        theDesktop.add( newTurn );  
        //theDesktop.add(newTablero);   
        newTurn.setVisible( true);
        
        //newTablero.setVisible(true);
      }   
    } ); // end anonymous inner class

    instructions.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event2)
      {
        JOptionPane.showMessageDialog(null, "Try to build a row of four checkers (horizontally, vertically or diagonally) while keeping your opponent from doing the same. The turns will be alternating.\n On the screen you'll see buttons with the letter 'A' which means they are available, and some in black with the letter 'U' which means they are unavailable, more buttons will become available as you play.");
      }

    });

    credits.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event2)
      {
        JOptionPane.showMessageDialog(null, "Andrea Lima y Dicka Lezama :)");
      }

    });

     // end call to addActionListener
     setSize( 600, 460);    
     setVisible( true);        
  } // end constructor
 

  public static void main( String args[] )    
  {         
    Desktop application = new Desktop();    
    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);    
  } // end class DesktopTest
  // class to display an ImageIcon on a panel
}
   
  