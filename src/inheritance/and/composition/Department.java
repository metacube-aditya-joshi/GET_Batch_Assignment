package inheritance.and.composition;


import java.util.List;

final class Department {
    private static int idInitializer = 0;
    final int departmentId;
    final String departmentNameString;
    List<Employee> departmentEmp;

    public Department(String departmentNameString) {

	this.departmentNameString = departmentNameString;
	this.departmentId = idInitializer++;

    }

    String addEmp(Employee newEmp) throws CustomException {
	if (newEmp == null)
	    throw new CustomException("Null Object is not Valid Input");

	departmentEmp.add(newEmp);

	return "New Employee added";
    }

    List<Employee> getEmployeesOfDepartment() {
	try {
	    if (departmentEmp.isEmpty() || departmentEmp == null)
		throw new CustomException("List of department employee is null or empty!!");
	} catch (Exception e) {

	}
	return departmentEmp;
    }
}

