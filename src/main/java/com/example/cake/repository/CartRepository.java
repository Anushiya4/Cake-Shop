package com.example.cake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cake.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{

	List<CartEntity> findByUserIdAndStatus(Long userId, Boolean status);

	@Query("select count(c.id) from CartEntity c "
			+ "inner join c.user u where u.id = :userId and c.status = :status")
	Integer findActiveCartCountByUserId(Long userId, Boolean status);

}
