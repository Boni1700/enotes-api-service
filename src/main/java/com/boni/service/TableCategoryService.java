package com.boni.service;

import java.util.List;

import com.boni.entity.table_catagory;

public interface TableCategoryService {
	public Boolean savecatagory(table_catagory category);
	public List<table_catagory> getAllCategory();
}
