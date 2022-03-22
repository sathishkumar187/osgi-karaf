package com.shop.product.controller;

import com.shop.product.model.Product;
import com.shop.product.service.RestService;
import com.shop.product.service.RestServiceImpl;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Shop controller implementation.
 *
 * @author SathishKumarS
 */
@Component(service = ShopController.class)
public class ShopControllerImpl implements ShopController{

    private static RestService restService = RestServiceImpl.getInstance();

    /**
     * adds the product.
     *
     * @param products
     * @return Boolean
     */
    @Override
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    public Map<String, Boolean> addProduct(List<Product> products) {
        return restService.addProduct(products);
    }

    /**
     * Selects product.
     *
     * @param brand
     * @param name
     * @param size
     *
     * @return Product
     */
    @Override
    @Path("/select")
    @Produces("application/json")
    @GET
    public Product selectProduct(@QueryParam("brand") String brand, @QueryParam("name") String name, @QueryParam("size") char size) {
        final Product product = new Product();

        product.setBrand(brand);
        product.setName(name);
        product.setSize(size);
        return restService.selectProduct(product);
    }

    /**
     * Deletes the product.
     *
     * @param products
     *
     * @return Boolean.
     */
    @Override
    @Path("/delete")
    @Consumes("application/json")
    @Produces("application/json")
    @DELETE
    public Map<String, Boolean> removeProduct(List<Product> products) {
        return restService.removeProduct(products);
    }

    /**
     * Updates the product.
     *
     * @param products
     *
     * @return Boolean.
     */
    @Override
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    @PUT
    public Map<String, Boolean> updateProduct(List<Product> products) {
        Map map = restService.updateProductPrice(products);
        return map;
    }

    /**
     * Selects all the products.
     *
     * @param page
     * @param noOfEntities
     *
     * @return List ofe products.
     */
    @Override
    @Path("/selectall")
    @Produces("application/json")
    @GET
    public Map selectAllProduct(@QueryParam("page") final int page,@DefaultValue("10") @QueryParam("limit") final int noOfEntities) {
        final List<Product> products = restService.selectAllProducts();
        int starting = 0, ending = 0;

        if (page > 0 && noOfEntities > 0) {
            starting = (page - 1) * noOfEntities;
            ending = starting + noOfEntities;
        }

        if (starting < products.size() && ending < products.size()) {
            final Map Products = castToMap(products.subList(starting, ending));

            return Products;
        } else if (starting < products.size()) {
            final Map Products = castToMap(products.subList(starting, products.size()));
            return Products;
        }
        return null;
    }

    private static Map castToMap(List<Product> productsList) {
        final Map products = new HashMap<Integer, Product>();
        int serialNo = 1;

        for (Product product : productsList) {
            products.put(serialNo, product);
            serialNo++;
        }
        return products;
    }
}
