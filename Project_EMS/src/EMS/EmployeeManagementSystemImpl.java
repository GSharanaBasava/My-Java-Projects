 package EMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customesorting.SortEmployeeByAge;
import customesorting.SortEmployeeById;
import customesorting.SortEmployeeByName;
import customesorting.SortEmployeeBySalary;
import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceException;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem {

	Scanner scan=new Scanner(System.in);
	Map<String,Employee> db=new LinkedHashMap<String,Employee>();
	
	@Override
	public void addEmployee() {
			System.out.println("Enter Employee Id:");
			String id=scan.next();
			System.out.println("Enter Employee Name:");
			String name=scan.next();
			System.out.println("Enter Employee Age:");
			int age=scan.nextInt();
			System.out.println("Enter Employee Salary:");
			double salary=scan.nextDouble();
			Employee emp=new Employee(name, age, salary);
			db.put(emp.getId(), emp);
			System.out.println("Employee record inserted successfully");
			System.out.println("Employee Id is :"+emp.getId());
	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter Employee Id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Employee emp=db.get(id);
			System.out.println("Id    :"+emp.getId());
			System.out.println("Name  :"+emp.getName());
			System.out.println("Age   :"+emp.getAge());
			System.out.println("Salary:"+emp.getSalary());
		}else {
			try {
				String message = "Student with " + id + " Id is not found!";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void displayAllEmployees() {
		if(db.size()!=0) {
			Set<String>keys=db.keySet();
			for(String key:keys) {
				System.out.println(db.get(key));
			}
		}
			else {
				try {
					String message="Student DataBase is Empty nothing to Display!";
					throw new EmployeeNotFoundException(message);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
		
		
	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter Employee Id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Employee record found!");
	    	 System.out.println(db.get(id));
	    	 db.remove(id);
	    	 System.out.println("Employee record Deleted successfully..");
	     }else {
	    	 try {
					String message = "Employee with " + id + " Id is not found!";
					throw new EmployeeNotFoundException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					
				}	
	    	 }
	}

	@Override
	public void removeAllEmployees() {
		System.out.println("Employee records avialable : "+db.size());
		if(db.size()!=0) {
			db.clear();
			System.out.println("All Employee records deleted sucessfully!");
			System.out.println("Employee records avialable : "+db.size());
		}else {
			try {
				String message="Employee DataBase is Empty - nothing to Delete!";
				throw new EmployeeNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void updateEmployee() {
		System.out.println("Eneter Employee Id:");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Employee std=db.get(id);
			System.out.println("1:Update Age\n2:Update Name\n3:Update Salary");
			System.out.println("Enter ur Choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=scan.nextInt();
				std.setAge(age);
				break;
				
			case 2:
				System.out.println("Enter Name");
				String name=scan.next();
				std.setName(name);
				break;
				
			case 3:
				System.out.println("Enter Marks");
				int salary=scan.nextInt();
				std.setSalary(salary);
				break;
				default:
					try {
						String message="invalid choice,kindly enter valid choice";
						throw new InvalidChoiceException(message);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
			}
		}
		
	}

	@Override
	public void countEmployees() {
		System.out.println("No of Employees records found ="+db.size());
		
	}

	@Override
	public void sortEmployees() {
		Set<String>keys=db.keySet();
		List<Employee>list=new ArrayList<Employee>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		System.out.println("1:Sort By Id\n2:Sort By Name\n3:Sort By Age\n4:Sort By Salary");
		System.out.println("Enter ur choice");
		int choice =scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortEmployeeById());
			display(list);
			break;
			
		case 2:
			Collections.sort(list,new SortEmployeeByName());
			display(list);
			break;
			
		case 3:
			Collections.sort(list,new SortEmployeeByAge());
			display(list);
			break;
			
		case 4:
			Collections.sort(list,new SortEmployeeBySalary());
			display(list);
			break;
			default:
				try {
					String message="invalid choice,kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			
		}
		
	}
	private static void display(List<Employee>list) {
		for(Employee s:list) {
			System.out.println(s);
		}
	}

	@Override
	public void getEmployeeWithHighestMarks() {
		
		if(db.size()>=2) {
			Set<String>keys=db.keySet();
			List<Employee>list=new ArrayList<Employee>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(list.size()-1));
		
			
		}
	}

	@Override
	public void getEmployeeWithLowestMarks() {
		if(db.size()>=2) {
			Set<String>keys=db.keySet();
			List<Employee>list=new ArrayList<Employee>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(0));
		
			}
		}
	}