package com.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Employee;
import com.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository erepo;

	public String saveemployee(Employee e) {
		erepo.save(e);
		return "Employee added sucessfully";
	}

	public List<Employee> findall() {
		return erepo.findAll();
	}

	public Employee findbyid(int id) {
		return erepo.findById(id).orElse(null);

	}

	public List<Employee> findbyname(String name) {
		return erepo.findByName(name);
	}

	public List<Employee> findbydepartment(String dept) {
		return erepo.findByDepartment(dept);
	}

	public List<Employee> findbyroel(String role) {
		return erepo.findByRole(role);
	}

	public List<Employee> findbysalary(double sal) {
		return erepo.findBySalary(sal);
	}

	public List<Employee> findbysalarygreter(double sal) {
		return erepo.findBySalaryGreaterThan(sal);
	}

	public List<Employee> findbysalaryless(double sal) {
		return erepo.findBySalaryLessThan(sal);
	}

	public List<Employee> findbyjoindate(LocalDate date) {
		return erepo.findByJoiningdate(date);
	}

	public List<Employee> findbydob(LocalDate date) {
		return erepo.findByDob(date);
	}

	public String deletebyid(int id) {
		erepo.deleteById(id);
		return "Employee deleted sucessfully";
	}

	public String updatebyid(int id, Employee newdata) {

		Employee existingemployee = erepo.findById(id).orElse(null);
		if (existingemployee == null) {
			return "Employee is not found";
		}

		if (newdata.getEid() == 0 && newdata.getName() == null && newdata.getDepartment() == null
				&& newdata.getRole() == null && newdata.getEmail() == null && newdata.getContactno() == 0
				&& newdata.getAddress() == null && newdata.getSalary() == 0 && newdata.getJoiningdate() == null
				&& newdata.getDob() == null && newdata.getGender() == null && newdata.getImg() == null) {
			return "No New data provided for updataion";
		}

		if (newdata.getName() != null) {
			existingemployee.setName(newdata.getName());
		}

		if (newdata.getDepartment() != null) {
			existingemployee.setDepartment(newdata.getDepartment());
		}

		if (newdata.getRole() != null) {
			existingemployee.setRole(newdata.getRole());
		}

		if (newdata.getEmail() != null) {
			existingemployee.setEmail(newdata.getEmail());
		}

		if (newdata.getContactno() != 0) {
			existingemployee.setContactno(newdata.getContactno());
		}

		if (newdata.getAddress() != null) {
			existingemployee.setAddress(newdata.getAddress());
		}

		if (newdata.getSalary() != 0) {
			existingemployee.setSalary(newdata.getSalary());
		}

		if (newdata.getJoiningdate() != null) {
			existingemployee.setJoiningdate(newdata.getJoiningdate());
		}

		if (newdata.getDob() != null) {
			existingemployee.setDob(newdata.getDob());
		}

		if (newdata.getGender() != null) {
			existingemployee.setGender(newdata.getGender());
		}

		if (newdata.getImg() != null) {
			existingemployee.setImg(newdata.getImg());
		}

		erepo.save(existingemployee);
		return "Employee updated sucessfully";
	}

}
