package com;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws InvalidChoiceException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount into your account");
		Bank bank= new BankImpl(sc.nextInt());

		while(true) {
			System.out.println("1:Deposit\n2:Withdraw\n3:Check Balance\n4:Exit\nEnter Your choice");

			int choice =sc.nextInt();


			switch(choice) {
			case 1:
				System.out.println("Enter amount to be deposited");
				bank.deposite(sc.nextInt());
				break;
			case 2: 
				System.out.println("Enter amount to be withdrawn ");
				bank.withdraw(sc.nextInt());
				break;
			case 3: 
				System.out.println("Avalable Balance : "+bank.getBalance());
				break;
			case 4: 
				System.out.println("Thank you visit again...!");
				System.exit(0);
				break;
			default:
				 throw new InvalidChoiceException("Invalid choice...!");
			}
		} 
	}

}
