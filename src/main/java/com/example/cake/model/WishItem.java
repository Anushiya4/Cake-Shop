package com.example.cake.model;

import com.example.cake.entity.WishEntity;

public class WishItem {
	private long id;
	private long cakeId;
	private long userId;
	private int qty;
	private Cake cake;
	
	
	public WishItem() {
		super();
	}
	
	public WishItem(WishEntity wishEntity) {
		super();
		
		this.id = wishEntity.getId();
		this.cakeId = wishEntity.getCake().getId();
		this.userId = wishEntity.getUser().getId();
		this.qty = wishEntity.getQty();
		this.cake =  new Cake(wishEntity.getCake());
		
	}


	public WishItem(long id, long cakeId, long userId, int qty, Cake cake) {
		super();
		this.id = id;
		this.cakeId = cakeId;
		this.userId = userId;
		this.qty = qty;
		this.cake = cake;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}
	
	
	
	
	

}
