//UsingToArrays.java

import java.util.LinkedList;
import java.util.Arrays;

public class UsingToArrays
{
    //constructor creates LinkedList, adds elements and converts them to array
    
    public UsingToArrays()
    {
        String colors[] = { "black", "blue", "yellow" };
        
        LinkedList< String > links = new LinkedList< String >( Arrays.asList( colors ) );
        
        links.addLast("red" ); //add as last item
        links.add( "pink" ); //add to the end
        links.add( 3, "green" ); //add at 3rd index
        links.addFirst( "cyan" ); //add as first item
        
        //get LinkedList elements as an array of Strings
        colors = links.toArray( new String[ links.size() ] );
        
        System.out.println( "This is ")
        System.out.println( "colors: ");
        for ( String color : colors )
            System.out.println( color );

    }//end constructor UsingToArrays
    
    
	public static void main ( String args[] )
	{
        System.out.printf("----------------------------------------");
        System.out.printf("\n-----Welcome to X-----");
        System.out.printf("\n----------------------------------------\n");
        
        new UsingToArrays();
        
        System.out.printf("----------------------------------------");
        System.out.printf("\n-----Bye from X-----");
        System.out.printf("\n----------------------------------------\n");
	}//end main

}// end class UsingToArrays
