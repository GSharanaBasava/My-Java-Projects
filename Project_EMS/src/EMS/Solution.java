 package EMS;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
 public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	EmployeeManagementSystem ems=new EmployeeManagementSystemImpl();
	System.out.println("Welcome to Employee DataBase system..");
	while(true) {
		System.out.println("1:Add Employee\n2:Display Employee");
		System.out.println("3:Display All Employee\n4:Remove Employee");
		System.out.println("5:Remove All Employee\n6:Update Employee");
		System.out.println("7:Count Employee\n8:Sort Employee");
		System.out.println("9:Get Employee With Highest Marks\n10:Get Employee With Lowest Marks\n11:EXIT");
	    System.out.println("Enter ur Choice:");
	    int choice=scan.nextInt();
	    switch(choice) {
	    case 1:
	    	ems.addEmployee();
	    	break;
	    case 2:
	    	ems.displayEmployee();
	    	break;
	    case 3:
	    	ems.displayAllEmployees();
	    	break;
	    case 4:
	    	ems.removeEmployee();
	    	break;
	    case 5:
	    	ems.removeAllEmployees();
	    	break;
	    case 6:
	    	ems.updateEmployee();
	    	break;
	    case 7:
	    	ems.countEmployees();
	    	break;
	    case 8:
	    	ems.sortEmployees();
	    	break;
	    case 9:
	    	ems.getEmployeeWithHighestMarks();
	    	break;
	    case 10:
	    	ems.getEmployeeWithLowestMarks();
	    	break;
	    case 11:
	    	System.out.println("Thanx for visiting!!");
	    	System.exit(0);
	    	break;
	    	default:
	    		try {
	    			String message="Inavlid choice ,Plz eneter valid choice!!";
	    			throw new InvalidChoiceException(message);
	    		}
	    		catch(Exception e) {
	    			System.out.println(e.getMessage());
	    		}
	    }
	}
}
}