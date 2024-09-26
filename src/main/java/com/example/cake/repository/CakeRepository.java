/**
 * 
 */
package com.example.cake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cake.entity.CakeEntity;

/**
 * 
 */
public interface CakeRepository extends JpaRepository<CakeEntity, Long> {

	List<CakeEntity> findByCategoryId(Long categoryId);

	@Query("select c from CakeEntity c where c.category.id in "
			+ "(select cd.category.id from CakeEntity cd where cd.id = :cakeId) "
			+ "and c.id <> :cakeId")
	List<CakeEntity> getSimilarCategoryCakes(Long cakeId);
	
}
