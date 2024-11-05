package inheritance.and.compostion;

import java.util.ArrayList;
import java.util.List;

class Department {
    private String nameOfDepartementString;
    private List<Employee> employees = new ArrayList<Employee>();

    public Department(String nameOfDepartementString) {
	this.setNameOfDepartementString(nameOfDepartementString);
    }

    public boolean join(Employee employee)
    {
	return employees.add(employee);
    }
    
    public boolean relieve(Employee employee)
    {
	return employees.remove(employee);
    }
    
    public List<Employee> getEmployees(){
	return employees;
    }
    
    public String getNameOfDepartementString() {
	return nameOfDepartementString;
    }

    public void setNameOfDepartementString(String nameOfDepartementString) {
	this.nameOfDepartementString = nameOfDepartementString;
    }
    
    
}
