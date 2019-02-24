// p.328 HourlyEmployee.java

public class HourlyEmployee extends Employee
{

    //instance variables of subclass
    private double wage;
    private double hours;

    
    //five-argument constructor
    public HourlyEmployee( String first, String last, String ssn, double hourlyWage, double hourlyWorked)
    {
        super( first, last, ssn); //pass to Employee constructor
        setWage( hourlyWage ); //validate hourly wage
        setHours ( hourlyWorked ); // validate work hours
        
    } //end of five-argument constructor HourlyEmployee
    
    //set wage
    public void setWage( double hourlyWage )
    {
        wage = ( hourlyWage < 0.0) ? 0.0 : hourlyWage;
    }//end method hourlyWage
    
    //return wage
    
    public double getWage()
    {
        return wage;
    }//end method getWage
    
    //set hours worked
    public void setHours( double hoursWorked )
    {
        hours = ( ( hoursWorked >= 0.0 ) && ( hoursWorked <= 168.0 ) ) ? hoursWorked : 0.0;
    }// end method setHours
    
    //return hours worked
    public double getHours()
    {
        return hours;
    }//end method getHours
    
    //calculate earnings; override abstract method earnings in Employee
    public double earnings()
    {
        if ( getHours() <= 40 )// no overtime
            return getWage() * getHours();
        else
            return 40 * getWage() + ( getHours() - 40 ) * getWage() * 1.5;
    }//end method earnings
    
    //return String representation of HourlyEmployee object
    public String toString()
    {
        return String.format( "hourly employee: %s\n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours() );
    }
    
} //end class HourlyEmployee
