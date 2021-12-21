package com.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.Department;
import com.sp.dao.DepartmentDAO;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;
	public List<Department> getAllDepartments() {
		
		return departmentDAO.getAllDepartments();
	}

	
}
