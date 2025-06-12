package com.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Employee;
import com.Service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService eser;

	@PostMapping("/save")
	public String saveemployee(@RequestBody Employee e) {
		return eser.saveemployee(e);
	}

	@GetMapping("/findall")
	public List<Employee> findall() {
		return eser.findall();
	}

	@GetMapping("/findbyid/{id}")
	public Employee findbyid(@PathVariable int id) {
		return eser.findbyid(id);
	}

	@GetMapping("/findbyname/{name}")
	public List<Employee> findbyname(@PathVariable String name) {
		return eser.findbyname(name);
	}

	@GetMapping("/findbydepartment/{dep}")
	public List<Employee> findbydepartment(@PathVariable String dep) {
		return eser.findbydepartment(dep);
	}

	@GetMapping("/findbyrole/{role}")
	public List<Employee> findbyfor(@PathVariable String role) {
		return eser.findbyroel(role);
	}

	@GetMapping("/findbysalary/{sal}")
	public List<Employee> findbysalary(@PathVariable double sal) {
		return eser.findbysalary(sal);
	}

	@GetMapping("/findbysalarygreter/{sal}")
	public List<Employee> findbysalarygreter(@PathVariable double sal) {
		return eser.findbysalarygreter(sal);
	}

	@GetMapping("/findbysalaryless/{sal}")
	public List<Employee> findbysalaryless(@PathVariable double sal) {
		return eser.findbysalaryless(sal);
	}

	@GetMapping("/findbyjoindate/{date}")
	public List<Employee> findbyjoindate(@PathVariable LocalDate date) {
		return eser.findbyjoindate(date);
	}

	@GetMapping("/findbydob/{dob}")
	public List<Employee> findbydob(@PathVariable LocalDate dob) {
		return eser.findbydob(dob);
	}

	@DeleteMapping("/deletebyid/{id}")
	public String deletebyid(@PathVariable int id) {
		return eser.deletebyid(id);
	}

	@PutMapping("/updatebyid/{id}")
	public String updatebyid(@PathVariable int id, @RequestBody Employee newdata) {
		return eser.updatebyid(id, newdata);
	}

}
