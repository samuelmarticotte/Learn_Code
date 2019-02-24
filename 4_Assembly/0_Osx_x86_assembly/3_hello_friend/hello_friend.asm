; hello.asm - a "hello, world" program using NASM
; nasm -f macho hello_friend.asm
;ld -o hello_friend -e mystart hello_friend.o

;compile and run : alias comp_run='nasm -f macho hello_friend.asm; ld -o hello_friend -e mystart hello_friend.o; ./hello_friend'

#define	SYS_syscall        0
#define	SYS_exit           1
#define	SYS_fork           2
#define	SYS_read           3
#define	SYS_write          4
#define	SYS_open           5
#define	SYS_close          6
#define	SYS_wait4          7

section .text 

global mystart ;make the main function externally visible

mystart:

; 1 print menu===================================================================
	; 1a: prepare main arguments for the system call to writie
	push dword menulen		; message length
	push dword mymenu		; message to write
	push dword 1			; file descriptor value
	
	; 1b: make the system call to write
	mov eax, 0x4			;system call number for write
	sub esp, 4				;OS X (and BSD) system calls needs extra space
	int 0x80				;make the actual system call
	
	;1c clean up the stack 
	add esp, 16				; 3 args * 4 bytes/arg + 4 bytes for extra space = 16 bytes
	
; 2 print "hello, friend"=======================================================

	; 2a: prepare main arguments for the system call to writie
	push dword mylen		; message length
	push dword mymsg		; message to write
	push dword 1			; file descriptor value
	
	; 2b: make the system call to write
	mov eax, 0x4			;system call number for write
	sub esp, 4				;OS X (and BSD) system calls needs extra space
	int 0x80				;make the actual system call
	
	;2c clean up the stack 
	add esp, 16				; 3 args * 4 bytes/arg + 4 bytes for extra space = 16 bytes
	
global functionOne
functionOne:
	push rbx
	mov rdi, functionOneMEssage ; print menu message line 7
	call printString
	pop rbx
	ret	

; 3 exit the program===============================================================

	; 3a: prepare main arguments for the system call to write
	push dword exitmsglen		; message length
	push dword exitmsg		; message to write
	push dword 1			; file descriptor value
	
	; 3b: make the system call to write
	mov eax, 0x4			;system call number for write
	sub esp, 4				;OS X (and BSD) system calls needs extra space
	int 0x80				;make the actual system call
	
	;3c clean up the stack 
	add esp, 16				; 3 args * 4 bytes/arg + 4 bytes for extra space = 16 bytes
	
	
	; 3a: prepare the argument for the syscall to exit 
	push dword 0 			; exit status returned to the operating system 
	
	; 3b: make the call sys call to exit
	mov eax, 0x1			;system call number for exit
	sub esp, 4				;OSX system calls need extra space
	int 0x80				;make syscall
	
	; 3c: no need to clean up stack because no code here would execute 
	
section .data
	;menu strings
    mymenu db "=====Welcome to my program=====", 0xa 	;menu and carriage return
    menulen equ $-mymenu 								;length of menu
    
    ;exit strings
    exitmsg db "===========Good Bye============", 0xa 	;exit and carriage return
    exitmsglen equ $-exitmsg
    
    ;print strings
	mymsg db "hello, friend blue blue blue blue", 0xa 	;string with a carriage return
	mylen equ $-mymsg				;string with length in bytes 
	

	