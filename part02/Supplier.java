package part02;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class Supplier {
	private int supCode;
	private String supName;
	private Address supAddress;
	private SupRegion supRegion;
	private ArrayList<Product> supProducts;
	private static ArrayList<Supplier> supList = new ArrayList<>();
	/**
	 * This is the constructor for the supplier class - it is used to generates supplier instances
	 * @param supCode - The supplier code
	 * @param supName - The supplier name
	 * @param supAddress - The supplier address
	 * @param supRegion - The supplier region
	 * @param supProducts - The supplier products
	 */
	public Supplier(int supCode, String supName, Address supAddress, SupRegion supRegion,
			ArrayList<Product> supProducts) {
		this.supCode = supCode;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supRegion = supRegion;
		this.supProducts = supProducts;
		supList.add(this);
		}
	/**
	 * This method uses a for each loop to print every item in the products array
	 */
	public void printProductList() {
		int index = 1;
		for (Product product : supProducts) {
			System.out.println("----Product " + index + "----\n" + product.getProductDetails() + "\n");
			index++;
		}
	}
	/**
	 * This method returns the supplier code
	 * @return the supCode
	 */
	public int getSupCode() {
		return supCode;
	}
	/**
	 * This method returns the supplier name
	 * @return the supName
	 */
	public String getSupName() {
		return supName;
	}
	/**
	 * This method returns the supplier address
	 * @return the supAddress
	 */
	public Address getSupAddress() {
		return supAddress;
	}
	public String getSupAddressString() {
		return supAddress.getFullAddress();
	}
	/**
	 * This method returns the supplier region
	 * @return the supRegion
	 */
	public String getSupRegion() {
		return supRegion.getRegionasString();
	}
	/**
	 * This method returns the supplier products
	 * @return the supProducts
	 */
	public ArrayList<Product> getSupProducts() {
		return supProducts;
	}
	/**
	 * This method sets the supplier code
	 * @param supCode the supCode to set
	 */
	public void setSupCode(int supCode) {
		this.supCode = supCode;
	}
	/**
	 * This method sets the supplier name 
	 * @param supName the supName to set
	 */
	public void setSupName(String supName) {
		this.supName = supName;
	}
	/**
	 * This method sets the supplier address
	 * @param supAddress the supAddress to set
	 */
	public void setSupAddress(Address supAddress) {
		this.supAddress = supAddress;
	}
	/**
	 * This method sets the supplier region
	 * @param supRegion the supRegion to set
	 */
	public void setSupRegion(SupRegion supRegion) {
		this.supRegion = supRegion;
	}
	/**
	 * This method adds a product to the supProducts array
	 * @param supProducts the supProducts to set
	 */
	public void setSupProducts(Product supProduct) {
		this.supProducts.add(supProduct);
	}
	/**
	 * This method is used to add a supplier and it allows the user to create address and products aswell
	 * @return supplier - the object all user input is stored in
	 */
	public static Supplier addSupplier() {
		Random randomGen = new Random();
		int supCode = randomGen.nextInt(1000000);
		System.out.println("Please enter a supplier name");
		String supName = Validation.validateStrings();
		System.out.println("You have to create an address for the supplier");	
		Address supAddress = Address.addAddress();
		int numOfEnumItems = EnumSet.allOf(SupRegion.class).size();
		printEnumItems(numOfEnumItems);
		System.out.println("Enter the number of the region you are in");
		int choice = Validation.validateInts();
		SupRegion supRegion = SupRegion.values()[choice - 1];
		System.out.println("You must add a product");
		Product supProduct = Product.addProduct();
		ArrayList<Product> supProducts = new ArrayList<>();
		supProducts.add(supProduct);
		Supplier supplier = new Supplier(supCode, supName, supAddress, supRegion, supProducts);
		System.out.println("Would you like to add another product?");
		String userChoice = Validation.validateStrings();
		while (userChoice.trim().toLowerCase().equals("yes") || userChoice.trim().toLowerCase().equals("no")) {
			if (userChoice.trim().toLowerCase().equals("yes")) {
				Product product = Product.addProduct();
				supplier.setSupProducts(product);
				return supplier;
			} else if (userChoice.trim().toLowerCase().equals("no")) {
				return supplier;
			}
		}
		System.out.println("You must enter a yes or no answer, please restart adding the supplier");
		return addSupplier();
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
	public static ArrayList<Supplier> getSupplierList() {
		return supList;
	}
	public static void printSupplierList() {
		try {
			if (supList.get(0) != null) {
				int index = 1;
				for (Supplier supplier : supList) {
					System.out.println(index + ": " + supplier.getSupName());
					System.out.println("Supplier code: " + supplier.getSupCode());
					System.out.println("---Supplier address---\n" + supplier.getSupAddressString());
					index++;
				}
			} else {
				MainMenu.mainMenu();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("There are no suppliers to list");
			MainMenu.mainMenu();
		}
	}
}
