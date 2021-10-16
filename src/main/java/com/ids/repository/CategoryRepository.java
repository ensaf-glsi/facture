package com.ids.repository;

import org.springframework.data.repository.CrudRepository;

import com.ids.entity.Category;

public interface CategoryRepository 
		extends CrudRepository<Category, String> {

}
