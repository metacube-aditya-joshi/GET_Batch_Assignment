package inheritance.and.compostion;

import java.util.ArrayList;
import java.util.List;

public class Organisation {
    private String nameString;
    private List<Department> departments = new ArrayList<Department>();

    public Organisation(String nameString) {
	this.setNameString(nameString);
    }

    public boolean addDepartment(Department department) {
	return departments.add(department);
    }

    public List<Employee> getAllEmployees() {
	List<Employee> allEmployees = new ArrayList<Employee>();
	for (Department department : departments) {
	    allEmployees.addAll(department.getEmployees());
	}
	return allEmployees;
    }

    public String getNameString() {
	return nameString;
    }

    public void setNameString(String nameString) {
	this.nameString = nameString;
    }

    public List<Department> getDepartments() {
	// TODO Auto-generated method stub
	return departments;
    }

}
