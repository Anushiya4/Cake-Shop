/**
 * 
 */
package com.example.cake.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cake.entity.UserEntity;
import com.example.cake.model.User;
import com.example.cake.repository.UserRepository;

/**
 * 
 */
@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	public void saveUser(UserEntity user) {
		userRepository.save(user);
	}

	public Long login(User user) {
		UserEntity userEntity = userRepository.findByEmail(user.getEmail());
		if (userEntity != null) {
			if (userEntity.getEmail().equals(user.getEmail())) {
				if (userEntity.getPassword().equals(user.getPassword())) {
					return userEntity.getId();				}
			}
		}
		return null;
	}
	
	public User getUser(Long userId) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			return new User(userOptional.get());
		}
		return null;
	}
	
	public void updateUser(User user) {
		Optional<UserEntity> userOptional = userRepository.findById(user.getId());
		if (userOptional.isPresent()) {
			UserEntity userEntity = userOptional.get();
			userEntity.setName(user.getName());
			userEntity.setEmail(user.getEmail());
			userEntity.setPhone(user.getPhone());
			userEntity.setAddress(user.getAddress());
			userRepository.save(userEntity);
		}
	}

}
