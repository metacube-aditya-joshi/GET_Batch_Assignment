package inheritance.and.compostion;

class ITDepartment extends Department {

    public ITDepartment(String nameOfDepartementString) {
	super("IT");

    }

}

class AdminDepartment extends Department {

    public AdminDepartment(String nameOfDepartementString) {
	super("Admin");

    }

}

class QADepartment extends Department {

    public QADepartment(String nameOfDepartementString) {
	super("QA");

    }

}