package inheritance.and.compostion;

import java.util.Scanner;

public class Main {

    private static Organisation organisation = new Organisation("MetaCube");

    public static void main(String[] args) throws CustomException {
	try (Scanner inputScanner = new Scanner(System.in)) {
	    boolean repeatMenu = true;
	    while (repeatMenu) {
		System.out.println("------------Payroll Main Menu -------------");
		System.out.println("1. Add Department");
		System.out.println("2. Add Employee to Department");
		System.out.println("3. Relieve Employee from Department");
		System.out.println("4. Print Salary Slips for All Employees");
		System.out.println("5. List of All the Employees in Organisation");
		System.out.println("6. Exit");
		System.out.println("Enter option :");
		int choice = inputScanner.nextInt();
		inputScanner.nextLine();

		if (choice == 1)
		    addDepartment(inputScanner);
		else if (choice == 2) {
		    addEmployeeToDepartment(inputScanner);

		} else if (choice == 3) {
		    relieveEmployeeFromDepartment(inputScanner);
		} else if (choice == 4) {
		    Payroll.printAllSalarySlips(organisation);
		} else if (choice == 5) {
		    listAllEmployees();
		} else {
		    repeatMenu = false;
		}

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new CustomException("Error in main class");
	}

    }

    private static void addDepartment(Scanner inutScanner) throws CustomException {
	try {
	    System.out.println("Enter department name (IT or Admin) :");

	    String depNameString = inutScanner.nextLine();
	    Department department = null;
	    if (depNameString.equalsIgnoreCase("IT"))
		department = new ITDepartment(depNameString);
	    else if (depNameString.equalsIgnoreCase("Admin"))
		department = new AdminDepartment(depNameString);
	    else {

	    }
	    organisation.addDepartment(department);

	    System.out.println("Department " + depNameString + " Added");

	} catch (Exception e) {

	    throw new CustomException("Error in adding department to organisation");
	}

    }

    private static void addEmployeeToDepartment(Scanner inputScanner) throws CustomException {
	try {
	    System.out.println("Enter Department Name :");
	    String depNameString = inputScanner.nextLine();
	    Department department = findDepartmentByName(depNameString);

	    if (department == null) {
		addDepartment(inputScanner);
	    }
	    System.out.println("Enter Employee type(Developer/Manager/QA");
	    String empTypeString = inputScanner.nextLine();
	    System.out.println("Enter Employee name :");
	    String empNameString = inputScanner.nextLine();
	    System.out.println("Enter employee id :");
	    int empId = inputScanner.nextInt();
	    System.out.println("Enter the basic salary :");
	    double basicSalary = inputScanner.nextDouble();
	    inputScanner.nextLine();

	    Employee employee;
	    if (empTypeString.equalsIgnoreCase("Developer"))
		employee = new Developer(empNameString, empId, basicSalary);
	    else if (empTypeString.equalsIgnoreCase("Manager")) {
		employee = new Manager(empNameString, empId, basicSalary);

	    } else if (empTypeString.equalsIgnoreCase("Tester")) {
		employee = new Tester(empNameString, empId, basicSalary);

	    } else {
		throw new CustomException("Enter Valid Employee Role");
	    }
	    department.join(employee);
	    System.out.println("Employee " + empNameString + " added to departement " + depNameString);

	} catch (Exception e) {
	    throw new CustomException("Error in adding employees");
	}
    }

    private static void relieveEmployeeFromDepartment(Scanner inputScanner) throws CustomException {
	System.out.println("Enter Department Name :");
	String depNameString = inputScanner.nextLine();
	Department department = findDepartmentByName(depNameString);

	if (department == null) {
	    System.out.println("Department not found");
	    return;
	}
	System.out.println("Enter employee id :");
	int empId = inputScanner.nextInt();
	Employee employeeToRemove = null;
	for (Employee employee : department.getEmployees()) {
	    if (empId == employee.getEmpId()) {
		employeeToRemove = employee;
		break;
	    }
	}
	if (employeeToRemove != null) {
	    department.relieve(employeeToRemove);
	    System.out.println("Employee Removed");
	} else {
	    throw new CustomException("Employee not found");
	}
    }

    private static Department findDepartmentByName(String depNameString) {
	for (Department dept : organisation.getDepartments()) {
	    if (dept.getNameOfDepartementString().equalsIgnoreCase(depNameString))
		return dept;
	}
	return null;
    }

    private static void listAllEmployees() throws CustomException {
	try {
	    System.out.println("List of All the Employees");
		for (Employee employee : organisation.getAllEmployees()) {
		    System.out.println("ID :" + employee.getEmpId());
		    System.out.println("Name :" + employee.getNameString());
		    System.out.println("Department :" + getDepartmentNameForEmployee(employee));
		    System.out.println();

		}
	} catch (Exception e) {
	   throw new CustomException("Error in fetching all employees");
	}
    }

    private static String getDepartmentNameForEmployee(Employee employee) {
	for (Department department : organisation.getDepartments()) {
	    if (department.getEmployees().contains(employee))
		return department.getNameOfDepartementString();
	}
	return "Unkown";
    }
}
