//GridLayout.java

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GridLayoutFrame extends JFrame implements ActionListener
{
    private JButton buttons[]; //array of buttons
    private final String names[] = { "one", "two", "three", "four", "five", "six" };
    private boolean toggle = true; //toggle between two layouts
    private Container container; //frame container
    
    private GridLayout gridLayout1; //firt gridLayout
    private GridLayout gridLayout2; //seond gridLayout
    
    public GridLayoutFrame()
    {
        super( "GridLayout Demo" );
        gridLayout1 = new GridLayout( 2, 3, 5, 5 ); //2 by 3; gaps of 5
        gridLayout2 = new GridLayout( 3, 2 ); //3 by 3; no gaps
        container = getContentPane(); //get content pane
        setLayout( gridLayout1 ); //set layout
        buttons = new JButton[ names.length ]; //create array of buttons
        
        for ( int count = 0; count < names.length; count++ )
        {
            buttons[ count ] = new JButton( names[ count ] );
            buttons[ count ].addActionListener( this );

            add( buttons[ count ] );//add button to JFrame
            
        }//end for
        
    }//end constructor GridLayoutFrame
    
    public void actionPerformed( ActionEvent event)
    {
        if( toggle )
            container.setLayout( gridLayout2 ); //set layout to second
        else
            container.setLayout( gridLayout1 );// set layout to first
        
        toggle = !toggle; //set toggle to opposite value
        container.validate(); //re-lay out container
        
    }//end method actionPerformed
    
}//end class GridLayoutFrame
