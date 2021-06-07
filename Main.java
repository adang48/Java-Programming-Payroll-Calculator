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
  //File name: Main.java
  //Compile : javac Main.java
  //This is the top level module.  This module activates the user interface.

import javax.swing.JFrame;
import java.awt.GridLayout;

public class Main {
  public static void main(String[] args) {

        JFrame myFrame = new MyFrame();
        myFrame.setTitle("Program 1");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 970); // Sets (X,Y)
        myFrame.setLayout(new GridLayout(4,1));
        myFrame.setVisible(true); // make visible
        myFrame.setResizable(false);
               
    }
    
}//end of class Main
