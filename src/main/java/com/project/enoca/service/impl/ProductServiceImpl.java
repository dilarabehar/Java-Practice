package com.project.enoca.service.impl;

import com.project.enoca.dto.ProductDto;
import com.project.enoca.entities.Product;
import com.project.enoca.repos.ProductRepository;
import com.project.enoca.service.ProductService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    public List<Product> GetProduct()
    {
        return productRepository.findAll()
                .stream()
                .toList();
    }

    @Override
    public void CreateProduct(ProductDto productDto) {
        Product newProduct = convertDtoToEntity(productDto);
        productRepository.save(newProduct);
    }

    @Override
    public void updateProduct(Long productId, Product newProduct) throws Exception {
        Optional<Product> product = productRepository.findById(productId);

        if(product.isPresent())
        {
            Product foundProduct = product.get();

            foundProduct.setName(newProduct.getName());
            foundProduct.setPrice(newProduct.getPrice());
            foundProduct.setStock(newProduct.getStock());
            productRepository.save(foundProduct);

        }else {

            throw new Exception("PRODUCT NOT FOUND");

        }
    }

    public void DeleteProduct (Long productId)
    {
        productRepository.deleteById(productId);
    }

    private ProductDto convertEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setStock(product.getStock());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    private Product convertDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
