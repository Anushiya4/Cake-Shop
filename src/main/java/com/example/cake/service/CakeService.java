/**
 * 
 */
package com.example.cake.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cake.entity.CakeEntity;
import com.example.cake.entity.CategoryEntity;
import com.example.cake.model.Cake;
import com.example.cake.model.Category;
import com.example.cake.repository.CakeRepository;
import com.example.cake.repository.CategoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * 
 */
@Service
public class CakeService {

	@Autowired
	private CakeRepository cakeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private EntityManager em;
	
	public CategoryEntity saveCategory(Category category) {
		CategoryEntity categoryEntity = new CategoryEntity(category);
		return categoryRepository.save(categoryEntity);
	}
	
	public List<Category> getCategories() {
		List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
		List<Category> responseList = new ArrayList<Category>();
		for(CategoryEntity categoryEntity : categoryEntityList) {
//			responseList.add(new Category(categoryEntity));
			Category category = new Category(categoryEntity);
			responseList.add(category);
		}
		return responseList;
	}
	
	public Cake saveCake(Cake cake) {
		CakeEntity cakeEntity = new CakeEntity(cake);
		cakeEntity = cakeRepository.save(cakeEntity);
		Cake r = new Cake(cakeEntity);
		return r;
	}
	
	public List<Cake> getCakes(Optional<Long> categoryId,
			Optional<String> search,
			Optional<BigDecimal> minPrice,
			Optional<BigDecimal> maxPrice) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<CakeEntity> criteria = criteriaBuilder.createQuery(CakeEntity.class);
        Root<CakeEntity> root = criteria.from(CakeEntity.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (categoryId.isPresent()) {
        	Predicate condition = criteriaBuilder.equal(root.get("category").get("id"), categoryId.get());
            predicates.add(condition);
        }
        if (search.isPresent()) {
        	Predicate condition = criteriaBuilder.like(root.get("title"),"%"+search.get()+"%");
            predicates.add(condition);
        }
        if (minPrice.isPresent()) {
        	Predicate condition = criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice.get());
            predicates.add(condition);
        }
        if (maxPrice.isPresent()) {
        	Predicate condition = criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice.get());
            predicates.add(condition);
        }
//        for (Predicate predicate : predicates) {
//        	criteria.where(criteriaBuilder.and(predicate));
//        }
        criteria.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
        List<CakeEntity> cakeEntityList = em.createQuery(criteria).getResultList();
		List<Cake> responseList = new ArrayList<Cake>();
		for(CakeEntity cakeEntity : cakeEntityList) {
			responseList.add(new Cake(cakeEntity));
		}
        return responseList;
	}
	
	public Cake getCakeById(Long cakeId) {
		Optional<CakeEntity> cakeOption = cakeRepository.findById(cakeId);
		if (cakeOption.isPresent()) {
			return new Cake(cakeOption.get());
		}
		return null;
	}
	
	public List<Cake> getRelatedCakes(Long cakeId) {
		List<CakeEntity> cakeEntityList = cakeRepository.getSimilarCategoryCakes(cakeId);
		List<Cake> cakeList = new ArrayList<Cake>();
		for ( CakeEntity cakeEntity :cakeEntityList) {
			Cake cake = new Cake(cakeEntity);
			cakeList.add(cake);
		}
		return cakeList;
	}
	
}
