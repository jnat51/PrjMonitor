package com.mandiri.ProjectMonitor.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.Department;
import com.mandiri.ProjectMonitor.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Transactional
	public void insertDepartment(Department department) throws ErrorException
	{
		if(departmentRepository.existsById(department.getId())==true)
		{
			throw new ErrorException("Department already exist");
		}
		if(departmentRepository.findByDepartmentCode(department.getDepartmentCode())!=null)
		{
			throw new ErrorException("Duplicate department code");
		}
		departmentRepository.save(department);
	}
	
	@Transactional
	public void updateDepartment(Department department) throws ErrorException
	{
		if(departmentRepository.existsById(department.getId())==false)
		{
			throw new ErrorException("Department does not exist");
		}
	}
	
	@Transactional
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
	
	public Department findByDepartmentCode(String departmentCode) {
		if(departmentRepository.findByDepartmentCode(departmentCode)==null)
		{
			return new Department();
		}
		return departmentRepository.findByDepartmentCode(departmentCode);
	}
}