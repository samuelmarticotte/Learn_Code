/*To compile: clang++ -std=c++11 -stdlib=libc++ 0_template.cpp  -o template
//#include <...> to include them in program */
//#include "apue.h" (include this file that is in the same folder in the program)


#include <iostream>
using namespace std;

//FOR COLORS
#define ANSI_COLOR_RED     "\x1b[31m"
#define ANSI_COLOR_GREEN   "\x1b[32m"
#define ANSI_COLOR_YELLOW  "\x1b[33m"
#define ANSI_COLOR_BLUE    "\x1b[34m"
#define ANSI_COLOR_MAGENTA "\x1b[35m"
#define ANSI_COLOR_CYAN    "\x1b[36m"
#define ANSI_COLOR_RESET   "\x1b[0m"

void welcome_message( char *argv[]);
void goodbye_message();
void sep(); //separateur
void list_types();
void show_menu();
void function_1();
void function_2();
void function_3();
void function_4();
void function_5();
void function_6();
void function_7();
void function_8();
void function_9();
void function_10();


int main(int argc, char *argv[] )
{
	welcome_message(argv); //prints the name of the program
	show_menu();


}

void welcome_message( char *argv[]){
    std::cout << ANSI_COLOR_RED;
    std::cout << "\n******************************************************\n";
    printf("===================Welcome to %s===============\n", argv[0]);
    std::cout << "******************************************************\n";
    std::cout << ANSI_COLOR_GREEN;
}//end method welcome message

void sep(){
	std::cout << "============================================";
}

void goodbye_message() {
    std::cout << ANSI_COLOR_RED;
    std::cout << "\n******************************************************\n";
    std::cout << "=========================Good bye=====================\n";
    std::cout << "******************************************************\n";
    std::cout << ANSI_COLOR_RESET;
    exit(0);
}

void show_menu(){
	int option = 1; //default value
	while( option != 0)
	{
	std::cout << "\n===========MENU===========\n";
	std::cout << "Option 1: \n";
	std::cout << "Option 2: \n";
	std::cout << "Option 3: \n";
	std::cout << "Option 4: \n";
	std::cout << "Option 5: \n";
	std::cout << "Option 6: \n";
	std::cout << "Option 7: \n";
	std::cout << "Option 8: \n";
	std::cout << "Option 9: \n";
	std::cout << "Option 10: \n";
	std::cout << "\nExit: 0";
	std:cout << "\nEnter an option: ";
	cin >> option;
	    switch (option)
        {
            case 1: 
            function_1();
            break;
            case 2:
            function_2();
            break;
            case 3:
            function_3();
            break;
            case 4:
            function_4();
            break;
            case 5:
            function_5();
            break;
            case 6:
            function_6();
            break;
            case 7:
            function_7();
            break;
            case 8:
            function_8();
            break;
            case 9:
            function_9();
            break;
            case 10:
            function_10();
            break;
            
            case 0: //0 exists the program
            exit(0);
            default: 
            cout <<  "Option " << option << "  is not available" << endl;
        }//end switch
    }//end while not 0
}

void function_1(){
	std::cout << "Hello from function 1";

}

void function_2(){
	std::cout << "Hello from function 2";

}

void function_3(){
	std::cout << "Hello from function 3";

}

void function_4(){
	std::cout << "Hello from function 4";

}

void function_5(){
	std::cout << "Hello from function 5";

}

void function_6(){
	std::cout << "Hello from function 6";

}

void function_7(){
	std::cout << "Hello from function 7";

}

void function_8(){
	std::cout << "Hello from function 8";

}

void function_9(){
	std::cout << "Hello from function 9";

}

void function_10(){
	std::cout << "Hello from function 10";

}