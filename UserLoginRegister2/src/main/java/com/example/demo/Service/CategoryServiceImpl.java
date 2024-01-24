package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo cr;

	@Override
	public Category addCategory(Category cat) {
		return cr.save(cat);
	}

	@Override
	public Category editCategory(Category cat) {
		return cr.save(cat);
	}

	@Override
	public List<Category> allCategory() {
		return cr.findAll();
	}

	@Override
	public String deleteCategory(Integer id) {
		Category cat= cr.findById(id).get();
		if(cat!=null)
		{
			cr.delete(cat);
			return "Category deleted successfully!!";
		}
		return "Some error occured!";
	}

	@Override
	public Category getCategoryById(Integer id) {
		return cr.findById(id).get();
	}
	
	
}
