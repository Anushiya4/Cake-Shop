/**
 * 
 */
package com.example.cake.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cake.entity.CakeEntity;
import com.example.cake.entity.CategoryEntity;
import com.example.cake.model.Cake;
import com.example.cake.model.Category;
import com.example.cake.service.CakeService;

/**
 * 
 */
@RestController
@CrossOrigin(origins = "*")
public class CakeController {
	
	@Autowired
	private CakeService cakeService;
	
	@GetMapping("/getCategories")
	public List<Category> getCategories() {
		List<Category> response = cakeService.getCategories();
		return response;
	}
	
	@GetMapping("/getcakelist")
	public List<Cake> getcakeList(
			@RequestParam("categoryId") Optional<Long> categoryId,
			@RequestParam("searchValue") Optional<String> searchValue,
			@RequestParam("minPrice") Optional<BigDecimal> minPrice,
			@RequestParam("maxPrice") Optional<BigDecimal> maxPrice
			) {
		return cakeService.getCakes(categoryId, searchValue, minPrice, maxPrice);
//		List<Cake> cakelist1 =new  ArrayList<Cake>();
//		cakelist1.add(new Cake( null,  3l, "Chocolate-Lava-Cake-Recipe.jpg", "Chocolate-Lava-Cake","All you need are a few simple ingredients to make this show-stopping Chocolate Lava Cake.", new BigDecimal(1000), 1));
//		cakelist1.add(new Cake( null,  3l, "Bento Cake Cup cake Combo.jpeg","Bento Cake Cup cake Combo", "Introducing our Bento Cake Cup Cake Combo, a delightful assortment of mini cupcakes in a convenient bento box. This combo includes a variety of flavors such as chocolate, vanilla, red velvet, and more, making it perfect for sharing or enjoying as a sweet treat for yourself.In addition to our cupcake combo, we also offer our Basic Cake", new BigDecimal (490),  1));
//		cakelist1.add(new Cake( null,  1l, "Butterscotch Premium Cake.jpeg","Butterscotch Premium Cake", "Indulge in the rich and decadent flavor of our Butterscotch Premium Cake. Made with the finest ingredients and topped with a luscious butterscotch frosting, this cake is a perfect treat for any occasion.", new BigDecimal (650), 1)) ;
//		cakelist1.add(new Cake( null,  1l,"Blueberry Purple Flower Cake.jpeg","Blueberry Purple Flower Cake","Indulge in the delightful taste of our Blueberry Purple Flower Cake. This basic cake is infused with the rich flavor of blueberries, creating a sweet and tangy sensation with every bite.", new BigDecimal(490),1));
//		cakelist1.add(new Cake( null,  2l, "Bento Cake.jpeg", "Bento Cake", "Indulge in the ultimate chocolate experience with our 1kg Death by Chocolate Cake. This rich and decadent dessert is every chocolate lover s dream come true!", new BigDecimal( 899), 1));
//		cakelist1.add(new Cake(null,  2l, "Death By Chocolate Cake.jpeg","Death By Chocolate Cake", "Introducing our delicious Bento Cake and Basic Cake! Our Bento Cake is a delightful combination of fluffy sponge cake layered with creamy frosting and topped with a variety of fresh fruits and decorative designs.", new BigDecimal(350), 1));
		//		if (categoryId != 0) {
//			List<Cake> response =new  ArrayList<Cake>();
//			for(Cake c : cakelist1) {
//				if (c.getCategory() == categoryId) {
//					response.add(c);
//				}
//			}
//			return response;
//		}
//		return cakelist1;
	}
	
	@GetMapping("/getCakeById")
	public Cake getcakeList(@RequestParam Long id) {
		return cakeService.getCakeById(id);
	}
	
	@GetMapping("/getRelatedProducts")
	public List<Cake> getRelatedProducts(@RequestParam Long cakeId) {
		return cakeService.getRelatedCakes(cakeId);
	}
	
	@PostMapping("/saveCategory")
	public CategoryEntity saveCategory(@RequestBody Category category) {
		return cakeService.saveCategory(category);
	}
	
	@PostMapping("/saveCake")
	public Cake saveCake(@RequestBody Cake cake) {
		return cakeService.saveCake(cake);
	}
	
	@GetMapping("/getRelatedCakes")
	public Cake getRelatedCakes(@RequestParam Long id) {
		return cakeService.getCakeById(id);
	}

}


