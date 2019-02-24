//Sort1.java

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Sort1
{
    private static final String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
    
    //display array elements
    public void printElements()
    {
        List< String > list = Arrays.asList( suits ); //create list
        
        //output list
        System.out.printf( "Unsorted array elements: \n%s\n", list );
        
        Collections.sort( list ); //sort array list
        
        //output list
        System.out.printf( "Sorted array elements:\n%s\n", list );
        
    }//end method printElements
    
    
    
	public static void main ( String args[] )
	{
        System.out.printf("----------------------------------------");
        System.out.printf("\n--------Welcome to Sort1:");
        System.out.printf("\n----------------------------------------\n");
        
        Sort1 sort1 = new Sort1();
        sort1.printElements();
        
        System.out.printf("----------------------------------------");
        System.out.printf("\n--------Bye from Sort1:");
        System.out.printf("\n----------------------------------------\n");
	}//end main

}// end class Sort1
