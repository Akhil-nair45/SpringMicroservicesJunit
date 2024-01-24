package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Category;

public interface CategoryService {

	
	public Category addCategory(Category cat);
	public Category editCategory(Category cat);
	public List<Category> allCategory();
	public String deleteCategory(Integer id);
	public Category getCategoryById(Integer id);
	
	
}
