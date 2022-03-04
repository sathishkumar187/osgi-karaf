package com.validation;

import com.customexceptions.InvalidDateException;

import java.time.LocalDate;

/**
 * Validates the user input data.
 * 
 * @author SathishKumarS
 * 
 */
public class Validations {

    /**
     * Validates the selected operation.
     * 
     * @param operation
     * @return 
     */
    public static boolean validateOperation(final String operation) {
        return operation.matches("[1-6]")? true : false;
    }

    /**
     * Validates the product name.
     * 
     * @param name
     * @return 
     */
    public static boolean validateName(final String name) {
        return name.matches("(?i)bat|ball|stump|gloves|helmet")? true : false;
    }

     /**
     * Validates the product brand.
     * 
     * @param brandName
     * @return
     */
    public static boolean validateBrand(final String brandName) {
        return brandName.matches("(?i)ss|sg|mrf|nike")? true : false;
    }

     /**
     * Validates the product price.
     * 
     * @param price
     * @return
     */
    public static boolean validatePrice(final String price) {
        return price.matches("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)")? true : false;
    }

     /**
     * Validates the product size.
     *  
     * @param size
     * @return
     */
    public static boolean validateSize(final String size) {
        return size.matches("(?i)s|m|l")? true : false;
    }

	/**
     * Validates the manufacture date of product. 
     * 
     * @param inputDate
     * @return 
     */
    public static boolean validateDate(final String inputDate) {
		
        try {
            final LocalDate date = LocalDate.parse(inputDate);
            final LocalDate todayDate = LocalDate.now();
            
            return todayDate.plusDays(1).isAfter(date)? true : false;
        } catch(Exception e) {
            throw new InvalidDateException("Date Format Is Invalid \n Re-Enter Valid Date");
        }
    }
}
