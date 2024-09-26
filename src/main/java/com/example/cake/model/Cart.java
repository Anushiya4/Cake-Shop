package com.example.cake.model;

import com.example.cake.entity.CartEntity;

public class Cart {
	
	private long id;
	private long cakeId;
	private long userId;
	private int qty;
	private Cake cake;
	
	public Cart() {
		super();
	}

	public Cart(CartEntity cartentity) {
		super();
		this.id =cartentity.getId() ;
		this.cakeId = cartentity.getCake().getId();
		this.userId = cartentity.getUser().getId();
		this.qty = cartentity.getQty();
		this.cake = new Cake(cartentity.getCake());
	}

	public Cart(long id, long cakeId, long userId, int qty) {
		super();
		this.id = id;
		this.cakeId = cakeId;
		this.userId = userId;
		this.qty = qty;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public long getCakeId() {
		return cakeId;
	}

	public void setCakeId(long cakeId) {
		this.cakeId = cakeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}

}
