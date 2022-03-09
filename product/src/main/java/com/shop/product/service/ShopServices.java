package com.shop.product.service;

import com.shop.product.model.Product;

import java.util.List;

/**
 * These Services are provided by sports shop application.
 * 
 * @author SathishKumarS
 * 
 */
public interface ShopServices {
	
    void addProduct(Product product);
    
    List<Product> selectAllProducts();
		
    Product selectProduct(Product product);
		
    void updateProductPrice(Product product);
		
    void removeProduct(Product product);
}

