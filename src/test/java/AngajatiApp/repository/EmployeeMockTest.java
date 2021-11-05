package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.controller.EmployeeController;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    private Employee employee;
    int nrAngajati;
    private EmployeeController employeeCtrl;
    private EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employee=new Employee();
        employee.setId(1);
        employee.setFirstName("Amelia");
        employee.setLastName("Faran");
        employee.setCnp("2540810035478");
        employee.setFunction(DidacticFunction.TEACHER);
        employee.setSalary(1.0d);
        employeeMock= new EmployeeMock();
        employeeCtrl = new EmployeeController(employeeMock);
        nrAngajati= employeeCtrl.getEmployeesList().size();
        System.out.println("SetUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TearDown");
    }

    @Test
    void addEmployeeTC1() {
        try {
            employeeCtrl.addEmployee(employee);
            assert (true);
            assertEquals(nrAngajati+1,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
        }catch(Exception e){
            assert(false);
            System.out.println("Angajatul nu a fost adaugat desi trebuia sa fie adaugat");
        }
        //assertEquals(true,employeeCtrl,"The Emloyee was not added but it should have beed added.");
        //assertEquals(1,employeeCtrl.getEmployeesList().size(),"Ar trebui sa existe 1 angajat adaugat dar numarul angajatilor este diferit.");
        //System.out.println("Angajatul s-a adaugat cu succes - Nr angajatilor este: "+ employeeCtrl.getEmployeesList().size());
    }
    @Test
    void addEmployeeTC2() {
        //	Faran	Amelia	5548855448841	ASISTANT		2	TRUE
        employee.setSalary(2.0d);
        try {
            employeeCtrl.addEmployee(employee);
            assert (true);
            assertEquals(nrAngajati+1,employeeCtrl.getEmployeesList().size(),"Angajatul nu s-a adaugat desi trebuia.");
        }catch(Exception e){
            assert(false);
            System.out.println("Angajatul nu a fost adaugat desi trebuia sa fie adaugat");
        }
    }

    @Test
    void addEmployeeTC3() {
        //Faran	Amelia	null	ASISTENT		0	FALSE
        employee.setCnp("");
        employee.setSalary(0.0);

        employeeCtrl.addEmployee(employee);
        System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");

    }
    @Test
    void addEmployeeTC4() {
        //null	Amelia	554885544884	ASISTENT		2	FALSE
        employee.setLastName("");
        employee.setCnp("554885544884");
        employee.setSalary(2.00);

        employeeCtrl.addEmployee(employee);
        //System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
    }
    @Test
    void addEmployeeTC5() {
        //null	Amelia	55488554488415	ASISTENT		1
        employee.setLastName("");
        employee.setCnp("55488554488415");
        employee.setSalary(1.00);

        employeeCtrl.addEmployee(employee);
        //System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
    }
    @Test
    void addEmployeeTC6() {
        // null	Amelia	null	ASISTENT		0	FALSE
        employee.setLastName("");
        employee.setCnp("");
        employee.setSalary(0d);
        employeeCtrl.addEmployee(employee);
        //System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
    }

    @Test
    void addEmployeeTC7() {
        // 	1	Faran	Amalia	null	ASISTENT		1	FALSE	FALSE
        employee.setCnp("");
        employeeCtrl.addEmployee(employee);
        //System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
    }
    @Test
    void addEmployeeTC8() {
        //	1	Faran	Amalia	554885544884	ASISTENT		1	FALSE	FALSE
        employee.setCnp("554885544884");
        employeeCtrl.addEmployee(employee);
        //System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
    }
    @Test
    void addEmployeeTC9() {
        //	1	Faran	Amalia	55488554488415	ASISTENT		1	FALSE	FALSE
        employee.setCnp("55488554488415");
        employeeCtrl.addEmployee(employee);
        //System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
    }
    @Test
    void addEmployeeTC10() {
        //	1	Faran	Amalia	5548855448841	ASISTENT			FALSE	FALSE
        employee.setSalary(0d);
        employeeCtrl.addEmployee(employee);
        //System.out.println(employeeCtrl.getEmployeesList().size());
        assertEquals(nrAngajati,employeeCtrl.getEmployeesList().size(),"Angajatul s-a adaugat desi nu trebuia.");
    }

    @Test
    void modifyEmployeeFunctionTC02(){
        employeeMock.modifyEmployeeFunction(employeeMock.findEmployeeById(2),DidacticFunction.TEACHER);
        assertEquals(DidacticFunction.TEACHER,employeeMock.findEmployeeById(2).getFunction(),"Didactic function ar trebui sa fie teacher dar nu este");
    }

    @Test
    void modifyEmployeeFunctionTC01(){
        DidacticFunction function=null;
        employeeMock.modifyEmployeeFunction(employeeMock.findEmployeeById(1009),DidacticFunction.TEACHER);
        assertEquals(null,employeeMock.findEmployeeById(1009),"Nu exista employee cu id ul 1009");
    }

    @Test
    void modifyEmployeeFunctionTC03(){
        Employee nullEmp=new Employee();
        nullEmp.setId(2000);
        employeeMock.addEmployee(nullEmp);
        employeeMock.modifyEmployeeFunction(employeeMock.findEmployeeById(2000),DidacticFunction.TEACHER);
        assertEquals(false,employeeMock.modifyEmployeeFunction(employeeMock.findEmployeeById(2000),DidacticFunction.TEACHER),"Nu exista employee cu id ul 1009");
    }
}