#!/bin/bash

#Program name: Payroll System
#Author: Albert Dang
#Email: dangqalbert@csu.fullerton.edu
#File name:  run.sh
#Preconditions:
#   1.  All source files are in one directory
#   2.  This file, run.sh, is in that same directory
#   3.  The shell is currently active in that same directory
#How to execute: Enter "sh run.sh" without the quotes.

echo Remove old byte-code files if any exist
rm *.class

echo View list of source files
ls -l *.java

echo Compile Payrolloperations.java
javac Payrolloperations.java

echo Compile MyFrame.java
javac MyFrame.java

echo Compile Main.java
javac Main.java

echo Execute the Arithmetic program
java Main.java

echo End of execution.  Have a nice day.