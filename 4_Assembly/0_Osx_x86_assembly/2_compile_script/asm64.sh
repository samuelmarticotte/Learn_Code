#!/bin/bash 
#Simple assemble/link script

if [ -z $1 ]; then
	echo "Usage: ./asm <asmMainFile> (no extension)"
	exit
fi

#Verify no extension
if [ ! -e "$1.asm" ]; then
	echo "Error, $1.asm not found."
	echo "Note, do not enter file extensions."
	exit
fi

#Compile, assemble, and link. 

as -o $1.o $1.asm
ld $1.o -e _main -o $1 -macosx_version_min 10.12 -arch x86_64 -lSystem


