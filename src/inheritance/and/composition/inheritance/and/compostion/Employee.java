package inheritance.and.compostion;

abstract class Employee {
    private String nameString;
    private int empId;

    public Employee(String nameString, int empID) {
	this.setNameString(nameString);
	this.setEmpId(empID);

    }

    public int getEmpId() {
	return empId;
    }

    public void setEmpId(int empId) {
	this.empId = empId;
    }

    public String getNameString() {
	return nameString;
    }

    public void setNameString(String nameString) {
	this.nameString = nameString;
    }

    public abstract double getBasicSalary();

    public abstract double getBonus();

    public abstract double getCompensation();

}
