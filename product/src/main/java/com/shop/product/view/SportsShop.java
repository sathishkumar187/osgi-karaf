package com.shop.product.view;

import com.shop.product.activator.Activator;
import com.shop.product.attributes.Choice;
import com.shop.product.attributes.ProductAttributes;
import com.shop.product.controller.ShopKeeper;
import com.shop.product.exceptions.InvalidProductException;
import com.shop.product.exceptions.UnableToAccessException;
import com.shop.product.model.Product;
import com.userinputs.UserDetailGetter;

import java.util.List;

/**
 * The shop application for sports-kits using CRUD operations - Create, Read, Update, Delete.
 * 
 *  @author SathishKumarS
 *  
 */
public class SportsShop  {

    /**
     * Main menu.
     * 
     */
    public static void menu() {
        int operation = 0;

        do {
        	System.out.println("\n\n    <^_^> Sports Shop Application <^_^>\n\n Operations \n  1.Add Product \n  2.Select Product \n  3.Update Product Price \n  4.Remove Product \n  5.Select All Products \n  6.Exit");
            operation = Choice.getOperation();

            switch (operation) {
            case 1:
                SportsShop.addProduct();
                break;
            case 2:
                SportsShop.selectAnyProduct();
                break;
            case 3:
                SportsShop.updateProductPrice();
                break;
            case 4:
                SportsShop.removeProduct();
                break;
            case 5:
            	SportsShop.showAllProducts();
            	break;
            case 6:
                new UserDetailGetter().scanner.close();

                try {
                    Activator.bundle.stop();
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        } while (operation < 6);
    }

    /**
     * Adds the new product.
     *   
     */
    private static void addProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        product.setBrand(ProductAttributes.getBrand());
        product.setName(ProductAttributes.getName());
        product.setPrice(ProductAttributes.getPrice());
        product.setSize(ProductAttributes.getSize());
        product.setManufactureDate(ProductAttributes.getManufactureDate());

        try {
        	shopKeeper.addProduct(product);
            System.out.println("\n Product Added Successfully");
        } catch (InvalidProductException exception) {
            System.out.println(exception);
        } catch (UnableToAccessException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Call the customer for selects any product.
     *  
     */
    private static void selectAnyProduct() {
    	System.out.println("\n Select Any Product");
        final Customer customer = new Customer();

        customer.selectProduct();
    }

    /**
     * Updates the product price. 
     * 
     */
    private static void updateProductPrice() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        product.setBrand(ProductAttributes.getBrand());
        product.setName(ProductAttributes.getName());
        product.setSize(ProductAttributes.getSize());
        
        try {
        	shopKeeper.selectProduct(product);
        } catch (InvalidProductException exception) {
            System.out.println(exception);
        	updateProductPrice();
        	menu();
        } catch (UnableToAccessException exception) {
            System.out.println(exception);
        }
        product.setPrice(ProductAttributes.getPrice());
        
        try {
            shopKeeper.updateProductPrice(product);
            System.out.println("\n Product Updated Successfully");
        } catch (InvalidProductException exception) {
            System.out.println(exception);
        } catch (UnableToAccessException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Removes the product.
     * 
     */
    private static void removeProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        product.setBrand(ProductAttributes.getBrand());
        product.setName(ProductAttributes.getName());
        product.setSize(ProductAttributes.getSize());

        try {
            shopKeeper.removeProduct(product);
            System.out.println("\n Product Removed Successfully");
        } catch (InvalidProductException exception) {
            System.out.println(exception);
        } catch (UnableToAccessException exception) {
            System.out.println(exception);
        }
    }
    
    /**
     * Shows all the available products.
     * 
     */
    private static void showAllProducts() {
    	final ShopKeeper shopKeeper = new ShopKeeper();
    	List<Product> products = null;
    	
    	try {
    		products = shopKeeper.selectAllProducts();
    	} catch (InvalidProductException exception) {
            System.out.println(exception);
        } catch (UnableToAccessException exception) {
            System.out.println(exception);
        }
    	
        if (products != null) {

            for (Product product : products) {
            	System.out.println(String.format("%s %s %s %s %s %s %f %s %c %s %s", "\n\n ", product.getBrand(),
                    "Brand :", "\n   Product Name :", product.getName(), "\n   Product Price :", product.getPrice(),
                    "\n   Product Size :", product.getSize(), "\n   Manufacture Date :", product.getManufactureDate().toString()));
            }
        }
    }

    /**
     * Shows the Selected Product. 
     * 
     * @param product
     * 
     */
    public static void showProduct(final Product product) {

        if (product != null) {
        	System.out.println(String.format("%s %s %s %s %s %f %s %c %s %s","\n\n Product Details : \n  Product Name :",
                product.getName(), "\n  Product Brand :", product.getBrand(), "\n  Product Price :",
                product.getPrice(), "\n  Product Size :", product.getSize(), "\n  Manufacture Date :",
                product.getManufactureDate()).toString());
        }
    }

    /**
     * Set the properties file.
     */
//    public static void setProperties() {
//        final Properties properties = new Properties();
//
//        try {
//            properties.load(new FileInputStream(new File("C:/Users/SathishKumarS/eclipse-workspace2/shop/view/log.properties")));
//            PropertyConfigurator.configure(properties);
//        } catch (Exception exception) {
//            System.out.println(exception);
//        }
//    }
}
