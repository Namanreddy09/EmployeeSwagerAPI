package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;


@Service
public class EmployeeImpService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	
	public List<Employee> listEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee fetchEmployeeById(Long employeeID) {

		return employeeRepository.findById(employeeID).get();
	}

	@Override
	public String deleteEmployee(Long employeeID) {
		Employee e = employeeRepository.findById(employeeID).get();
		employeeRepository.delete(e);
		return "Employee Record Deleted";
	}

	@Override
	public Employee editEmployee(Long employeeID, Employee employee) {

		Employee e = employeeRepository.findById(employeeID).get();
		if (Objects.nonNull(employee.getEmployeeName()) && !"".equals(employee.getEmployeeName())) {
			e.setEmployeeName(employee.getEmployeeName());
		}
		if (Objects.nonNull(employee.getEmployeeEmail()) && !"".equals(employee.getEmployeeEmail())) {
			e.setEmployeeEmail(employee.getEmployeeEmail());
		}
//		if (Objects.nonNull(employee.getEmployeePhone()) && !"".equals(employee.getEmployeePhone())) {
//			e.setEmployeePhone(employee.getEmployeePhone());
//		}

		return employeeRepository.save(e);
	}

}
