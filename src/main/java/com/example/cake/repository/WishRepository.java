package com.example.cake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cake.entity.WishEntity;

public interface WishRepository extends JpaRepository<WishEntity ,Long>{
	
	List<WishEntity> findByUserId(Long userId);
	
	@Query("select count(w.id) from WishEntity w "
			+ "inner join w.user u where u.id = :userId")
	Integer findWishItemCountByUserId(Long userId);

}
