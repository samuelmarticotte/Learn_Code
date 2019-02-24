//Producer.java

import java.util.Random;

public class Producer implements Runnable
{
    private final static Random generator = new Random();
    private final Buffer sharedLocation; //reference to shared object
    
    //constructor
    public Producer( Buffer shared )
    {
        sharedLocation = shared;
    }//end constructor Producer
    
    //store values from 1 to 10 in sharedLocation
    public void run()
    {
        int sum = 0;
        
        for ( int count = 1; count <= 10; count++ )
        {
            try
            {
                Thread.sleep( generator.nextInt( 3000 ) );
                sharedLocation.set( count ); //set value in buffer
                sum += count; //increment sum of values
                //System.out.printf( "\t\t\t%2d\n", sum );
                
            }//end try
            catch( InterruptedException exception )
            {
                exception.printStackTrace();
            }//end catch
        }//end for
        
        System.out.println( "Producer done producing\nTerminating Producer" );
    }//end run

}// end class Producer
