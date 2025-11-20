package com.boni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boni.entity.table_catagory;
import com.boni.repository.TableCategoryRepository;
import com.boni.service.TableCategoryService;

@Service
public class TableCategoryServiceImpl implements TableCategoryService{

	@Autowired
	private TableCategoryRepository categoryRepo;
	@Override
	public Boolean savecatagory(table_catagory category) {
		category.setIsDeleted(false);
		table_catagory saveCategory = categoryRepo.save(category);
		if(ObjectUtils.isEmpty(saveCategory))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public List<table_catagory> getAllCategory() {		
		List<table_catagory> allCatagories = categoryRepo.findAll();
		return allCatagories;
	}

}
