package com.mandiri.ProjectMonitor.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.project.Project;
import com.mandiri.ProjectMonitor.model.user.User;
import com.mandiri.ProjectMonitor.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	@Transactional
	public void insertProject(Project project) throws ErrorException {
		if (projectRepository.existsById(project.getId()) == true) {
			throw new ErrorException("Project already exist");
		}
		projectRepository.save(project);
	}

	@Transactional
	public void updateProject(Project project) throws ErrorException {
		if (projectRepository.findById(project.getId()) == null) {
			throw new ErrorException("Project not found");
		}
		if (projectRepository.findByProjectCode(project.getProjectCode()) == null) {
			throw new ErrorException("Project code cannot be changed");
		}
		if (projectRepository.findById(project.getId()).get().getDateCreated() != projectRepository
				.findByProjectCode(project.getProjectCode()).getDateCreated()) {
			throw new ErrorException("Created cannot be changed");
		}
		projectRepository.save(project);
	}

	public List<Project> findAll() throws ErrorException {
		if (projectRepository.findAll().size() == 0) {
			return new ArrayList<Project>();
		}
		return projectRepository.findAll();
	}

	public Optional<Project> findById(long id) throws ErrorException {
		return projectRepository.findById(id);
	}

	public Project findByProjectCode(String projectCode) throws ErrorException {
		return projectRepository.findByProjectCode(projectCode);
	}
}