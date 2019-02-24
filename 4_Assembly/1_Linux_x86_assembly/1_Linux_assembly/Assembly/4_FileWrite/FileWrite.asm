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
SYS_lseek equ 8 ; reposition file read/write file offset
SYS_fork equ 57	; fork process
SYS_exit equ 60	; terminate program
SYS_creat equ 85	; file open/create
SYS_time equ 201	; get time

O_CREAT equ 0x40
O_TRUNC equ 0x200
O_APPEND equ 0x400

SEEK_END	equ 2

O_RDONLY equ 000000q
O_WRONLY equ 000001q
O_RDWR	 equ 000002q

S_IRUSR equ 00400q	;set read permission to file
S_IWUSR equ 00200q	;set write permission to file
S_IXUSR equ 00100q	;set execute permission to file

;------
; Define some strings

STRLEN equ 50	;length of string read as option

welcomeOne db   "******************************************************", NULL, LF
welcomeTwo db   "******Welcome to my first Assembly program1************", NULL, LF
welcomeThree db "******************************************************", NULL, LF

goodbyeOne db   "******************************************************", NULL, LF
goodbyeTwo db   "**********************GOOD BYE!***********************", NULL, LF
goodbyeThree db "******************************************************", NULL, LF

menu1 db "PROGRAM MENU: Choose an option", NULL, LF	;menu options
menu2 db "1-Write file url.txt", NULL, LF					;option 1 string
menu3 db "2-Append to file url.txt (not working yet)", NULL, LF					;option 2 string
menu4 db "3-Function3", NULL, LF					;option 3 string
menu5 db "4-Function4", NULL, LF					;option 4 string
menu6 db "5-Test_Function", NULL, LF				;...
menu7 db "0-Exit program", NULL, LF					;...

; ------
; Variables for main.

header			db LF, "File Write Example.", LF, LF, NULL
fileName		db	"url.txt", NULL
url				db	"This is a cool program!", LF, NULL
len 			dq	$-url-1
urlTwo			db  "This is a second cool program!", LF, NULL
lenTwo			dq	$-urlTwo-1
writeDone		db	"Write completed.", LF, NULL
fileDescriptor	dq 	0
errMsgOpen 		db 	"Error opening file.", LF, NULL
errMsgWrite		db	"Error writing to file.", LF, NULL
errOnSeek		db  "Error on lseek to file.", LF, NULL


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

;-------------------------------------------------------------(Function 1: write url.txt)

global functionOne
functionOne:
		mov rdi, oneMessage
		call printString		; print welcome message
		call printLinefeed		; print line
		
		mov rdi, header
		call printString
		
		;------
		; Attempt to open file
		; Use system service for file open
		; System service - Open/Create
		; rax = SYS_create
		; rdi = address of file name string
		; rsi = attributes (i.e., read only, etc.)
		; returns
		;if error -> eax < 0
		; if success -> eax = file descriptor number
		
openInputFile: 
	mov rax, SYS_creat			; file open/create
	mov rdi, fileName			; file name string
	mov rsi, S_IRUSR | S_IWUSR 	; allow read/write	
	syscall						;call the kernel
	
	cmp rax, 0
	jl errorOnOpen
	
	mov qword [fileDescriptor], rax		;save descriptor
	
		;------
		;Write to file
		;System service - write
		; rax = SYS_write
		; rdi = file descriptor	
		; rsi = address of characters to write
		; rdx = count of characters to write
		; returns
		; if error -> rax < 0
		; if success -> eax = count of characters actually read
		
	mov rax, SYS_write
	mov rdi, qword [fileDescriptor]
	mov rsi, url
	mov rdx, qword [len]
	syscall 				;call kernel to write
	
	cmp rax, 0
	jl errorOnWrite			;go to error on write if error
	
	mov rdi, writeDone
	call printString		;print write done message
	
		;------
		;Close the file.
		; rax = SYS_close
		; rdi = file descriptor
	
	mov rax, SYS_close
	mov rdi, qword [fileDescriptor]
	syscall

	jmp goodBye				;go to main 
	
		;------
		;Error on open.
		; not, rax contains an error code which is not used
	
errorOnOpen:
		mov rdi, errMsgOpen
		call printString
		jmp goodBye			;quit program
		
		;------
		;Error on write.
		; eax contains an error code
		
errorOnWrite:
		mov rdi, errMsgWrite
		call printString
		jmp goodBye				; quit program
;-------------------------------------------------------------(Function 2: append)
global functionTwo
functionTwo:
	push rbp
	mov rbp, rbx
	push rbx

	mov rdi, twoMessage
	call printString	;print welcome message
	call printLinefeed	;print line
	
		;------
		;open existing file
		
	mov rax, SYS_open
	mov rdi, fileName
	mov rsi, O_RDWR
	
	mov qword [fileDescriptor], rax		;save descriptor
	cmp rax, 0
	jl errorOnOpenAppend			;go to error on write if error

		;------
		;Seek position in file
		
	mov rax, SYS_lseek
	mov rdi, qword[fileDescriptor]
	mov rsi, 0
	mov rdx, 2		; 2 = SEEK_END
	syscall 				;call kernel to write
	
	mov qword [fileDescriptor], rax		;save descriptor
	
	cmp rax, 0
	jl errorOnSeekAppend			;go to error on write if error
	
	;------
	; Append file
	mov rax, SYS_write
	mov rdi, qword [fileDescriptor]
	mov rsi, urlTwo
	mov rdx, qword [lenTwo]
	syscall 				;call kernel to write
	
	cmp rax, 0
	jl errorOnWriteAppend			;go to error on write if error
	
	mov rdi, writeDone
	call printString		;print write done message
	
		;------
		;Close the file.
		; rax = SYS_close
		; rdi = file descriptor
	
	mov rax, SYS_close
	mov rdi, qword [fileDescriptor]
	syscall
	jmp goodBye				;quit program
	
		;------
		;Error on open.
		; not, rax contains an error code which is not used

errorOnSeekAppend:
		mov rdi, errOnSeek
		call printString
		jmp goodBye			;quit program
	
errorOnOpenAppend:
		mov rdi, errMsgOpen
		call printString
		jmp goodBye			;quit program
		
		;------
		;Error on write.
		; eax contains an error code
		
errorOnWriteAppend:
		mov rdi, errMsgWrite
		call printString	
		jmp goodBye				; quit program
		
		
	
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





