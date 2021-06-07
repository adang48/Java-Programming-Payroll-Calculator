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
  //File name: MyFrame.java
  //Compile : javac MyFrame.java
  //Purpose: This class defines the user interface
  //This module (class) is called from the MyFrame class.
  //Educational purpose of this MyFrame class:
    //   1.  Demonstrates how to partition a software solution among 3 source files.
    //   2.  Demonstrates the ability to create a UI and its components.
    //   3.  Demonstrates how to delay a button-click.

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame {

    private JLabel employeeName;
    private JTextField textfield1;
    private JLabel hoursWorked;
    private JTextField textfield2;
    private JLabel hourPayRate;
    private JTextField textfield3;

    private JLabel nameOfEmployee;
    private JLabel nameOfEmployee2;
    private JLabel regularPay;
    private JLabel regularPay2;
    private JLabel overTimePay;
    private JLabel overTimePay2;
    private JLabel grossPay;
    private JLabel grossPay2;

    JButton clearButton;
    JButton quitButton;
    JButton computeButton;

    public boolean successful_calculation = true;
    public boolean successful_double = false;
    public boolean input_is_valid;
    public boolean double_is_valid;
    private String employeeNameString;
    private String hoursWorkedString;
    private double hoursWorkedDouble;
    private String hoursPayString;
    private double hoursPayDouble;
    
    private String regpayString;
    private String overtimeString;
    private String grosspayString;
    private int leng=10;

    private Timer delayedclosing;
    private final int length_of_delay = 3500;

    MyFrame() {
        
        JPanel darkbluePanel = new JPanel();
        darkbluePanel.setLayout(new GridLayout(1,0));
        darkbluePanel.setBackground(new Color(7, 72, 91));

        JLabel label = new JLabel("Healthy Minds Payroll System");
        label.setForeground(new Color(240, 240, 240));
        label.setBackground(new Color(7, 72, 91));
        label.setOpaque(true); // 2nd step to display opaque color
        label.setFont(new Font("TimesRoman", Font.BOLD|Font.ITALIC, 24)); //set custom font Type1|Type2
        label.setVerticalAlignment(JLabel.CENTER); // Brings label to center
        label.setHorizontalAlignment(JLabel.CENTER); // Brings label to center
        darkbluePanel.add(label);
        this.add(darkbluePanel);

        JPanel teilPanel = new JPanel();
        teilPanel.setLayout(null);
        teilPanel.setBackground(new Color(13, 105, 134));
        teilPanel.setBounds(0, 500, 500, 375);
        teilPanel.isPreferredSizeSet();
        this.add(teilPanel);

        employeeName = new JLabel("  Employee Name:");
        employeeName.setForeground(new Color(240, 240, 240));
        employeeName.setBackground(new Color(13, 105, 134));
        employeeName.setOpaque(true); 
        employeeName.setFont(new Font("Helvetica", Font.BOLD, 15));
        employeeName.setBounds(15, 40, 150, 25); //set custom positions
        teilPanel.add(employeeName);

        textfield1 = new JTextField(20); //Textfield with 20 columns
        textfield1.setBounds(190,40,250,25);
        teilPanel.add(textfield1);

        hoursWorked = new JLabel("  Hours Worked:");
        hoursWorked.setForeground(new Color(240, 240, 240));
        hoursWorked.setBackground(new Color(13, 105, 134));
        hoursWorked.setOpaque(true); 
        hoursWorked.setFont(new Font("Helvetica", Font.BOLD, 15));
        hoursWorked.setBounds(15, 80, 130, 25); 
        teilPanel.add(hoursWorked);

        textfield2 = new JTextField(20);
        textfield2.setBounds(190,80,250,25);
        teilPanel.add(textfield2);

        hourPayRate = new JLabel("  Hourly Pay Rate:");
        hourPayRate.setForeground(new Color(240, 240, 240));
        hourPayRate.setBackground(new Color(13, 105, 134));
        hourPayRate.setOpaque(true); 
        hourPayRate.setFont(new Font("Helvetica", Font.BOLD, 15));
        hourPayRate.setBounds(15, 120, 150, 25); 
        teilPanel.add(hourPayRate);

        textfield3 = new JTextField(20);
        textfield3.setBounds(190,120,250,25);
        teilPanel.add(textfield3);

        JPanel lightbluePanel = new JPanel();
        lightbluePanel.setLayout(null);
        lightbluePanel.setBackground(new Color(142, 199, 210));
        lightbluePanel.setBounds(0, 1000, 500, 500);
        this.add(lightbluePanel);

        nameOfEmployee = new JLabel("  Name of Employee");
        nameOfEmployee.setForeground(new Color(240, 240, 240));
        nameOfEmployee.setBackground(new Color(142, 199, 210));
        nameOfEmployee.setOpaque(true); 
        nameOfEmployee.setFont(new Font("Helvetica", Font.BOLD, 15));
        nameOfEmployee.setBounds(15, 40, 150, 25); 
        lightbluePanel.add(nameOfEmployee);

        nameOfEmployee2 = new JLabel("");
        nameOfEmployee2.setForeground(new Color(240, 240, 240));
        nameOfEmployee2.setBackground(new Color(142, 199, 210));
        nameOfEmployee2.setOpaque(true); 
        nameOfEmployee2.setFont(new Font("Helvetica", Font.BOLD, 15));
        nameOfEmployee2.setBounds(190,40,250,25);
        lightbluePanel.add(nameOfEmployee2);

        regularPay = new JLabel("  Regular Pay");
        regularPay.setForeground(new Color(240, 240, 240));
        regularPay.setBackground(new Color(142, 199, 210));
        regularPay.setOpaque(true); 
        regularPay.setFont(new Font("Helvetica", Font.BOLD, 15));
        regularPay.setVerticalAlignment(JLabel.CENTER); 
        regularPay.setHorizontalAlignment(JLabel.LEFT); 
        regularPay.setBounds(15, 80, 130, 25); 
        lightbluePanel.add(regularPay);

        regularPay2 = new JLabel("");
        regularPay2.setForeground(new Color(240, 240, 240));
        regularPay2.setBackground(new Color(142, 199, 210));
        regularPay2.setOpaque(true); 
        regularPay2.setFont(new Font("Helvetica", Font.BOLD, 15));
        regularPay2.setBounds(190,80,250,25);
        lightbluePanel.add(regularPay2);

        overTimePay = new JLabel("  Overtime Pay");
        overTimePay.setForeground(new Color(240, 240, 240));
        overTimePay.setBackground(new Color(142, 199, 210));
        overTimePay.setOpaque(true); 
        overTimePay.setFont(new Font("Helvetica", Font.BOLD, 15));
        overTimePay.setBounds(15, 120, 150, 25);
        lightbluePanel.add(overTimePay);

        overTimePay2 = new JLabel("");
        overTimePay2.setForeground(new Color(240, 240, 240));
        overTimePay2.setBackground(new Color(142, 199, 210));
        overTimePay2.setOpaque(true); 
        overTimePay2.setFont(new Font("Helvetica", Font.BOLD, 15));
        overTimePay2.setBounds(190,120,250,25);
        lightbluePanel.add(overTimePay2);

        grossPay = new JLabel("  Gross Pay");
        grossPay.setForeground(new Color(240, 240, 240));
        grossPay.setBackground(new Color(142, 199, 210));
        grossPay.setOpaque(true); 
        grossPay.setFont(new Font("Helvetica", Font.BOLD, 15));
        grossPay.setBounds(15, 160, 150, 25);
        lightbluePanel.add(grossPay);

        grossPay2 = new JLabel("");
        grossPay2.setForeground(new Color(240, 240, 240));
        grossPay2.setBackground(new Color(142, 199, 210));
        grossPay2.setOpaque(true); 
        grossPay2.setFont(new Font("Helvetica", Font.BOLD, 15));
        grossPay2.setBounds(190,160,250,25);
        lightbluePanel.add(grossPay2);

        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(null);
        whitePanel.setBackground(new Color(240, 240, 240));
        whitePanel.setBounds(0, 1500, 500, 250);
        this.add(whitePanel);

        clearButton = new  JButton("Clear");
        clearButton.setFont(new Font("Courier", Font.PLAIN, 14));
        clearButton.setBounds(35,85,100,50);
        whitePanel.add(clearButton);

        computeButton = new  JButton("Compute");
        computeButton.setFont(new Font("Courier", Font.PLAIN, 14));
        computeButton.setBounds(185,85,100,50);
        whitePanel.add(computeButton);

        quitButton = new  JButton("Quit");
        quitButton.setFont(new Font("Courier", Font.PLAIN, 14));
        quitButton.setBounds(335,85,100,50);
        whitePanel.add(quitButton);

        buttonHandler myhandler = new buttonHandler();
        clearButton.addActionListener(myhandler);
        computeButton.addActionListener(myhandler);
        quitButton.addActionListener(myhandler);
        setLocationRelativeTo(null);  //This statement opens the UI in the center of the monitor.
        delayedclosing = new Timer(length_of_delay,myhandler);


    }//end of constructor

    private class buttonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==computeButton) {
            System.out.println("The compute button was clicked.");
            //Get name 
            employeeNameString = textfield1.getText();
            nameOfEmployee2.setText(employeeNameString);
            
            //Verify if hours is in the correct format
             successful_calculation = true;   
             hoursWorkedString = textfield2.getText();
             leng = hoursWorkedString.length();
             if (leng == 0) {hoursWorkedDouble = 0;}
             else input_is_valid = Payrolloperations.isNum(hoursWorkedString);
             if(input_is_valid) hoursWorkedDouble = Double.parseDouble(hoursWorkedString);
             else    successful_calculation = false;


             //Verify if payrate is in the correct format
             hoursPayString = textfield3.getText();
             leng = hoursPayString.length();
             if (leng == 0) {hoursPayDouble = 0;}
             input_is_valid = Payrolloperations.isNum(hoursPayString);
             if(input_is_valid) hoursPayDouble = Double.parseDouble(hoursPayString);
             else    successful_calculation = false;


             //If both inputs are valid calculate regular pay, overtime pay, gross pay
            if(successful_calculation) {
                double[] grosspay = Payrolloperations.compute(hoursWorkedDouble,hoursPayDouble);                
                regpayString = String.format("%.02f",grosspay[0]);
                regularPay2.setText(regpayString);
                overtimeString = String.format("%.02f",grosspay[1]);
                overTimePay2.setText(overtimeString);
                grosspayString = String.format("%.02f",grosspay[2]);
                grossPay2.setText(grosspayString);
                
            }
            
            else {
                regularPay2.setText("Error"); 
                overTimePay2.setText("Error");
                grossPay2.setText("Error");
            }
            } //End of if(event.getSource() == computebutton) 
                     
          if(e.getSource()==clearButton) {
            System.out.println("The clear button was clicked.");
            textfield1.setText("");
            textfield2.setText("");
            textfield3.setText("");
            nameOfEmployee2.setText("");
            regularPay2.setText("");
            overTimePay2.setText("");
            grossPay2.setText("");
          }
          else if(e.getSource() == quitButton) {
            System.out.print("The exit button was clicked.  There are 3.5 seconds remaining.\n");
            quitButton.setEnabled(false);
            computeButton.setEnabled(false);
            clearButton.setEnabled(false);
            delayedclosing.start();
          }
          else if(e.getSource() == delayedclosing) System.exit(0);

        }
    
        
    }//end of button handler
}
