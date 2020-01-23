package com.mandiri.ProjectMonitor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.Category;
import com.mandiri.ProjectMonitor.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Transactional
	public void insertCategory(Category category) throws ErrorException {
		if(categoryRepository.existsById(category.getId())==true) {
			throw new ErrorException("Category already exist");
		}
		if(categoryRepository.findByCategory(category.getCategory()).getCategory().equals(category.getCategory())==true)
		{
			throw new ErrorException("Category already exist");
		}
		categoryRepository.save(category);
	}
	
	@Transactional
	public void updateCategory(Category category) throws ErrorException {
		if(categoryRepository.existsById(category.getId())==false) {
			throw new ErrorException("Category not found");
		}
	}
	
	public List<Category> findAll() throws ErrorException {
		if(categoryRepository.findAll().size()==0) {
			return new ArrayList<Category>();
		}
		return categoryRepository.findAll();
	}

	public Optional<Category> findById(long id) throws ErrorException {
		return categoryRepository.findById(id);
	}
	
	public Category findByCategory(String category) throws ErrorException {
		return categoryRepository.findByCategory(category);
	}
}