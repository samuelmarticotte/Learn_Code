//ReadServerFile.java

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.JFrame;


public class ReadServerFile extends JFrame
{
    private JTextField enterField; //JTextfield to enter site names
    private JEditorPane contentsArea; //to display website
    
    //set-up GUI
    public ReadServerFile()
    {
        super( "Bonjour Marie" );
        
        //create enterField and register its listener
        enterField = new JTextField( "Enter file URL here" );
        enterField.addActionListener(
            new ActionListener()
            {
                //get document specified by user
                public void actionPerformed( ActionEvent event )
                {
                    getThePage( event.getActionCommand() );
                } //end method actionPerformed
            }//end inner class
        );
        
        add( enterField, BorderLayout.NORTH );
        
        contentsArea = new JEditorPane(); //create contentsArea
        contentsArea.setEditable( false );
        contentsArea.addHyperlinkListener(
            new HyperlinkListener()
            {
                //if user clicked hyperlink, go to specified page
                public void hyperlinkUpdate( HyperlinkEvent event )
                {
                    if ( event.getEventType() == HyperlinkEvent.EventType.ACTIVATED )
                        getThePage( event.getURL().toString() );
                }//end method hyperLinkUpdate
            }//end inner class
        ); //end addHyperLinkListener
        
        add( new JScrollPane( contentsArea ), BorderLayout.CENTER );
        setSize( 400, 300 ); //
        setVisible( true ); //show window
    }//end constructor ReadServerFile
    
    //load document
    private void getThePage( String location )
    {
        try
        {
            contentsArea.setPage( location ); //set the page
            enterField.setText( location ); //set the text
        }//end try
        catch( IOException ex )
        {
            JOptionPane.showMessageDialog( this, "Error retrieving specified URL", "Bad Url", JOptionPane.ERROR_MESSAGE );
        }//end catch
        
    }//end method getThePage


}// end class ReadServerFile
