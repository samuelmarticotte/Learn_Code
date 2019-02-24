; Example program to demonstrate console output to the screen
;************************************************************

section .data

;------
;Define standard constants.

LF	equ 10
NULL equ 0

TRUE equ 1
FALSE equ 0

EXIT_SUCCESS equ 0 ; success code

STDIN equ 0	 	; standard input
STDOUT equ 1	; standard output
STDERR equ 2	; standard error

SYS_read equ 0	; read
SYS_write equ 1	; write
SYS_open equ 2	; file open
SYS_close equ 3	; file close
SYS_fork equ 57	; fork process
SYS_exit equ 60	; terminate program
SYS_creat equ 85	; file open/create
SYS_time equ 201	; get time

;------
; Define some strings.

STRLEN equ 50

welcomeOne db   "******************************************************", NULL, LF
welcomeTwo db   "******Welcome to my first Assembly program1************", NULL, LF
welcomeThree db "******************************************************", NULL, LF

goodbyeOne db   "******************************************************", NULL, LF
goodbyeTwo db   "**********************GOOD BYE!***********************", NULL, LF
goodbyeThree db "******************************************************", NULL, LF

menu1 db "PROGRAM MENU: Choose an option", NULL, LF
menu2 db "1-Function1", NULL, LF
menu3 db "2-Function2", NULL, LF
menu4 db "3-Function3", NULL, LF
menu5 db "4-Function4", NULL, LF
menu6 db "5-Test_Function", NULL, LF
menu7 db "0-Exit program", NULL, LF

;---------------------------------------------------------------(functions data)

EXIT equ 48 ; option 0 exits program
func_max equ 5 ; number of active functions for menu
greaterThanMaxMessage db "Enter a number between 0 and 4", NULL, LF
ONE equ 49	; option 1 =(49 in ascii)
TWO equ 50 ; option 2 = (50 in ascii)
THREE equ 51 ; ...
FOUR equ 52 ; ...
FIVE equ 53 ; ...


oneMessage db "Welcome to function one!", NULL, LF
twoMessage db "Welcome to function two!", NULL, LF
threeMessage db "Welcome to function three!", NULL, LF
fourMessage db "Welcome to function four!", NULL, LF
fiveMessage db "Welcome to function five!", NULL, LF

pmpt db "Enter selection: ", NULL
newLine db LF, NULL

section .bss
char resb 1
inLine resb STRLEN+2	;total of 52

;---------------------------------------------------------------(main)
section .text
global _start
_start:


;-------------------------------------------------------------(Welcome)


	mov rdi, welcomeOne	; print welcome message line 1
	call printString	
	call printLinefeed
	mov rdi, welcomeTwo ; print welcome message line 2
	call printString
	call printLinefeed
	mov rdi, welcomeThree ; print welcome message line 3
	call printString
	call printLinefeed
	
;--------------------------------------------------------(Display Menu)

	mov rdi, menu1 ; print menu message line 1
	call printString
	call printLinefeed
	mov rdi, menu2 ; print menu message line 2
	call printString
	call printLinefeed
	mov rdi, menu3 ; print menu message line 3
	call printString
	call printLinefeed
	mov rdi, menu4 ; print menu message line 4
	call printString
	call printLinefeed
	mov rdi, menu5 ; print menu message line 5
	call printString
	call printLinefeed
	mov rdi, menu6 ; print menu message line 6
	call printString
	call printLinefeed	
	call printLinefeed 						
	mov rdi, menu7 ; print menu message line 7
	call printString
	call printLinefeed

;-------------------------------------------------------(Display prompt)
displayPrompt:
	mov rdi, pmpt
	call printString
	

;--------------------------------------------------------(Read character)
; Read characters from user (one at a time)

	mov rbx, inLine		; inLine address
	mov r12, 0			; char count
readCharacters:
	mov rax, SYS_read 	; system code for read
	mov rdi, STDIN		; standard input
	lea	rsi, [char]		; adress of characters
	mov rdx, 1			; count (how many characters to read)
	syscall				; syscall to read characters

	mov al, byte[char]	; get character just read
;--------------------------------------------------(Option processing)
	mov bl, al
	cmp al, EXIT		
	je goodBye			;if "1" exit program
	cmp al, ONE
	je functionOne		;if "1" go to function 1
	cmp al, TWO
	je functionTwo		;if "2" go to function 2
	cmp al, THREE
	je functionThree	;if "3" go to function 3
	cmp al, FOUR
	je functionFour		;if "4" go to function 4
	cmp al, FIVE
	je functionFive		;if "5" go to function 5
	cmp al, func_max  ; input > maximum number of functions
	jmp greaterThanMax	;if ">5" tell error and repeat menu

;----------------------------------------------------(Greater input than maximum options)
greaterThanMax:
		mov rdi, greaterThanMaxMessage ; show message "Enter a number between 0 and 5"
		call printString
		call printLinefeed
		jmp displayPrompt
;----------------------------------------------------------(End functions)
	cmp al, LF			; if linefeed, input done
	je readDone
	inc r12				; count++
	cmp r12, STRLEN		; if chars > STRLEN
	jge readCharacters	; stop placing in buffer
	
	mov byte[rbx], al 	; inLine[i] = char, put character in buffer
	inc rbx				; update tmpStr address, move to the next char
	jmp readCharacters
	
readDone:

;----------------------------------------------------(Output line read)
; Output the line to verify successful read
	
;	mov rdi, inLine
;	call printString
;	mov rdi, newLine
;	call printString
	
;-------------------------------------------------------------(GoodBye)
goodBye:
	mov rdi, goodbyeOne
	call printString
	call printLinefeed
	mov rdi, goodbyeTwo
	call printString
	call printLinefeed
	mov rdi, goodbyeThree
	call printString
	call printLinefeed
	jmp programEnd
	

;--------------------------------------------------------(Exit program)

programEnd:
	mov rax, SYS_exit
	mov rdi, EXIT_SUCCESS
	syscall

;-------------------------------------------------------------(print String)
;Display a string to the screen. 
;String must be null terminated.
;Arguments : 1) address, string
;Returns: nothing

global printString
printString:
	push rbp
	mov rbp, rbx
	push rbx
	
;------
;Count characters in string.

	mov rbx, rdi
	mov rdx, 0
	
strCountLoop:
	cmp byte[rbx], NULL
	je strCountDone
	inc rdx
	inc rbx
	jmp strCountLoop

strCountDone:
	cmp rdx, 0
	je prtDone
	
;-------
;Call OS to output string.
	mov rax, SYS_write 		; system code for write()
	mov rsi, rdi			; address of char's to write
	mov rdi, STDOUT			; standard input, RDX=count to write et above
	syscall					; system call	
;------
;String printed, return to calling routine

prtDone:
	pop rbx
	pop rbp
	ret
;-------------------------------------------------------------(End print String)

;-------------------------------------------------------------(Function 1)

global functionOne
functionOne:
		mov rdi, oneMessage
		call printString		; print welcome message
		call printLinefeed		; print line
		jmp goodBye				; quit program
;-------------------------------------------------------------(Function 2)
global functionTwo
functionTwo:
	mov rdi, twoMessage
	call printString	;print welcome message
	call printLinefeed	;print line
	jmp goodBye			;quit program
 
;-------------------------------------------------------------(Function 3)
global functionThree
functionThree:
	mov rdi, threeMessage
	call printString	;print welcome message
	call printLinefeed	;print line
	jmp goodBye			;quit program
;-------------------------------------------------------------(Function 4)
global functionFour
functionFour:
	mov rdi, fourMessage
	call printString	;print welcome message
	call printLinefeed	;print line
	jmp goodBye			;quit program
;-------------------------------------------------------------(Function 5)
global functionFive
functionFive:
	mov rdi, fiveMessage
	call printString	;print welcome message
	call printLinefeed	;print line
	jmp goodBye			;quit program
;------------------------------------------------------------(Print new line)

printLinefeed:
	mov rdi, newLine	;new line
	call printString
	ret





