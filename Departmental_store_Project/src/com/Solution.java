package com;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcom to  JSP Depart-mental Store");
		System.out.println("---------------------------------");
		Scanner sc =new Scanner(System.in);

		DepartmentalStore ds=new DepartmentalStoreImpl();

		ds.addProduct();
		int choice=1;
		while(choice==1) {
			ds.displayProduct();
			ds.buyProduct();

			System.out.println("__________________________");
			System.out.println("Press 1 to continue.... Shopping or any number for check out");
			choice =sc.nextInt();
		} 
		ds.checkout();
	}
}
