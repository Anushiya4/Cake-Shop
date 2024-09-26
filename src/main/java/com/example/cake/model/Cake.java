/**
 * 
 */
package com.example.cake.model;

import java.math.BigDecimal;

import com.example.cake.entity.CakeEntity;

/**
 * 
 */
public class Cake {


	private Long id;
	private Long category;
	private String img;
	private String title;
	private String description;
	private BigDecimal price;
	private Integer qty;
	
	public Cake() {
		super();
		
	}
	
	public Cake(CakeEntity cakeEntity) {
		super();
		this.id = cakeEntity.getId();
		this.category = cakeEntity.getCategory().getId();
		this.img = cakeEntity.getImg();
		this.title = cakeEntity.getTitle();
		this.description = cakeEntity.getDescription();
		this.price = cakeEntity.getPrice();
		this.qty = cakeEntity.getQty();
	}
	
	public Cake(Long id, Long category, String img, String title, String description, BigDecimal price,
			Integer qty) {
		super();
		this.id = id;
		this.category = category;
		this.img = img;
		this.title = title;
		this.description = description;
		this.price = price;
		this.qty = qty;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
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
