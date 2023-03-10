package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStoreImpl implements DepartmentalStore {
	//key -> product id -> integer & value -> product instance-> product
	Map<Integer,Product> db=new LinkedHashMap<Integer,Product>();
	Scanner sc=new Scanner(System.in);
	double totalBill;
	@Override
	public void addProduct() {
		db.put(1,new Product("chocolates",10,10));
		db.put(2,new Product("iceCream",20,20));
		db.put(3,new Product("biscuits",30,50));
	}

	@Override
	public void displayProduct() {
		Set <Integer> keys=db.keySet();
		for(int key : keys) {
			Product p=db.get(key);
			System.out.println("Enter "+key+" to order "+p.getName());
			System.out.println("Available Quantity : "+p.getQuantity());
			System.out.println("Cost :Rs."+p.getCost());
			System.out.println("-------------------------------------------");
		}
	}

	@Override
	public void buyProduct() {
		System.out.println("Enter choice:");
		int choice =sc.nextInt(); // 1 2 3 -> choice key

		Product p=db.get(choice);

		if(p!=null) {
			System.out.println("Enter Quantity :");
			int quantity =sc.nextInt();

			if(quantity <=p.getQuantity()) {
				//calculating current product cost
				int productCost=quantity*p.getCost();
				// Adding productCost to total bill
				totalBill =totalBill+productCost; // totalBill+=productCost
				//updating the new quantity
				p.setQuality(p.getQuantity()-quantity);

				System.out.println("Ordered "+quantity+"  "+p.getName() +"\nProduct Cost :"+productCost+"\nTotal Bill As of now: "+totalBill);
			}else {
				try {
					String msg="Invalid  Quantity "+p.getQuantity()+" is Available";
					throw new InvalidQuantityException(msg);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String msg="Invalid Choice ,kindly Enter valid Choice";
				throw new InvalidChoiceException(msg);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void checkout() {
		System.out.println("\n\n\n\n\n\n-------------------------------------------------------");
		System.out.println("               JSP Departmental store Bill ");
		System.out.println("-------------------------------------------------------");  
		double gst,cgst;
		gst=totalBill*0.1;
		cgst=totalBill*0.1;
		System.out.println("Your Bill \t\t\t\t\t"+totalBill);
		System.out.println("Your GST 10% Is :   \t\t \t\t "+gst);
		System.out.println("Your CGST 10% Is :  \t\t \t\t "+cgst);
		totalBill=totalBill+gst+cgst;
		System.out.println("-------------------------------------------------------");

		System.out.println("Total Bill:\t\t\t\t     Rs."+totalBill);
		System.out.println("-------------------------------------------------------\n\n");
		System.out.println("--------------Thank You for Shopping-----------------------");


	}

}
