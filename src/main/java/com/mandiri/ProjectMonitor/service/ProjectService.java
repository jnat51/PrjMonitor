package com.mandiri.ProjectMonitor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.project.Project;
import com.mandiri.ProjectMonitor.repository.DepartmentRepository;
import com.mandiri.ProjectMonitor.repository.ProjectRepository;
import com.mandiri.ProjectMonitor.repository.UserRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@Transactional
	public void insertProject(Project project) throws ErrorException {
		if (projectRepository.existsById(project.getId()) == true) {
			throw new ErrorException("Project already exist");
		}
		projectRepository.save(project);
	}

	@Transactional
	public void updateProject(Project project) throws ErrorException {
		if (projectRepository.existsById(project.getId()) == false) {
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

	public List<Project> findWithFilter(int projectYear, String name, long userId, long departmentId) throws ErrorException {
		return projectRepository.findAll(new Specification<Project>(){
			@Override
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (projectYear != 0) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("projectYear"), projectYear)));
				}
				if (!name.isEmpty()) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + name + "%")));
				}
				if (userId != 0)
				{
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("user"), userRepository.findById(userId).get())));
				}
				if (departmentId != 0)
				{
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("department"), departmentRepository.findById(departmentId).get())));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
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

	public List<Project> findByUser(long userId) throws ErrorException {
		return projectRepository.findByUser(userId);
	}
}