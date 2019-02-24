//p. 281 IncrementTest.java

public class IncrementTest
{
    public static void main( String args[] )
    {
        Increment value = new Increment( 5);

        System.out.printf( "Before incrementing: %s\n\n", value );

        for ( int i = 1; i <=  3; i++ )
        {
            value.addIncrementToTotal();
            System.out.printf( "After increment %d: %s\n", i, value );
        }// end for
   
    }// end main

} // end class
