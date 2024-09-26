package com.example.cake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cake.entity.WishEntity;
import com.example.cake.model.Cart;
import com.example.cake.model.WishItem;
import com.example.cake.service.CartService;
import com.example.cake.service.WishService;

@RestController
@CrossOrigin(origins = "*")
public class wishController {
	
	@Autowired
	private WishService wishService;
	
	@PostMapping("/addItemToWishList")
	public ResponseEntity<Boolean> addTowish(@RequestBody WishItem wishItem) {
		wishService.addTowish(wishItem);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/getWish")
	public List<WishItem> getwishItem( Long userId){
		
		List<WishItem> response =	wishService.getWishList(userId);
		return response;
	}
	
	@GetMapping("/wish/itemCount")
	public Integer getItemCount(@RequestParam Long userId) {
		return wishService.getWishItemCountfromByUserId(userId);
	}
	
	@DeleteMapping("/wish/removeItem")
	public ResponseEntity<Boolean> removeItemFromWishList(@RequestParam Long wishItemId) {
		wishService.removeItemFromWishList(wishItemId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
