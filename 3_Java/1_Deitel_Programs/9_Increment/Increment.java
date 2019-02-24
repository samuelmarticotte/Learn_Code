// p.280
//final instance variable in a class

public class Increment
{
    private int total = 0;
    private final int INCREMENT; // constant variable (unitialized)
    
    //constructor initializes final instance variable INCREMENT
    public Increment( int incrementValue )
    {
        INCREMENT = incrementValue; // initializes constant variable (once)
    } //end Increment constructor
    
    //add INCREMENT to total
    public void addIncrementToTotal()
    {
        total += INCREMENT;
    }//end method addIncrementTotal
    
    //return String representation of an Increment object's data
    public String toString()
    {
        return String.format( "total = %d", total );
        
    } // end method toString
    
} // end class Increment
