package AngajatiApp.repository;

import java.util.List;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;

public interface EmployeeRepositoryInterface {

	boolean addEmployee(Employee employee);
	boolean modifyEmployeeFunction(Employee employee, DidacticFunction newFunction);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria();
	Employee findEmployeeById(int idOldEmployee);

}
