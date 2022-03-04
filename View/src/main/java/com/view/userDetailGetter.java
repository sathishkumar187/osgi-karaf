package com.view;

import com.customexceptions.InvalidDateException;
import com.validation.Validations;

import java.sql.Date;

/**
 * To get input.
 * 
 * @author SathishKumarS
 *
 */
public class userDetailGetter {
    
    /**
     * Gets the operation.
     * 
     * @return
     * 
     */
	static int getOperation() {
		final String operation = SportsShop.SCANNER.next().trim();
		
		if (Validations.validateOperation(operation)) {
			return Integer.parseInt(operation);
		} else {
			System.out.println("\n Selected Operation Is Invalid \n  Re-Enter Valid Operation(Use Only 1-6)");
			return getOperation();
		}
	}

    /**
     * Gets the product name.
     * 
     * @return
     * 
     */
	static String getProductName() {
		System.out.println("\n Mention Product Name(Bat, Ball, Stump, Gloves, Helmet) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String name = SportsShop.SCANNER.next().trim();
		
		userDetailGetter.goBackToMenu(name);

		if (Validations.validateName(name)) {
			return name.toUpperCase();
		} else {
			System.out.println("\n Product Is Not Available \n  Select Anyone Of Them (Bat, Ball, Stump, Gloves, Helmet) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductName();
		}
	}

    /**
     * Gets the product brand.
     * 
     * @return
     * 
     */
	static String getProductBrand() {
		System.out.println("\n Mention Product Brand(SS, SG, MRF, RBK, NIKE) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String brand = SportsShop.SCANNER.next().trim();
		
		userDetailGetter.goBackToMenu(brand);

		if (Validations.validateBrand(brand)) {
			return brand.toUpperCase();
		} else {
			System.out.println("/n Brand Is Not Available \n  Select Anyone Of Them (SS, SG, MRF, RBK, NIKE) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductBrand();
		}
	}

    /**
     * Gets the product price.
     * 
     * @return
     * 
     */
	static double getProductPrice() {
		System.out.println("\n Mention Product Price ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String price = SportsShop.SCANNER.next().trim();
		
		userDetailGetter.goBackToMenu(price);

		if (Validations.validatePrice(price)) {
			return Double.parseDouble(price);
		} else {
			System.out.println("/n Price Is Invalid \n  Re-Enter Valid Price(Use Whole Numbers and Decimal Numbers Only) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductPrice();
		}
	}

    /**
     * Gets the product size.
     *  
     * @return
     * 
     */
	static char getProductSize() {
		System.out.println("\n Mention Product Size(S, M, L) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String size = SportsShop.SCANNER.next().trim();
		
		userDetailGetter.goBackToMenu(size);

		if (Validations.validateSize(size)) {
			return size.toUpperCase().charAt(0);
		} else {
			System.out.println("\n Size Is Invalid \n  Re-Enter Valid Size(Use Only S, M, L) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductSize();
		}
	}

    /**
     * Gets the product's manufacture date.
     * 
     * @return
     * 
     */
	static Date getManufactureDate() {
		System.out.println("\n Mention Manufacture Date(YYYY-MM-DD) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String manufactureDate = SportsShop.SCANNER.next().trim();
		
		userDetailGetter.goBackToMenu(manufactureDate);
		
        try { 
        	
		    if (Validations.validateDate(manufactureDate)) {
			    return Date.valueOf(manufactureDate);
		    } else {
				System.out.println("\n Date Is Invalid \n  Re-Enter Valid Date ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			    return getManufactureDate();
		    }
        } catch (InvalidDateException exception) {
        	System.out.println(exception);
        }
		return getManufactureDate();
	}
	
    /**
     * Goes back to menu.
     * 
     * @param userInput
     * s
     */
	private static void goBackToMenu(final String userInput) {
		
		if ("#".equals(userInput)) {
			SportsShop.menu();
		}
	}
}
