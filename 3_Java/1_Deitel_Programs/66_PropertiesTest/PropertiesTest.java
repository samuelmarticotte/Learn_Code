//PropertiesTest.java

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest
{
    private Properties table;
    
	public PropertiesTest()
	{
        table = new Properties(); //create properties table
        
        //set properties
        table.setProperty( "color", "blue" );
        table.setProperty( "width", "200" );
        
        System.out.println( "After setting properties" );
        listProperties(); //display property values
        
        //replace property value
        table.setProperty( "color", "red" );
        
        System.out.println( "After replacing properties" );
        listProperties(); //display properties value
        saveProperties();
        table.clear();
        
        System.out.println( "After clearing properties" );
        listProperties(); //display property values
        
        loadProperties(); //load properties
        
        //get value of property color
        Object value = table.getProperty( "color" );
        
        //¢heck if value is in table
        if ( value != null )
            System.out.printf( "Property's color value is %s\n", value );
        else
            System.out.println( "Property color is not in table" );
        
	}//end constructor PropertiesTest
    
    public void saveProperties()
    {
        //save contents of table
        try
        {
            FileOutputStream output = new FileOutputStream( "props.dat" );
            table.store( output, "Sample Properties" ); //save properties
            output.close();
            System.out.println( "After saving properties" );
            listProperties();
        }//end try
        catch( IOException ioException )
        {
            ioException.printStackTrace();
        }//end catch
        
    }//end method saveProperties
    
    public void loadProperties()
    {
        //load contents of table
        try
        {
            FileInputStream input = new FileInputStream( "props.dat" );
            table.load( input ); // load properties
            input.close();
            System.out.println( "After loading properties" );
            listProperties();
        }//end try
        catch( IOException ioException )
        {
            ioException.printStackTrace();
        }//end catch
        
    }//end method loadProperties
    
    public void listProperties()
    {
        //output properties of values
        Set< Object > keys = table.keySet(); //get property names
        
        if ( keys.isEmpty() )
        {
            System.out.println( "No keys found in the table\n");
        }
        else
        {
            //output name/value key pairs
            for ( Object key : keys )
            {
                System.out.printf( "%s\t%s\n", key, table.getProperty( ( String ) key ) );
            }//end for
            System.out.println();
        }
    
    }//end method listProperties

	public static void main ( String args[] )
	{
        System.out.printf("\n****************************************");
        System.out.printf("\n-----Welcome to PropertiesTest:------\n\n");
        
        new PropertiesTest();
        
        System.out.printf("\n-----Bye from PropertiesTest:------");
        System.out.printf("\n****************************************\n");
	}//end main

}// end class PropertiesTest
