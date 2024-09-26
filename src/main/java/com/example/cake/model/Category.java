/**
 * 
 */
package com.example.cake.model;

import com.example.cake.entity.CategoryEntity;

/**
 * 
 */
public class Category {
	
	private Long id;
	
	private String category;
	
	private String img;
	
	public Category() {
		super();
	}

	public Category(CategoryEntity categoryEntity) {
		super();
		this.id = categoryEntity.getId();
		this.category = categoryEntity.getCategoryName();
		this.img = categoryEntity.getImg();
	}
	
	public Category(Long id, String category, String img) {
		super();
		this.id = id;
		this.category = category;
		this.img = img;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
