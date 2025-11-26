package com.boni.service;

import java.util.List;

import com.boni.dto.CatagoryDto;
import com.boni.entity.table_catagory;

public interface TableCategoryService {
	public Boolean savecatagory(CatagoryDto category);
	public List<CatagoryDto>  getAllCategory();
}
