package com.shop.product.service;

import com.shop.product.dao.SportsShopDao;
import com.shop.product.dao.SportsShopDaoImpl;
import com.shop.product.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rest service implementation.
 *
 * @author SathishKumarS
 */
public class RestServiceImpl implements RestService{

    private static RestService restService;
    private static final SportsShopDao SPORTS_SHOP_DAO = SportsShopDaoImpl.getInstance();

    private RestServiceImpl() {

    }

    /**
     * Adds the product.
     *
     * @param products
     *
     * @return Boolean.
     */
    @Override
    public Map<String, Boolean> addProduct(List<Product> products) {
        final Map<String, Boolean> map = new HashMap<>();

        for (int index = 0; index < products.size(); index++) {
            boolean isAdded = SPORTS_SHOP_DAO.addProduct(products.get(index));
            map.put(String.format("%s %o","Successfully added product ", index + 1), isAdded);
        }
        return map;
    }

    /**
     * Selects all the products.
     *
     * @return List of products.
     */
    @Override
    public List<Product> selectAllProducts() {
        return SPORTS_SHOP_DAO.selectAllProducts();
    }

    /**
     * Selects the product.
     *
     * @param product
     *
     * @return Product
     */
    @Override
    public Product selectProduct(Product product) {
        return ShopServiceImplementationV2.getInstance().selectProduct(product);
    }

    /**
     * Updates the product price.
     *
     * @param products
     *
     * @return Boolean.
     */
    @Override
    public Map<String, Boolean> updateProductPrice(List<Product> products) {
        final Map<String, Boolean> map = new HashMap<>();

        for (int index = 0; index < products.size(); index++) {
            boolean isAdded = SPORTS_SHOP_DAO.updateProductPrice(products.get(index));
            map.put(String.format("%s %o","Successfully updated product ", index + 1), isAdded);
        }
        return map;
    }

    /**
     * Removes the product.
     *
     * @param products
     *
     * @return Boolean
     */
    @Override
    public Map<String, Boolean> removeProduct(List<Product> products) {
        final Map<String, Boolean> map = new HashMap<>();

        for (int index = 0; index < products.size(); index++) {
            boolean isAdded = SPORTS_SHOP_DAO.removeProduct(products.get(index));
            map.put(String.format("%s %o","Successfully deleted product ", index + 1), isAdded);
        }
        return map;
    }

    public static RestService getInstance() {
        if (restService == null) {
            restService = new RestServiceImpl();
        }
        return restService;
    }
}
