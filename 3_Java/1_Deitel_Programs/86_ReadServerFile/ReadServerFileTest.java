//ReadServerFileTest.java

import javax.swing.JFrame;

public class ReadServerFileTest extends JFrame
{
	public ReadServerFileTest()
	{
	
	}//end constructor ReadServerFileTest

	public static void main ( String args[] )
	{
        System.out.printf("\n****************************************");
        System.out.printf("\n-----Welcome to ReadServerFileTest:------\n\n");
        
        ReadServerFile application = new ReadServerFile();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    
        System.out.printf("\n-----Bye from ReadServerFileTest:------");
        System.out.printf("\n****************************************\n");
	}//end main

}// end class ReadServerFileTest
