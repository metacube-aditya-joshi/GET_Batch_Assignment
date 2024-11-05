package inheritance.and.compostion;

class Developer extends Employee {

    private double basicSalary;

    public Developer(String nameString, int empID, double basicSalary) {
	super(nameString, empID);
	this.basicSalary = basicSalary;
    }

    @Override
    public double getBasicSalary() {
	return basicSalary;
    }

    @Override
    public double getBonus() {
	// TODO Auto-generated method stub
	return basicSalary * 0.2;
    }

    @Override
    public double getCompensation() {
	// TODO Auto-generated method stub
	return getBasicSalary() + getBonus();
    }
}

class Tester extends Employee {

    private double basicSalary;

    public Tester(String nameString, int empID, double basicSalary) {
	super(nameString, empID);
	this.basicSalary = basicSalary;
    }

    @Override
    public double getBasicSalary() {
	return basicSalary;
    }

    @Override
    public double getBonus() {
	// TODO Auto-generated method stub
	return basicSalary * 0.1;
    }

    @Override
    public double getCompensation() {
	// TODO Auto-generated method stub
	return getBasicSalary() + getBonus();
    }
}

class Manager extends Employee {

    private double basicSalary;

    public Manager(String nameString, int empID, double basicSalary) {
	super(nameString, empID);
	this.basicSalary = basicSalary;

    }

    @Override
    public double getBasicSalary() {
	return basicSalary;
    }

    @Override
    public double getBonus() {
	// TODO Auto-generated method stub
	return basicSalary * 0.25;
    }

    @Override
    public double getCompensation() {
	// TODO Auto-generated method stub
	return getBasicSalary() + getBonus();
    }
}
