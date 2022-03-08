package com.view;

import com.attributes.ProductAttributes;
import com.controller.ShopKeeper;
import com.exceptions.InvalidProductException;
import com.exceptions.UnableToAccessException;
import com.model.Product;
import com.userinputs.UserDetailGetter;

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
