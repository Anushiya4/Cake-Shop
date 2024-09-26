package com.example.cake.entity;

import com.example.cake.model.WishItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "WishList")
public class WishEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private CakeEntity cake;
	
	@ManyToOne
	private UserEntity user;
	
	private Integer qty;
	
	private Boolean status;
	
	
	
	public WishEntity() {
		super();
	}

	public WishEntity(WishItem wishitem) {
		super();
		this.id = wishitem.getId();
		this.cake= new CakeEntity(wishitem.getCakeId());
		this.user = new UserEntity(wishitem.getUserId());
		this.qty = wishitem.getQty();
		this.status=true;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CakeEntity getCake() {
		return cake;
	}

	public void setCake(CakeEntity cake) {
		this.cake = cake;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	

}
