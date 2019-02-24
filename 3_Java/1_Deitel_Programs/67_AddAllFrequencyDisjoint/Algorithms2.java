//Algorithms2.java

import java.util.List;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;

public class Algorithms2
{
    private String[] colors = { "red", "white", "yellow", "blue" };
    private Vector< String > vector = new Vector< String >();
    private List< String > list;

    
    
    //¢reate list and Vector
    //and manipulate them with methods from Collections
    
    public Algorithms2()
    {
        //initialize list and vector
        list = Arrays.asList( colors );
        vector.add( "black" );
        vector.add( "red" );
        vector.add( "green" );
        
        System.out.println( "Before addAll, vector contains: " );
        
        //Display elements in vector
        for ( String s : vector )
            System.out.printf("%s ", s );
        
        //add elements in colors to list
        
        Collections.addAll( vector, colors );
        
        
        System.out.println( "\n\nAfter addAll, vectorcontains: " );
        
        //display elements in vector
        for ( String s : vector )
            System.out.printf( "%s ", s );
        
        //get Frequency of "red"
        
        int frequency = Collections.frequency( vector, "red" );
        System.out.printf( "\n\nFrequency of red in vector: %d\n", frequency );
        
        //check whether list and vector have elements in common
        
        boolean disjoint = Collections.disjoint( list, vector );
        
        System.out.printf( "\nlist and vector %s elements in common\n", (disjoint ? "do not have" : "have" ) );
        
    }//end public constructor Algorithms2
    
        
    public static void main ( String args[] )
    {
        System.out.printf("----------------------------------------");
        System.out.printf("\n-----Welcome to Algorithms2:------ ");
        System.out.printf("\n----------------------------------------\n");
        
        new Algorithms2();
        
        System.out.printf("----------------------------------------");
        System.out.printf("\n-----------Bye from Algorithms2: ");
        System.out.printf("\n----------------------------------------\n");
	}//end main

}// end class Algorithms2
