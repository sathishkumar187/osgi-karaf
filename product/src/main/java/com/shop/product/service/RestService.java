package com.shop.product.service;

import com.shop.product.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Rest service.
 *
 * @author SathishKumarS
 */
public interface RestService {

    Map<String, Boolean> addProduct(List<Product> product);

    List<Product> selectAllProducts();

    Product selectProduct(Product product);

    Map<String, Boolean> updateProductPrice(List<Product> products);

    Map<String, Boolean> removeProduct(List<Product> products);
}
