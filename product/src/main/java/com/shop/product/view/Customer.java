package com.shop.product.view;

import com.shop.product.exceptions.UnableToAccessException;
import com.shop.product.model.Product;
import com.shop.product.attributes.ProductAttributes;
import com.shop.product.controller.ShopKeeper;
import com.shop.product.exceptions.InvalidProductException;

/**
 * Customer class of the sports shop.
 * 
 * @author SathishKumarS
 * 
 */
public class Customer {

    /**
     * Selects the product.
     * 
     */
    void selectProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();

        product.setBrand(ProductAttributes.getBrand());
        product.setName(ProductAttributes.getName());
        product.setSize(ProductAttributes.getSize());
        
        try {
            SportsShop.showProduct(shopKeeper.selectProduct(product));
        } catch (InvalidProductException exception) {
            System.out.println(exception);
        } catch (UnableToAccessException exception) {
            System.out.println(exception);
        }
    }
}
