package com.Controller;

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

import com.Entity.LeaveApplication;
import com.Service.LeaveApplicationService;

@RestController
@RequestMapping("/leave")
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveApplicatoinController {

	@Autowired
	LeaveApplicationService lser;

	@PostMapping("/apply")
	public String applyforleave(@RequestBody LeaveApplication l) {
		return lser.saveLeave(l);
	}

	@GetMapping("/findallleaves")
	public List<LeaveApplication> findallleaves() {
		return lser.getAllLeaves();
	}

	@PutMapping("/updateleave/{id}")
	public String updateleave(@PathVariable int id, @RequestBody LeaveApplication leaveupdate) {
		return lser.updateLeave(id, leaveupdate);
	}

	@DeleteMapping("/cancelleave/{id}")
	public String deleteleave(@PathVariable int id) {
		return lser.deletebyid(id);
	}

	@GetMapping("/findleavebyid/{id}")
	public LeaveApplication findleavebyid(@PathVariable int id) {
		return lser.findleavebyid(id);
	}

	@GetMapping("/findbyemployeeid/{id}")
	public List<LeaveApplication> findbyempid(@PathVariable Long id) {
		return lser.findbyemployeeid(id);
	}

	// approve leave (adin)
	@PutMapping("/approve/{id}")
	public LeaveApplication approveLeave(@PathVariable int id) {
		return lser.approveleave(id);
	}

	// reject leave(admin)

	@PutMapping("/reject/{id}")
	public LeaveApplication rejectleave(@PathVariable int id) {
		return lser.rejectLeave(id);
	}
}
