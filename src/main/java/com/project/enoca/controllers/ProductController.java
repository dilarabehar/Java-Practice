package com.project.enoca.controllers;

import java.util.List;
import java.util.Optional;

import com.project.enoca.dto.ProductDto;
import com.project.enoca.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.enoca.entities.Product;

import com.project.enoca.repos.ProductRepository;

@RestController
@RequestMapping("/product")

public class ProductController {
	@Resource
	private ProductRepository productRepository;

	@Resource
	private ProductService productService;
	
	public ProductController (ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	@GetMapping
	public List<Product> GetProduct()
	{
		return productRepository.findAll();
		
	}

	@GetMapping("/getproducts")
	public List<Product> getProduct(){
		try{
			List<Product> products = productService.GetProduct();
			return  products;
		}catch (Exception e){
			return null;
		}
	}

	@PostMapping("/addProduct")
	public ResponseEntity createProduct(@RequestBody ProductDto productDto){
		try {
			productService.CreateProduct(productDto);
			return new ResponseEntity<>("PRODUCT ADDED",HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{productId}")
	public Product GetProductByID(@PathVariable Long productId)
	{
		return productRepository.findById(productId).orElse(null);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity UpdateProduct(@PathVariable Long productId, @RequestBody Product newProduct)
	{
		try {
			productService.updateProduct(productId, newProduct);
			return new ResponseEntity<>("PRODUCT UPDATED",HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{productId}")
	public void DeleteProduct (@PathVariable Long productId)
	{
		 productService.DeleteProduct(productId);
	}



	/*
	*  {
        "id": null,
        "name": "Cips",
        "price": 9.99,
        "stock": 55
    }
	* */
	
	

}
