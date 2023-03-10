package com;

public class BankImpl implements Bank{
	int balance;



	public BankImpl(int balance) {
		this.balance = balance; 
	}

	@Override
	public void deposite(int amt) {
		System.out.println("Depositing Rs."+amt);
		balance+=amt; 
		System.out.println("Amount Deposited sucesfully..!");
	}

	@Override
	public void withdraw(int amt) {
		System.out.println("Withdrawing Rs."+amt);
		if(amt<=balance) {

			balance-=amt; 					 
			System.out.println("Amount Withdrawn sucesfully..!");

		}
		else 
		{
			try {
				throw new InsufficientBalanceException("Insuffient balance ...!"); 
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public int getBalance() {

		return balance;
	}

}
