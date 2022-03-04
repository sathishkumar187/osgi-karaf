package com.dao;

import com.model.Product;

import java.util.List;

/**
 * Data Access Object. 
 * 
 * @author SathishKumarS
 *
 */
public interface SportsShopDao {

    boolean addProduct(Product product);
	
    boolean updateProductPrice(Product product);
	
    boolean removeProduct(Product product);
	
    List<Product> selectAllProducts();
}
