//p. 404

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame
{
    private JButton plainJButton; //button with just text
    private JButton fancyJButton; //button with icons
    //
    
    //Button frame adds JButtons to JFrame
    public ButtonFrame()
    {
        super("Testing Buttons" );
        setLayout( new FlowLayout() ); //set frame layout
        
        plainJButton = new JButton("Plain button" ); //button with text
        add( plainJButton ); //add plainJbutton to JFrame
    
        Icon bug1 = new ImageIcon( getClass().getResource("bug1.gif") );
        Icon bug2 = new ImageIcon( getClass().getResource("bug2.gif") );
        fancyJButton = new JButton ("Fancy Button", bug1); // set image
        add ( fancyJButton ); //add fancyJButton to Jframe
        
        
        // create an instance of inner class ButtonHandler
        
        // to use for button event handling
        
        ButtonHandler handler = new ButtonHandler();
        
        fancyJButton.addActionListener( handler );
        
        plainJButton.addActionListener( handler );
        
    }//end Button Frame constructor
    
    //inner class for button event handling
    private class ButtonHandler implements ActionListener
    {
        //handle button event
        public void actionPerformed( ActionEvent event )
        {
            JOptionPane.showMessageDialog( ButtonFrame.this, String.format("You pressed: %s", event.getActionCommand()) );
                                    
        }// end method action performed
    }//end private inner class ButtonHandler
    
}// end class ButtonFrame
