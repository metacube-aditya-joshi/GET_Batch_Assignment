package inheritance.and.composition;

import java.util.Scanner;

final class Employee extends AbstractEmployee {
    static int incrementer = 0;
    final String empNameString;
    final int empId;
    final int departmentId;
    final float basicSalary = 0;
    final float bonus = 0;
    final float compensation = 0;

    public Employee(String empNameString, String departmentName) throws CustomException {
	this.empNameString = empNameString;
	this.empId = ++incrementer;
	this.departmentId = Organization.getDepartmentId(departmentName);

    }

    Employee createEmployee() throws CustomException {
	Employee newEmployee = null;
	try (Scanner inputScanner = new Scanner(System.in)) {
	    System.out.println("Enter Employee details :");
	    System.out.println("Enter employee name :");
	    String empNameString = inputScanner.next();

	    System.out.println("Enter Department name :");
	    String depNameString = inputScanner.next();

	    newEmployee = new Employee(empNameString, depNameString);

	} catch (Exception e) {
	    throw new CustomException("Error in creating new Employee");
	}

	return newEmployee;

    }

    @Override
    float getBasicSalary(float basicSalary) {
	// TODO Auto-generated method stub
	return this.basicSalary;
    }

    @Override
    float getBonus(float bonus) {
	// TODO Auto-generated method stub
	return this.bonus;
    }

    @Override
    float getCompensation(float compensation) {
	// TODO Auto-generated method stub
	return this.compensation;
    }

}

