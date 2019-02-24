// p. 330 BasePlusCommissionEmployee.java

public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary; //base salary per week
    
    //six-argument construtor
    public BasePlusCommissionEmployee( String first, String last, String ssn, double sales, double rate, double salary )
    {
    super( first, last, ssn, sales, rate ); //call constructor of superclass and initialize inherited instances variables
    setBaseSalary( salary ); //validate and store base salary
    }//end six-argument constructor BasePlusCommissionEmployee
    
    //set base salary
    public void setBaseSalary( double salary)
    {
        baseSalary  = ( salary < 0.0 ) ? 0.0 : salary;
    } //end method setBaseSalary
    
    //return base salary
    public double getBaseSalary()
    {
        return baseSalary;
    }//end method getBaseSalary
    
    //calculate earnings overrides method of superclass
    public double earnings()
    {
        return getBaseSalary() + super.earnings();
    }// end method earnings

    public String toString()
    {
        return String.format(" %s %s\n%s: %,.2f", "base salaried", super.toString(), "baseSalary", getBaseSalary() );
    }//end method toString
    
    
}//end class BasePlusCommissionEmployee
