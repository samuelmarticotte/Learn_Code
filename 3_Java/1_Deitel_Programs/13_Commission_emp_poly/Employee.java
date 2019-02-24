// p.328 Commission Employee.java

public abstract class Employee 
{
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    
    //three-argument constructor
    public Employee( String first, String last, String ssn)
    {
        //implicit call to Object constructor occurs here
        firstName = first;
        lastName = last;
        socialSecurityNumber = ssn;
    } //end constructor Empoyee
    
    
    //set first name
    public void setFirstName( String first)
    {
        firstName = first;
    }//end method setFirstName
    
    public String getFirstName()
    {
        return firstName;
    }//end method getFirstName
    
    public void setLastName( String last )
    {
        lastName = last;
    }//end method setLastName
    
    public String getLastName()
    {
        return lastName;
    }
    
    //set social security number
    public void setSocialSecurityNumber( String ssn )
    {
        socialSecurityNumber = ssn; //should validate
    }//end method setSocialSecurityNumber
    
    //return socialSecurityNumber
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }//end method getSocialSecurityNumber

    //return String representation of employee
    public String toString()
    {
        return String.format( "%s %s\nSocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber() );
    }//end method toString
    
    //abstract method overriden by subclasses
    public abstract double earnings(); // no implementation here, implementation in subclasses. This class is abstract and this method polymorphic.
    
}// end class Employee.java
