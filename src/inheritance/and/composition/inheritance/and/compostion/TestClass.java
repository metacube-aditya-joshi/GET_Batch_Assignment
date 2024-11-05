package inheritance.and.compostion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestClass {
    Organisation organisation;
    ITDepartment itDepartment;
    AdminDepartment adminDepartment;
    QADepartment qaDepartment;
Department department;
    @BeforeEach
    public void initialisor() {
        organisation = new Organisation("MetaCube");
        itDepartment = new ITDepartment(null);
        adminDepartment = new AdminDepartment(null);
        qaDepartment = new QADepartment(null);
        organisation.addDepartment(adminDepartment);
        organisation.addDepartment(itDepartment);
        organisation.addDepartment(qaDepartment);
        department= new Department(null);
    }
 
    @Test
    public void testAddDepartement(){

        List<Department> departements= organisation.getDepartments();
        assertEquals(3, departements.size());
        assertTrue(departements.contains(itDepartment));
        assertFalse(departements.contains(department));
    }

    @Test
    public void testAddEmployeeToDepartment(){
        Developer developer = new Developer("Aditya", 0, 0);
        assertTrue(itDepartment.join(developer));

        List<Employee> itEmployees = itDepartment.getEmployees();
        assertEquals(1, itEmployees.size());
        assertEquals("Aditya", itEmployees.get(0).getNameString());
    }
    @Test
    public void testRelieveEmployeeFromDepartment() {
        // Add and then relieve an employee
        Developer developer = new Developer("Alice", 101, 5000);
        itDepartment.join(developer);
        assertTrue(itDepartment.relieve(developer));

        // Verify employee is removed
        List<Employee> itEmployees = itDepartment.getEmployees();
        assertTrue(itEmployees.isEmpty());
    }

    @Test
    public void testGetAllEmployeesFromOrganization() {
        // Add employees to different departments
        Developer developer = new Developer("Alice", 101, 5000);
        Manager manager = new Manager("Bob", 102, 7000);
        itDepartment.join(developer);
        adminDepartment.join(manager);

        // Check if organization aggregates all employees
        List<Employee> allEmployees = organisation.getAllEmployees();
        assertEquals(2, allEmployees.size());
        assertTrue(allEmployees.contains(developer));
        assertTrue(allEmployees.contains(manager));
    }

    @Test
    public void testDeveloperSalaryComponents() {
        Developer developer = new Developer("Alice", 101, 5000);
        assertEquals(5000, developer.getBasicSalary(), 0.01);
        assertEquals(500, developer.getBonus(), 0.01);
        assertEquals(5500, developer.getCompensation(), 0.01);
    }

    @Test
    public void testManagerSalaryComponents() {
        Manager manager = new Manager("Bob", 102, 7000);
        assertEquals(7000, manager.getBasicSalary(), 0.01);
        assertEquals(1400, manager.getBonus(), 0.01);
        assertEquals(8400, manager.getCompensation(), 0.01);
    }

    @Test
    public void testPayrollTaxCalculation() {
        // Test tax calculation at 15% rate
        double compensation = 5500; // Example compensation
        double expectedTax = compensation * 0.15;
        assertEquals(expectedTax, Payroll.calculateTax(compensation), 0.01);
    }

    @Test
    public void testPayrollPrintSalarySlip() {
        // Add a Developer and test their salary slip output
        Developer developer = new Developer("Alice", 101, 5000);
        itDepartment.join(developer);

        // Mock system output (for demonstration purposes, actual test would use a print stream)
        System.out.println("---- Expected Salary Slip ----");
        Payroll.printSalarySlip(developer);
    }

    @Test
    public void testPrintAllSalarySlips() {
        // Add employees to the organization
        Developer developer = new Developer("Alice", 101, 5000);
        Manager manager = new Manager("Bob", 102, 7000);
        itDepartment.join(developer);
        adminDepartment.join(manager);

        // Mock system output for demonstration
        System.out.println("---- Expected All Salary Slips ----");
        Payroll.printAllSalarySlips(organisation);
    }
}
