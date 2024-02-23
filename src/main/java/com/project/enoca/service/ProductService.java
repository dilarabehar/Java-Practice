package com.project.enoca.service;

import com.project.enoca.dto.ProductDto;
import com.project.enoca.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> GetProduct();

    void CreateProduct(ProductDto productDto);

    void updateProduct(Long productId, Product newProduct) throws Exception;

    void DeleteProduct (Long productId);
}
