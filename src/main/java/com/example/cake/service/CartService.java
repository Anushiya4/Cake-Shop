package com.example.cake.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cake.entity.CartEntity;
import com.example.cake.model.Cart;
import com.example.cake.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;

	public void addToCart(Cart cart) {
		CartEntity cartEntity = new CartEntity(cart);
		cartRepository.save(cartEntity);
	}
	
	public void removeItemFromCart(Long cartId) {
		cartRepository.deleteById(cartId);
	}

	public List<Cart> getCartByUserId(Long userId) {
		List<CartEntity> cartEntityList = cartRepository.findByUserIdAndStatus(userId, true);
		List<Cart> response = new ArrayList<Cart>();
		for (CartEntity cartEntity : cartEntityList) {
			response.add(new Cart(cartEntity));
		}
		return response;
	}
	
	public Integer getItemCountfromCartByUserId(Long userId) {
		return cartRepository.findActiveCartCountByUserId(userId, true);
	}
}
