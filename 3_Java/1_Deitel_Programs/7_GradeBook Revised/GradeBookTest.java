// p. 228 GradeBookTest.java
// Creates  GradeBook object  using an array of grades.

public class GradeBookTest
{
    //main method begins program execution
    public static void main( String args[] )
    {
        // array of student grades
        int gradesArray[] = { 50, 25, 60, 66, 75, 80, 100, 15, 88, 88 };
        
        GradeBook myGradeBook = new GradeBook( "CS101 Introduction on how to understand women", gradesArray);
        myGradeBook.displayMessage();
        myGradeBook.processGrades();
    }// end of main
} // end of class GradeBookTest

