package com.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByName(String name);

	public List<Employee> findByDepartment(String dept);

	public List<Employee> findByRole(String role);

	public List<Employee> findBySalary(double salary);

	public List<Employee> findBySalaryGreaterThan(double sal);

	public List<Employee> findBySalaryLessThan(double sal);

	public List<Employee> findByJoiningdate(LocalDate date);

	public List<Employee> findByDob(LocalDate date);

}
