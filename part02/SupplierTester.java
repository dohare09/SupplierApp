package part02;

import java.util.ArrayList;
import java.util.Scanner;

public class SupplierTester {
	static Scanner sc = new Scanner(System.in);
	/**
	 *  This method will test the Supplier class by creating 2 instances - one hardcoded and one created by the user
	 */
	public static void main(String[] args) {
		Address test1address = new Address(52, "Crumlin Road", "Belfast", "bt147tf", "Northern Ireland");
		ArrayList<Product> products = new ArrayList<>();
		Product test1product = new Product(101, "Ford", "Focus", 19999.99, true, 67);
		Product test2product = new Product(102, "Citreon", "Picasso", 6999.99, true, 78);
		products.add(test1product);
		products.add(test2product);
		Supplier test1 = new Supplier(101, "Ford", test1address, SupRegion.UNITED_KINGDOM, products);
		System.out.println("Supplier code: " + test1.getSupCode() + "\nSupplier name " + test1.getSupName() + "\nSupplier region: " + test1.getSupRegion() + "\n---Address---\n" + test1address.getFullAddress() + "\n");
		test1.printProductList();
		Supplier test2 = Supplier.addSupplier();
		System.out.println("Supplier code: " + test2.getSupCode() + "\n" + "Supplier name: " + test2.getSupName() + "\n" + "Supplier region: " + test2.getSupRegion() + "\n" + "---Supplier address---\n" + test2.getSupAddressString());
		test2.printProductList();
	}
	/**
	 * This method is used to print out all of the enum items
	 * @param index - selects a specific region in the enum
	 * @param numofenumitems - total number of items in the enum
	 */
	public static void printEnumItems(int numOfEnumItems) {
		for (int index = 1; index <= numOfEnumItems; index++) {
			System.out.println(index + ": " + SupRegion.values()[index - 1].getRegionasString());
		}
	}
}
