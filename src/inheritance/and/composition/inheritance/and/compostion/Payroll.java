package inheritance.and.compostion;

public class Payroll {
    private static final double tax_rate = 0.15;

    public static double calculateTax(double salary) {
	return salary * tax_rate;
    }

    public static void printSalarySlip(Employee employee) {
	double compensation = employee.getCompensation();
	double tax = calculateTax(compensation);
	double netPay = compensation - tax;
	System.out.println("Salary Slip for Employee : " + employee.getNameString());
	System.out.println("Id : " + employee.getEmpId());
	System.out.println("Basic Salary : " + employee.getBasicSalary());
	System.out.println("Bonus : " + employee.getBonus());
	System.out.println("Compensation : " + employee.getCompensation());
	System.out.println("Tax : " + tax);
	System.out.println("Net Pay : " + netPay);
    }

    public static void printAllSalarySlips(Organisation organisation) {
	for (Employee employee : organisation.getAllEmployees()) {
	    printSalarySlip(employee);
	}
    }

}
