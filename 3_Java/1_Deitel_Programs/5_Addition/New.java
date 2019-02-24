// To compile: javac Helloworld
// To execute: java Helloworld

import java.util.Scanner; //class Scanner

public class New
{

	public static void main( String args[] )
	{
	System.out.printf( "%s\n%s\n", "Welcome to", "Java Programming!" );
	
		if (args[0] != "")
		{
			System.out.printf (args[0] + "\n");
		}
		
		Scanner input = new Scanner( System.in );
		
		int number1;
		int number2;
		int sum;
		
		System.out.print("Enter first integer: ");
		number1 = input.nextInt();
		System.out.print("Enter second integer: ");
		number2 = input.nextInt();
		
		sum = number1 + number2; //Add num1 and num2
		
		System.out.printf("The total sum is %d\n", sum ); //Display sum		System.out.printf("The total sum is %d\n", sum ); //Display sum
		
	} // End of main function
	

} // End of Hello_world class