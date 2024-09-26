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

import com.example.cake.model.Cart;
import com.example.cake.service.CartService;

@RestController
@CrossOrigin(origins = "*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<Boolean> addToCart(@RequestBody Cart cart) {
		cartService.addToCart(cart);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/cart/removeItem")
	public ResponseEntity<Boolean> removeItemFromCart(@RequestParam Long cartId) {
		cartService.removeItemFromCart(cartId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/getCart")
	public List<Cart> getCart(@RequestParam Long userId) {
		return cartService.getCartByUserId(userId);
	}

	@GetMapping("/cart/itemCount")
	public Integer getItemCount(@RequestParam Long userId) {
		return cartService.getItemCountfromCartByUserId(userId);
	}

}
