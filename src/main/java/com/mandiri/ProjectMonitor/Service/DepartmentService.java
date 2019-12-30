package com.mandiri.ProjectMonitor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.ProjectMonitor.model.Department;
import com.mandiri.ProjectMonitor.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public void insertDepartment(Department department)
	{
		departmentRepository.save(department);
	}
	
	public void deleteDepartment(Department department)
	{
		departmentRepository.delete(department);
	}
	
	public Optional<Department> findById(long id)
	{
		return departmentRepository.findById(id);
	}
	
	public List<Department> findAll(){
		return departmentRepository.findAll();
	}
}