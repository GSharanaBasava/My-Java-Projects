 package customesorting;

import java.util.Comparator;

import EMS.Employee;

public class SortEmployeeById implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getId().compareTo(e2.getId());
	}

}