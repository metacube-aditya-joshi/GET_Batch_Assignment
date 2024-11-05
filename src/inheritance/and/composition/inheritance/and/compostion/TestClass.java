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
    public void testAddEmployeeTODepartment(){
        Developer developer = new Developer("Aditya", 0, 0);
        assertTrue(itDepartment.join(developer));

        List<Employee> itEmployees = itDepartment.getEmployees();
        assertEquals(1, itEmployees.size());
        assertEquals("Aditya", itEmployees.get(0).getNameString());
    }
}
