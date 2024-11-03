package inheritance.and.composition;


import java.util.ArrayList;
import java.util.List;

public class Organization {
    static List<Department> listOfDepartments;
    static List<Employee> listOfEmployees;

    public Organization() {
	listOfDepartments = new ArrayList<Department>();
	listOfEmployees = new ArrayList<Employee>();

    }

    boolean addDepartmnet(Department department) throws CustomException {
	if (listOfDepartments.contains(department))
	    throw new CustomException("Department Already Exist!!");

	try {
	    listOfDepartments.add(department);
	} catch (Exception e) {
	    e.getStackTrace();
	    throw new CustomException("Error in adding Departement!!");
	}
	return true;

    }

    boolean removeDepartment(Department department) throws CustomException {
	if (!listOfDepartments.contains(department))
	    throw new CustomException("No Department Exist to remove from the list!!");
	try {
	    listOfDepartments.remove(department);
	    department = null;
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return true;
    }

    static int getDepartmentId(String department) throws CustomException {
	int index = -1;
	try {

	    if (listOfDepartments.isEmpty())
		createListOfEmployees();

	    for (Department department2 : listOfDepartments) {
		if (department2.departmentNameString.equals(department)) {
		    index = department2.departmentId;
		    break;
		}
	    }

	} catch (Exception e) {
	    e.getStackTrace();
	    throw new CustomException("Error in getting department id!!");
	}
	if (index < 0)
	    throw new CustomException("Department Doesn't Exist!!");
	return index;
    }

    List<Employee> getAllEmployees() throws CustomException {
	try {
	    if (listOfEmployees.isEmpty())
		createListOfEmployees();

	} catch (Exception e) {
	    e.getStackTrace();
	    throw new CustomException("Error in returning List of Employees");
	}
	return listOfEmployees;
    }

    static List<Employee> createListOfEmployees() throws CustomException {
	try {
	    if (listOfDepartments == null || listOfDepartments.isEmpty())
		throw new CustomException("Cannot Create list of Employees as list od department doesn't exist!!");
	    for (Department department : listOfDepartments) {
		listOfEmployees.addAll(department.getEmployeesOfDepartment());
	    }

	} catch (Exception e) {
	    throw new CustomException("Error in creating List of Employees");
	}
	List<Employee> newEmployees = new ArrayList<>();
	newEmployees.addAll(listOfEmployees);
	return newEmployees;

    }
}
