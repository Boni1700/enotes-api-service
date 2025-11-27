package com.boni.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boni.dto.CatagoryDto;
import com.boni.dto.CatagoryResponse;
import com.boni.entity.table_catagory;
import com.boni.repository.TableCategoryRepository;
import com.boni.service.TableCategoryService;

@Service
public class TableCategoryServiceImpl implements TableCategoryService{

	@Autowired
	private TableCategoryRepository categoryRepo;
	@Override
	public Boolean savecatagory(CatagoryDto categoryDto) {
		table_catagory catagory=new table_catagory();
		catagory.setCatagoryName(categoryDto.getCatagoryName());
		catagory.setDescription(categoryDto.getDescription());
		catagory.setIsActive(true);
		catagory.setIsDeleted(false);
		catagory.setCreatedBy(1);
		catagory.setCreatedOn(new Date());
		table_catagory saveCategory = categoryRepo.save(catagory);
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
	public List<CatagoryDto> getAllCategory() {		
		List<table_catagory> allCatagories = categoryRepo.findAll();
		List<CatagoryDto> dtoList = new ArrayList();
		
		for(table_catagory tableCatagory : allCatagories)
		{
			CatagoryDto catdto=new CatagoryDto();
			catdto.setCatagoryName(tableCatagory.getCatagoryName());
			catdto.setDescription(tableCatagory.getDescription());
			catdto.setId(tableCatagory.getId());
			
			dtoList.add(catdto);
			
		}		
		return dtoList;
	}

	@Override
	public List<CatagoryResponse> getActiveCatagory() {
       List<table_catagory> allCategories = categoryRepo.findActiveCategoriesNative();
       List<CatagoryResponse> catResponseList = new ArrayList<CatagoryResponse>();
       for(table_catagory tc: allCategories)
       {
       CatagoryResponse catResponse = new CatagoryResponse();
       catResponse.setId(tc.getId());
       catResponse.setDescription(tc.getDescription());
       catResponse.setName(tc.getCatagoryName());
       catResponseList.add(catResponse);
       }
       
    return catResponseList;

	}

	
	@Override
	public CatagoryDto getCategoryById(Integer id) {

	    table_catagory tc = categoryRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Category not found"));

	    CatagoryDto dto = new CatagoryDto();
	    dto.setId(tc.getId());
	    dto.setCatagoryName(tc.getCatagoryName());
	    dto.setDescription(tc.getDescription());

	    return dto;
	}


}
