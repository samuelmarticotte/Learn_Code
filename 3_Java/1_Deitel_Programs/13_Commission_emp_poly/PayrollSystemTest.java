// p.355 PayrollSystemTest.java
//Employee hierarchy test program

public class PayrollSystemTest
{
    public static void main ( String args[] )
    {
        //create subclass objects
        
        SalariedEmployee salariedEmployee = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
        
        HourlyEmployee hourlyEmployee = new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
        
        CommissionEmployee commissionEmployee = new CommissionEmployee( "Sue", "Jones", "333-33-3333", 10000, .06);
        
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee( "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );
        
        
        System.out.printf( "%s\n%s: $%,.2f\n\n", salariedEmployee, "earned", salariedEmployee.earnings() );
        
        System.out.printf( "%s\n%s: $%,.2f\n\n", hourlyEmployee, "earned", hourlyEmployee.earnings() );
        
        System.out.printf( "%s\n%s: $%,.2f\n\n", commissionEmployee , "earned", commissionEmployee.earnings() );
        
        System.out.printf( "%s\n%s: $%,.2f\n\n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
        
        //create four element Employee array
        Employee employees[] = new Employee[ 4 ];
    
        
        //initialize array with employees
        
        employees[ 0 ] = salariedEmployee;
        employees[ 1 ] = hourlyEmployee;
        employees[ 2 ] = commissionEmployee;
        employees[ 3 ] = basePlusCommissionEmployee;

        
        System.out.printf( "Employee processed polymorphically:\n" );
        
        //Employee is the type, currentEmployee is the "i", the current variable replaced, employees is the array passe
        for ( Employee currentEmployee: employees)
            
        {
            System.out.println( currentEmployee ); //invokes toString
        
        //determine whether element is a type/object? BasePlusCommisionEmployee
            if ( currentEmployee instanceof BasePlusCommissionEmployee )
            {
            //downcast Employee reference to BasePlusCommissionEmployee reference and declaring a new variable employee with assignment to currentEmp
            BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
        
            double oldBaseSalary = employee.getBaseSalary(); //getBaseSalary is a method of BasePLusCommissionEmployee subclass
            employee.setBaseSalary( 1.10 * oldBaseSalary );
            System.out.printf( "new base salary with 10%% increase is: $ %.2f\n", employee.getBaseSalary() );
            }//end if
            
            System.out.printf( "earned $%.2f\n\n", currentEmployee.earnings() );
            
        }//end for
        
        //get type name of each object in employees array
        for ( int j = 0; j < employees.length; j++ )
        {
            System.out.printf( "Employee %d is a %s\n", j, employees[ j ].getClass().getName() );
        }//end for
                              
    }//end main
                              
}//end class PayRollSystemTest
