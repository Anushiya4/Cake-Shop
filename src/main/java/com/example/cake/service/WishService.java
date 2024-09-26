package com.example.cake.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.cake.entity.WishEntity;

import com.example.cake.model.WishItem;
import com.example.cake.repository.WishRepository;

@Service
public class WishService {
	@Autowired
	public WishRepository wishRepository;
	
	public void addTowish(WishItem wishItem) {
		WishEntity wishEntity = new WishEntity(wishItem);
		wishRepository.save(wishEntity);
	}
	
	 public List<WishItem> getWishList(Long userId) {
		 
		 List<WishEntity> wishEntityList = wishRepository.findByUserId(userId);
		 List<WishItem> wishItem = new ArrayList<WishItem>();
		 for(WishEntity wishEntity:wishEntityList) {
			 
			 WishItem www = new WishItem(wishEntity);
			 wishItem.add(www);
			 
			 
		 }
		 return wishItem;
		 
	 }
	 
	 public Integer getWishItemCountfromByUserId(Long userId) {
		return wishRepository.findWishItemCountByUserId(userId);
	 }
	 
	 public void removeItemFromWishList(Long wishListId) {
		 wishRepository.deleteById(wishListId);
	 }

}
