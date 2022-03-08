package com.userinputs;

import java.util.Scanner;

/**
 * To get input.
 * 
 * @author SathishKumarS
 *
 */
public class UserDetailGetter {

	public final Scanner scanner = new Scanner(System.in);

	/**
	 * Gets string value
	 *
	 * @param content
	 * @return
	 */
	public String getString(String content) {
		System.out.println(content);
		return scanner.next().trim();
	}

	/**
	 * Gets integer value
	 *
	 * @param content
	 * @return
	 */
	public int getInt(String content) {
		System.out.println(content);

		try {
			return scanner.nextInt();
		} catch (Exception exception) {
			System.out.println("\n Invalid Input \n  Please Use Numbers Only");
			return getInt(content);
		}
	}

	/**
	 * Gets double value
	 *
	 * @param content
	 * @return
	 */
	public double getDouble(String content) {
		System.out.println(content);

		try {
			return scanner.nextDouble();
		} catch (Exception exception) {
			System.out.println("\n Invalid Input \n  Please Use Numbers Only");
			return getDouble(content);
		}
	}

	/**
	 * Gets character value
	 *
	 * @param content
	 * @return
	 */
	public char getChar(String content) {
		System.out.println(content);

		try {
			return scanner.next().charAt(0);
		} catch (Exception exception) {
			System.out.println("\n Invalid Input \n  Please Use Single Character Only");
			return getChar(content);
		}
	}
}
