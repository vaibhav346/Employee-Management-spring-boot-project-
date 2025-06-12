package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.LeaveApplication;
import com.Repository.LeaveApplicationRepository;

@Service
public class LeaveApplicationService {

	@Autowired
	private LeaveApplicationRepository repo;

	// 1. Save leave data
	public String saveLeave(LeaveApplication leave) {
		leave.setStatus("PENDING");
		repo.save(leave);
		return "You Applied for leave sucessfully";
	}

	// 2. findall leave data
	public List<LeaveApplication> getAllLeaves() {
		return repo.findAll();
	}

	// 3.update leave data
	public String updateLeave(int id, LeaveApplication leaveupdate) {
		LeaveApplication existingleave = repo.findById(id).orElse(null);
		if (existingleave == null) {
			return "No leave data found";
		}

		if (leaveupdate.getId() == 0 && leaveupdate.getEmployeeName() == null && leaveupdate.getReason() == null
				&& leaveupdate.getFromDate() == null && leaveupdate.getToDate() == null) {
			return "no leave updates found";
		}

		if (leaveupdate.getEmployeeName() != null) {
			existingleave.setEmployeeName(leaveupdate.getEmployeeName());
		}

		if (leaveupdate.getReason() != null) {
			existingleave.setReason(leaveupdate.getReason());
		}

		if (leaveupdate.getFromDate() != null) {
			existingleave.setFromDate(leaveupdate.getFromDate());
		}

		if (leaveupdate.getToDate() != null) {
			existingleave.setToDate(leaveupdate.getToDate());
		}

		repo.save(existingleave);
		return "Record updated sucessfully";
	}

	// 4. delete byid leave data
	public String deletebyid(int id) {
		repo.deleteById(id);
		return "Leave record delted sucessfully";
	}

	// 5. findleavebyid
	public LeaveApplication findleavebyid(int id) {
		return repo.findById(id).orElse(null);
	}

	// 6. findby employeeid
	public List<LeaveApplication> findbyemployeeid(Long id) {
		return repo.findByEmployeeId(id);
	}

	// 7. Leave approved
	public LeaveApplication approveleave(int leaveid) {
		LeaveApplication leave = repo.findById(leaveid).orElse(null);
		leave.setStatus("APPROVED");
		return repo.save(leave);
	}

	// 8. Reaject Leave
	public LeaveApplication rejectLeave(int leaveid) {
		LeaveApplication leave = repo.findById(leaveid).orElse(null);
		leave.setStatus("REJECTED");
		return repo.save(leave);
	}

}
