//p. 224 GradeBook.java
// Grade book using an array to store test grades

public class GradeBook {

    private String courseName; //name of course (field)
    private int grades[]; //array of student grades (field)

    //two-argument constructor initializes courseName and grades array (to create the object)
    public GradeBook( String name, int gradesArray[])
    {
        courseName = name; //(initialize field object)
        grades = gradesArray; //(initializes field array of object)
    } // end of two-argument constructor
    
    //method to set the course name
    public void setCourseName( String name)
    {
        courseName = name;
    } // end of setCourseName
    
    //method to retrieve the course name
    public String getCourseName()
    {
        return courseName;
    }// end of method getCourseName
    
    //display a welcome message to the GradeBook User
    public void displayMessage()
    {
        //getCourseName gets the name of the course
        System.out.printf( "Welcome to the grade book for\n%s!\n\n",getCourseName());
    } //end of displayMessage
    
    //perform various operations on the data
    public void processGrades()
    {
        //output grade arrays
        outputGrades();
        
        //call method getAverage to calculate the average grade
        System.out.printf( "\nClass average is %.2f\n", getAverage());
        
        //call method getMinimum and getMaximum
        System.out.printf( "Lowest grade is %d\nHighest grade is %d\n\n", getMinimum(), getMaximum());
    
    } // end of method processGrades
    
    public int getMinimum()
    {
        int lowGrade = grades [ 0 ]; // assume grades[ 0 ] is smallest
        
        //loop through grades array
        for ( int grade : grades )
        {
            //if grade lower than lowGrade, assign it to lowGrade
            if (grade < lowGrade )
                lowGrade = grade; //new lowest grade
        } //end for
        
        return lowGrade;
            
    } // end method getMinimum
    
    //find maximum grade
    public int getMaximum()
    {
        int highGrade = grades[ 0 ]; //assume that grades [  0 ] is the largest
        
        // loop through grade arrays
        for ( int grade : grades )
        {
            //if grade greather than highGrade, assign it to highGrade
            if ( grade > highGrade )
                highGrade = grade; // new highest grade
            
        }//end for
        return highGrade;
    } // end of get Maximum
    
    //determine average grade for test
    public double getAverage()
    {
        int total = 0; //initialize total
        
        //sum grades for one student (grades is the array), grade is the value of for each element
        for ( int grade : grades )
            total += grade;
        
        //return average of grades
        return (double) total / grades.length; //(we cast because total is an integer)
        
    } //end of method getAverage
    
    public void outputBarChart()
    {
        System.out.println(" Grade distribution:" );
        
        //stores frequency of grades in each range of 10 grades
        int frequency[] = new int[ 11 ];
        
        //for each grade, increment the appropriate frequency
        for ( int grade : grades )
            ++frequency[ grade / 10 ];
        
        //for each grade frequency, print bar in chart
        for (int count = 0; count < frequency.length; count++ )
        {
            // output bar label ("00-09:", ..., "90-99:")
            if ( count == 10 )
                System.out.printf( "%5d: ", 100 );
            else
               System.out.printf( "%02d-%02d: ", count * 10, count * 10 + 9);
            
            //print bar of asterisks
            
            for ( int stars = 0; stars < frequency[ count ]; stars++ )
                System.out.print("*");
    
            System.out.println(); //start a new line of output
        }//end of outer for
    
    }//end of ouputBarChart

    // output the contents of the grades array
    public void outputGrades()
    {
        System.out.println( "The grades are: \n" );
                           
        //output for each student's grade
        for ( int student = 0; student < grades.length; student++ )
            System.out.printf("Student %2d: %3d\n", student + 1, grades [student ] );
                           
    } // end of method outputGrades
    
}// end of class GradeBook.java
