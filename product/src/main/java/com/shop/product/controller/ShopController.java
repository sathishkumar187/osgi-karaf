package com.shop.product.controller;

import com.shop.product.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Shop controller interface.
 *
 * @author SathishKumarS
 */
public interface ShopController {

    Map addProduct(List<Product> product);

    Product selectProduct(String brand, String name, char size);

    Map removeProduct(List<Product> product);

    Map updateProduct(List<Product> product);

    List<Product> selectAllProduct(int page, int limit);
}
