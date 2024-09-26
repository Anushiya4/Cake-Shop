
/**
 * 
 */
package com.example.cake.entity;

import java.math.BigDecimal;

import com.example.cake.model.Cake;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "cake")
public class CakeEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private CategoryEntity category;
	
	private String img;
	private String title;
	@Column(columnDefinition = "longtext")
	private String description;
	private BigDecimal price;
	private Integer qty;
	
	public CakeEntity() {
		super();
	}
	
	public CakeEntity(Long id) {
		super();
		this.id = id;
	}
	
	public CakeEntity(Cake cake) {
		super();
		this.id = cake.getId();
		this.category = new CategoryEntity(cake.getCategory());
		this.img = cake.getImg();
		this.title = cake.getTitle();
		this.description = cake.getDescription();
		this.price = cake.getPrice();
		this.qty = cake.getQty();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}
