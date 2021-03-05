/*
 * 2.	Ezee Shop has an online portal where customers can check about different products. Customers can search for 
 * products by giving a key word. Write a program that accepts a product name and a key word, and checks if the 
 * key word is present in the given product name.
 * */

package assignmnet2_vashishth_singh;

import java.util.*;
public class Question2 {
	
	static String[] initProductNames() {
		String productNames[]=new String[]{"Digital Boy's & Girl's Watch",
				 							"Men's Stretch Slim Jeans",
				 							"Men's Regular Fit Jeans",
				 							"Black Jeans",
				 							"Full Black LED Display Smart Watch",
				 							"VSK Bean Bag Sofa",
				 							"Rose Teddy Bear",
				 							"Floralbay Red Roses Bouquet"};
		return productNames;
	}
	static boolean isPresent(String[] productNames, String keyword) {
		for(String product:productNames) {
			if(product.contains(keyword)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String []args) {
		String productNames[]=initProductNames();
		String keyword;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Keyword: ");
		keyword=sc.nextLine();
		keyword=keyword.trim();
		System.out.println(isPresent(productNames,keyword));
	}
}
