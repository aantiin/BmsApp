package id.web.antin.service.impl;

import id.web.antin.dao.CategoryDao;
import id.web.antin.model.Category;
import id.web.antin.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CategoryService")
public class CategoryServiceImpl extends CommonServiceImpl<Category, Long> implements CategoryService{
	private CategoryDao categoryDao;
	
	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		super(categoryDao);
		this.categoryDao = categoryDao;
	}
}
