/**
 * 
 */
package com.example.cake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cake.entity.CategoryEntity;

/**
 * 
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
