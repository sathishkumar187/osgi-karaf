package com.view;

import com.controller.ShopKeeper;
import com.customexceptions.InvalidProductException;
import com.customexceptions.UnableToAccessException;
import com.model.Product;

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

        product.setBrand(userDetailGetter.getProductBrand());
        product.setName(userDetailGetter.getProductName());
        product.setSize(userDetailGetter.getProductSize());
        
        try {
            SportsShop.showProduct(shopKeeper.selectProduct(product));
        } catch (InvalidProductException exception) {
            System.out.println(exception);
        } catch (UnableToAccessException exception) {
            System.out.println(exception);
        }
    }
}
