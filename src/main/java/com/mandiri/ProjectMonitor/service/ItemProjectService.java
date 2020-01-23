package com.mandiri.ProjectMonitor.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.itemProject.ItemProject;
import com.mandiri.ProjectMonitor.repository.CategoryRepository;
import com.mandiri.ProjectMonitor.repository.ItemProjectRepository;
import com.mandiri.ProjectMonitor.repository.ProjectRepository;

@Service
public class ItemProjectService {
	@Autowired
	ItemProjectRepository itemProjectRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Transactional
	public void insertItemProject(ItemProject itemProject) throws ErrorException {
		if (itemProjectRepository.existsById(itemProject.getId()) == true) {
			throw new ErrorException("Item Project already exist");
		}
		if (projectRepository.existsById(itemProject.getProject().getId()) == false) {
			throw new ErrorException("Project does not exist");
		}
		if (categoryRepository.existsById(itemProject.getCategory().getId()) == false) {
			throw new ErrorException("Wrong category");
		}
		if (itemProject.getStartPlan().isBefore(LocalDate.now()) /*&& itemProject.getStartAct().isBefore(LocalDate.now())*/
				&& itemProject.getEndPlan().isBefore(LocalDate.now())
				/*&& itemProject.getEndAct().isBefore(LocalDate.now())*/) {
			throw new ErrorException("Cannot input past date");
		}
		itemProjectRepository.save(itemProject);
	}

	@Transactional
	public void updateItemProject(ItemProject itemProject) throws ErrorException {
		if (itemProjectRepository.existsById(itemProject.getId()) == false) {
			throw new ErrorException("Item Project not found");
		}
		if (itemProjectRepository.findById(itemProject.getId()).get().getProject() != itemProject.getProject()) {
			throw new ErrorException("Project cannot be changed");
		}
		if (itemProjectRepository.findById(itemProject.getId()).get().getCategory() != itemProject.getCategory()) {
			throw new ErrorException("Category cannot be changed");
		}
		if(itemProjectRepository.findById(itemProject.getId()).get().getStartPlan() != itemProject.getStartPlan()){
			throw new ErrorException("Plan start date cannot be changed");
		}
		if(itemProjectRepository.findById(itemProject.getId()).get().getEndPlan() != itemProject.getEndPlan()){
			throw new ErrorException("Plan end date cannot be changed");
		}
		if (itemProject.getStartPlan().isBefore(LocalDate.now()) /*&& itemProject.getStartAct().isBefore(LocalDate.now())*/
				&& itemProject.getEndPlan().isBefore(LocalDate.now())
				/*&& itemProject.getEndAct().isBefore(LocalDate.now())*/) {
			throw new ErrorException("Cannot input past date");
		}
		itemProjectRepository.save(itemProject);
	}
	
	@Transactional
	public void deleteItemProject(ItemProject itemProject) throws ErrorException
	{
		if(itemProjectRepository.existsById(itemProject.getId()) == false) {
			throw new ErrorException("Item Project not found");
		}
		itemProjectRepository.delete(itemProject);
	}

	public void findById(long id) {
		itemProjectRepository.findById(id);
	}

	public void findAll() {
		itemProjectRepository.findAll();
	}
	
	public void findByProject(long projectId) {
		itemProjectRepository.findByProject(projectId);
	}
}
