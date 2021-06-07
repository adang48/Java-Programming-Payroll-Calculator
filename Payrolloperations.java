//****************************************************************************************************************************
//Program name: "Payroll System".  This program shows how to produce regular, overtime, and gross payments in simple UI using*
//3 active buttons.  Copyright (C) 2021 Albert Dang                                                                          *
//This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License  *
//version 3 as published by the Free Software Foundation.                                                                    *
//This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied         *
//warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.     *
//A copy of the GNU General Public License v3 is available here:  <https://www.gnu.org/licenses/>.                           *
//****************************************************************************************************************************

//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3**

//Author information:
  //Author: Albert Dang
  //Mail: dangqalbert@csu.fullerton.edu

//Program information:
  //Program name: Payroll System, 1.0
  //Programming language: Java
  //Files: Main.java, MyFrame.java, Payrolloperations.java, run.sh
  //Date project began: 2021-February-8.
  //Date of last update: 2021-February-13.
  //Status: Finished; testing completed.
  //Purpose: This program demonstrates the design of a simple UI (user interface) where the implemented functions process user
  //inputs for calculations and computes different payment types.The functions exclusively select inputs that are double types.  
  //Base test system: Linux system with Bash shell and openjdk-14-jdk

//This module
  //File name: Payrolloperations.java
  //Compile : javac Payrolloperations.java
  //Purpose: This class implements the user interface
  //This module (class) is called from the Payrolloperations class.
  //Educational purpose of this Payrolloperations class:
    //   1.  Demonstrates how to use basic arithmetic skills (multiplication, subtraction, and addition) utilizing arrays.
    //   2.  Demonstrates how to search for digits and specific characters 


public class Payrolloperations {
 public static double[] compute(double hours, double rate) { //create an array function to output three seperate outputs
    double overtimepay, grosspay, regularpay;
    if(hours<=40) { //Listed three different conditions for calculation/Less than 40 hours
        regularpay = hours*rate;
        overtimepay = 0.0;
    }
    else if(hours > 168) { //More than hours alloted in a week
        regularpay = 0.00;
        overtimepay = 0.00;
        grosspay = 0.00;
    }
    else {
        regularpay = 40.0*rate;
        overtimepay = 1.5*rate*(hours-40.0);
    }
    grosspay = regularpay + overtimepay;

    double[] result = new double[3];
    result[0] = regularpay;
    result[1] = overtimepay;
    result[2] = grosspay;

    return result;
 }

 public static boolean isNum(String s) {
    int leng = s.length();
        boolean success = true;  
        if(leng == 0)            
              success = false;
        else  //(leng > 0)
              {int start = 0;
               char c = s.charAt(0);
               if(c == '+') start = 1;
               if(c == '-') {
                   start = 1; 
                   success = false;
               }
               if(start == leng) success = false;   
               for(int k = start; k<leng && success; k++) { 
                   c = s.charAt(k);
                   if(!Character.isDigit(c) && c != '.') { //search string; if any char is non-digit
                   success = false;                       //or not a period then set success to false
                    }
                }
                if (!s.contains(".")) { //verify if input is a double
                    success = false;
                }
              }
         return success;
 }
}
