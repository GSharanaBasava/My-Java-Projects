package Calculator.c1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//UPCASTING => TO ACHIVE ABSTRACTION
		Calculator calc=new CalculatorImpl();
		//MENU DRIVEN PROGRAM
		while(true) {
			System.out.println("1:Addition \n2:Substraction \n3:Multiplication \n4:Division \n5:Exit\nEnter Choice");
			int choice =sc.nextInt();
			int a=0,b=0;
			if(choice>=1 && choice<=4) {
				System.out.println("Enter 2 interger number");
				a=sc.nextInt();
				b=sc.nextInt();
			}
			switch(choice) {
			
			case 1:
				
				System.out.println("The Addition of "+a+" & "+b+" is :"+calc.add(a, b));
				break;
			case 2:
				 
				System.out.println("The Difference of "+a+" & "+b+" is :"+calc.add(a, b));
				break;
			case 3:
				 
				System.out.println("The Product of "+a+" & "+b+" is :"+calc.mul(a, b));
				break;
			case 4:
				 if(b!=0) {
				System.out.println("The Division of "+a+" & "+b+" is :"+calc.div(a, b));
				 }else {
					 System.out.println("Denaminator should not be zero cannot divide");
				 }
				break;
			case 5:
				System.out.println("Thank You...!!");
				System.exit(0);
				break;
			default :
				calc.displayErrorMessage();
			}
			System.out.println("-------------------------------------------------------------------");
		}
	}

}
