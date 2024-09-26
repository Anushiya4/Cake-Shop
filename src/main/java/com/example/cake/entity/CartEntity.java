package com.example.cake.entity;

import com.example.cake.model.Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private CakeEntity cake;
	
	@ManyToOne
	private UserEntity user;
	
	private Integer qty;
	
	private Boolean status;

	public CartEntity(Cart cart) {
		super();
		this.id =cart.getId();
		this.cake = new CakeEntity(cart.getCakeId());
		this.user = new UserEntity(cart.getUserId()) ;
		this.qty = cart.getQty();
		this.status = true;
	}

	public CartEntity() {
		super();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}
