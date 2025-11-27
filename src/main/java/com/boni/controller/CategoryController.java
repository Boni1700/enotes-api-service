package com.boni.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boni.dto.CatagoryDto;
import com.boni.dto.CatagoryResponse;
import com.boni.entity.table_catagory;
import com.boni.service.TableCategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	@Autowired
	private TableCategoryService categoryService;
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody CatagoryDto categoryDto)
	{
		Boolean savecatagory = categoryService.savecatagory(categoryDto);
		if(savecatagory)
		{
		return new ResponseEntity<>("saved successfully",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>("not saved",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/getcatagory")
	public ResponseEntity<?> getAllCategory()
	{
		List<CatagoryDto>  allcategory = categoryService.getAllCategory();
		if(org.springframework.util.CollectionUtils.isEmpty(allcategory))
		{
		return ResponseEntity.noContent().build();
		}
		else
		{
			return new ResponseEntity<>(allcategory,HttpStatus.OK);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id)
	{
	    try {
	        CatagoryDto dto = categoryService.getCategoryById(id);
	        return new ResponseEntity<>(dto, HttpStatus.OK);

	    } catch (RuntimeException e) {
	        return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	    }
	}
	@GetMapping("/active-catagory")
	public ResponseEntity<?> getActiveCategory()
	{
		List<CatagoryResponse>  allcategory = categoryService.getActiveCatagory();
		if(org.springframework.util.CollectionUtils.isEmpty(allcategory))
		{
		return ResponseEntity.noContent().build();
		}
		else
		{
			return new ResponseEntity<>(allcategory,HttpStatus.OK);
		}
		
	}

}
