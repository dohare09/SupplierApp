package part02;
import java.util.ArrayList;
import java.util.Scanner;

import part02.Product;
public class Searching {
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Product> searchByCode() {
		ArrayList<Product> returnList = new ArrayList<>();
		System.out.println("What is the code of the product you are searching for?");
		int proCode = Validation.validateInts();
		ArrayList<Product> proList = new ArrayList<>();
		proList = Product.getProductList();
		for (Product product : proList) {
			if (proCode == product.getProCode()) {
				returnList.add(product);
			}
		}
		return returnList;
	}
	
	public static ArrayList<Product> searchByMake() {
		ArrayList<Product> returnList = new ArrayList<>();
		System.out.println("What is the make of the product you are searching for?");
		String proMake = sc.next();
		ArrayList<Product> proList = new ArrayList<>();
		proList = Product.getProductList();
		for (Product product : proList) {
			if (proMake.trim().toLowerCase().equals(product.getProMake().trim().toLowerCase())) {
				returnList.add(product);
			}
		}
		return returnList;
	}
	
	public static ArrayList<Product> searchByModel() {
		ArrayList<Product> returnList = new ArrayList<>();
		System.out.println("What is the model of the product you are searching for?");
		String proModel = sc.next();
		ArrayList<Product> proList = new ArrayList<>();
		proList = Product.getProductList();
		for (Product product : proList) {
			if (proModel.trim().toLowerCase().equals(product.getProModel().trim().toLowerCase())) {
				returnList.add(product);
			}
		}
		return returnList;
	}
	
	public static ArrayList<Product> searchByPrice() {
		ArrayList<Product> returnList = new ArrayList<>();
		System.out.println("Enter the minimum price of the product you are looking for");
		double minPrice = sc.nextDouble();
		System.out.println("Enter the maximum price of the product you are looking for");
		double maxPrice = sc.nextDouble();
		ArrayList<Product> proList = new ArrayList<>();
		proList = Product.getProductList();
		for (Product product : proList) {
			if (minPrice <= product.getProPrice() && maxPrice >= product.getProPrice()) {
				returnList.add(product);
			}
 		}
		return returnList;
	}
}
