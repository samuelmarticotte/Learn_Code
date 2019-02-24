//BlockingBufferTest.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingBufferTest
{
	public BlockingBufferTest()
	{
	
	}//end constructor BlockingBufferTest

	public static void main ( String args[] )
	{
        System.out.printf("\n****************************************");
        System.out.printf("\n-----Welcome to BlockingBufferTest:------\n\n");
        
        //create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();
        
        //¢reate BlockingBuffer to store ints
        Buffer sharedLocation = new BlockingBuffer();
        
        application.execute( new Producer( sharedLocation ) );
        application.execute( new Consumer( sharedLocation ) );
        
        application.shutdown();
        

        System.out.printf("\n-----Bye from BlockingBufferTest:------");
        System.out.printf("\n****************************************\n");
	}//end main

}// end class BlockingBufferTest
