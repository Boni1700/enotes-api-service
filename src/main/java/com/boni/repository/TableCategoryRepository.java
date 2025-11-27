package com.boni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boni.entity.table_catagory;

public interface TableCategoryRepository extends JpaRepository<table_catagory, Integer> {


@Query(value = "SELECT * FROM table_catagory WHERE is_active = true AND is_deleted = false", nativeQuery = true)
    List<table_catagory> findActiveCategoriesNative();

}
