//PriorityQueueTest.java

import java.util.PriorityQueue;

public class PriorityQueueTest
{

    
    public PriorityQueueTest()
	{
        //queue of capacity 11
        PriorityQueue< Double > queue = new PriorityQueue< Double >();
        
        //inserts elements into queue
        queue.offer( 3.2 );
        queue.offer( 9.8 );
        queue.offer( 5.4 );
        
        System.out.print( "Polling from queue: " );
        //display elements in queue
        while ( queue.size() > 0 )
        {
            System.out.printf( "%.1f ", queue.peek() ); // view top element
            queue.poll(); //remove top element
            
        }//end while
        System.out.println ("");
        
    }//end constructor

	public static void main ( String args[] )
	{
        System.out.printf("\n****************************************");
        System.out.printf("\n-----Welcome to PriorityQueueTest:------\n\n");

        
        new PriorityQueueTest();
        
        System.out.printf("\n-----Bye from PriorityQueueTest: ");
        System.out.printf("\n****************************************\n");
	}//end main

}// end class PriorityQueueTest
