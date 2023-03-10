 package customesorting;

import java.util.Comparator;

import EMS.Employee;

public class SortEmployeeByName implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getName().compareTo(e2.getName());
	}

}