//p. 426 MouseTrackerTest.java

import javax.swing.JFrame;

public class MouseTrackerTest
{
    public static void main( String args[] )
    {
        MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
        mouseTrackerFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mouseTrackerFrame.setSize( 400, 200 );
        mouseTrackerFrame.setVisible( true );
        
    }//end main method
    
}//end class MouseTrackerTest
