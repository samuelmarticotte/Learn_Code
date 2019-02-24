//p.424
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame
{
    private JPanel mousePanel; // panel in which mouse events will occur
    private JLabel statusBar; // label that displays event information
    
    //MouseTrackerFrame constructor sets up GUI and registers mouse event handlers
    
    public MouseTrackerFrame()
    {
        super( "Demonstrating Mouse Events" );
        
        mousePanel = new JPanel(); //create panel
        mousePanel.setBackground( Color.white ); //set background color
        add( mousePanel, BorderLayout.CENTER ); //add panel to JFrame
        
        statusBar = new JLabel( "Mouse outside of panel" );
        add( statusBar, BorderLayout.SOUTH ); //add label to JFrame
        
        //create and register listener for mouse and mouse motion events
        
        MouseHandler handler = new MouseHandler();
        mousePanel.addMouseListener( handler );
        mousePanel.addMouseMotionListener( handler );
        
    }//end constructor MouseTrackerFrame
    
    private class MouseHandler implements MouseListener, MouseMotionListener
    {
        //Mouse listener event handlers
        //handle event when mouse released immediately after press
        
        public void mouseClicked( MouseEvent event )
        {
            statusBar.setText( String.format("Clicked at [%d, %d]", event.getX(), event.getY() ) );
            
        }//end method mouseClicked
        
        public void mousePressed( MouseEvent event )
        {
            statusBar.setText( String.format( "Pressed at [%d, %d]", event.getX(), event.getY() ) );
            
        } //end method mousePressed
        
        public void mouseReleased( MouseEvent event )
        {
            statusBar.setText( String.format( "Released at [%d, %d]", event.getX(), event.getY() ) );
            
        } //end method mouseReleased
        
        public void mouseEntered( MouseEvent event )
        {
        statusBar.setText( String.format( "Mouse entered at [%d, %d]", event.getX(), event.getY() ) );
            
        } //end method mouseEntered
        
        public void mouseExited( MouseEvent event )
        {
            statusBar.setText( String.format( "Exited at [%d, %d]", event.getX(), event.getY() ) );
            
        } //end method mouseExited
        
        public void mouseDragged( MouseEvent event )
        {
        statusBar.setText( String.format( "Dragged at [%d, %d]", event.getX(), event.getY() ) );
            
        } //end method mouseDragged
        
        public void mouseMoved( MouseEvent event )
        {
            statusBar.setText( String.format( "Moved at [%d, %d]", event.getX(), event.getY() ) );
            
        } //end method mouseMoved
        
    }//end inner class MouseHandler
    
}// end class MouseTrackerFrame
