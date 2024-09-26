/**
 * 
 */
package com.example.cake.entity;

import com.example.cake.model.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String categoryName;
	
	private String img;
	
	public CategoryEntity() {
		super();
	}
	
	public CategoryEntity(Long id) {
		super();
		this.id = id;
	}
	
	public CategoryEntity(Category category) {
		super();
		this.id = category.getId();
		this.categoryName = category.getCategory();
		this.img = category.getImg();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
