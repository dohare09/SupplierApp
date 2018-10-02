package part02;

import java.util.ArrayList;
import java.util.Random;

public class Product {
	private int proCode;
	private String proMake;
	private String proModel;
	private double proPrice;
	private int proQtyAvailable;
	private boolean proInStock;
	private static ArrayList<Product> proList = new ArrayList<>();
	/**
	 * This is the product constructor - it sets up instances of the product class
	 * @param proCode - Product code
	 * @param proMake - Product make
	 * @param proModel - Product model
	 * @param proPrice - Product price
	 * @param proQtyAvailable - Product quantity available
	 * @param proInStock - Product availability
	 */
	public Product(int proCode, String proMake, String proModel, double proPrice, boolean proInStock, int proQtyAvailable) {
		this.proCode = proCode;
		this.proMake = proMake;
		this.proModel = proModel;
		this.proPrice = proPrice;
		this.proInStock = proInStock;
		this.proQtyAvailable = proQtyAvailable;
		proList.add(this);
	}
	/**
	 * This method will return a formatted string with the product details in it
	 * @return productDetails - The product's details
	 */
	public String getProductDetails() {
		String productDetails = "Product code: " + Integer.toString(proCode);
		productDetails += "\nProduct make: " + proMake;
		productDetails += "\nProduct model: " + proModel;
		productDetails += "\nProduct price: " + Double.toString(proPrice);
		if (proInStock) {
			productDetails += "\nThis product is in stock";
			productDetails += "\nQuantity available: " + proQtyAvailable;
		} else {
			productDetails += "\nThis product is not in stock";
		}
		return productDetails;
	}
	/**
	 * This method returns the proCode variable
	 * @return the proCode
	 */
	public int getProCode() {
		return proCode;
	}
	/**
	 * This method return the proMake variable
	 * @return the proMake
	 */
	public String getProMake() {
		return proMake;
	}
	/**
	 * This method returns the proModel variable
	 * @return the proModel
	 */
	public String getProModel() {
		return proModel;
	}
	/**
	 * This method returns the proPrice variable
	 * @return the proPrice
	 */
	public double getProPrice() {
		return proPrice;
	}
	/**
	 * This method returns the proQtyAvailable variable
	 * @return the proQtyAvailable
	 */
	public int getProQtyAvailable() {
		return proQtyAvailable;
	}
	/**
	 * This method returns the proInStock value
	 * @return the proInStock
	 */
	public boolean isProInStock() {
		return proInStock;
	}
	public static ArrayList<Product> getProductList() {
		return proList;

	}
	/**
	 * This method sets the new proCode value 
	 * @param proCode the proCode to set
	 */
	public void setProCode(int proCode) {
		this.proCode = proCode;
	}
	/**
	 * This method sets the new proMake value
	 * @param proMake the proMake to set
	 */
	public void setProMake(String proMake) {
		this.proMake = proMake;
	}
	/**
	 * This method sets the new proModel value 
	 * @param proModel the proModel to set
	 */
	public void setProModel(String proModel) {
		this.proModel = proModel;
	}
	/**
	 * This method sets the new proPrice value
	 * @param proPrice the proPrice to set
	 */
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	/**
	 * This method sets the new proQtyAvailable value
	 * @param proQtyAvailable the proQtyAvailable to set
	 */
	public void setProQtyAvailable(int proQtyAvailable) {
		this.proQtyAvailable = proQtyAvailable;
	}
	/**
	 * This method sets the proInStock value
	 * @param proInStock the proInStock to set
	 */
	public void setProInStock(boolean proInStock) {
		this.proInStock = proInStock;
	}
	public static void setProductList(Product product) {
		proList.add(product);
	}
	/**
	 * This method uses a scanner to take in user input to allow the user to create their own product
	 * @return product - the product object the user has just created
	 */
	public static Product addProduct() {
		System.out.println("\n----Create a new Product----");
		Random randomGen = new Random();
		int proCode = randomGen.nextInt(1000000);
		System.out.println("Enter product make");
		String proMake = Validation.validateStrings();
		System.out.println("Enter product model");
		String proModel = Validation.validateStrings();
		System.out.println("Enter product price");
		double proPrice = Validation.validateDoubles();
		System.out.println("Is the product in stock(true/false)");
		boolean proInStock = Validation.validateBooleans();
		if (proInStock = true) {
			System.out.println("How many of these are in stock?");
			int proQtyAvailable = Validation.validateInts();
			Product product = new Product(proCode, proMake, proModel, proPrice, proInStock, proQtyAvailable);
			return product;
		} else {
			Product product = new Product(proCode, proMake, proModel, proPrice, proInStock, 0);
			setProductList(product);
			return product;
		}
	}
	/**
	 * This method is used to ask the user if they wish to add another product to the new supplier they have created
	 * @param supplier
	 */
	public static void addMoreProducts(Supplier supplier) {
		System.out.println("Would you like to add another product?");
		String choice = Validation.validateStrings().toLowerCase().trim();
		if (choice.equals("yes")) {
			Product product = addProduct();
			supplier.setSupProducts(product);
			addMoreProducts(supplier);
		} else if (choice.equals("no")) {

		} else {
			System.out.println("Please enter a yes or no answer");
			addMoreProducts(supplier);
		}
	}
	public static void deleteProduct(Product product) {
		product.equals(null);
		System.out.println("The product has been deleted");
	}
	public static void editProduct(Product product) {
		System.out.println("What part of the product do you wish to edit?\n1 - Make\n2 - Model\n3 - Price\n4 - Availability\n5 - Quantity in stock\n6 - Back to main menu\n7 - Exit application");
		int choice = Validation.validateInts();
		if (choice >=1 && choice <=7) {
			switch (choice) {
			case 1: System.out.println("What would you like to change the make too?");
			String make = Validation.validateStrings();
			product.setProMake(make);
			case 2: System.out.println("What would you like to change the model too?");          
			String model = Validation.validateStrings();
			product.setProModel(model);
			case 3: System.out.println("What would you like to change the price too?");
			double price = Validation.validateDoubles();
			product.setProPrice(price);
			case 4: System.out.println("Is this product available?(True/False)");
			boolean available = Validation.validateBooleans();
			product.setProInStock(available);
			case 5: System.out.println("How many are available");
			int stockQuantity = Validation.validateInts();
			product.setProQtyAvailable(stockQuantity);
			case 6: MainMenu.mainMenu();
			case 7: System.exit(0);
			}
		} else {
			System.out.println("Please enter a number between 1 and 7");
		}
	}
	public static void stockCheck() {
		System.out.println("Please enter the product code of the product you wish to find");
		int proCode = Validation.validateInts();
		for (Product product : proList) {
			if (product.getProCode() == proCode) {
				System.out.println("There are " + product.getProQtyAvailable() + " available");
			} else {
				System.out.println("g");
			}
		}
	}
	public static void produceQuote(double sum) {
		System.out.println("Enter the product code of the item you are searching for");
		int proCode = Validation.validateInts();
		for (Product product : proList) {
			if (product.getProCode() == proCode) {
				if (product.getProQtyAvailable() > 0) {
					System.out.println("How many would you like to get a quote for?");
					int choice = Validation.validateInts();
					if (choice <= product.getProQtyAvailable() && choice > 0) {
						sum += choice * product.getProPrice();
						System.out.println("Product: " + product.getProCode() + " has been added");
						System.out.printf("The sum is now: £%.2f", sum);
						System.out.println();
					} else {
						System.out.println("There arent that many available");
						System.out.println("There are " + product.getProQtyAvailable() + " available");
						produceQuote(sum);
					}
				}
			}
		}
		System.out.println("You're item was only ordered if confirmation was given and your new sum was printed also - if this didn't happen this means your item wasnt ordered - Perhaps it isn't in stock at the moment");
		System.out.println("Would you like to add another product to your quote?");
		String choice = Validation.validateStrings();
		if (choice.trim().toLowerCase().equals("yes")) {
			produceQuote(sum);
		} else if (choice.trim().toLowerCase().equals("no")) {
			MainMenu.mainMenu();
		}
	}
	public static void printAllProducts() {
		try {
			ArrayList<Supplier> supList = Supplier.getSupplierList();
			for (Supplier supplier : supList) {
				int index = 1;
				System.out.println("Supplier " + index + ": " + supplier.getSupName());
				supplier.printProductList();
				index++;
			}
			System.out.println("----No more supplier's products to list----");
		}
		catch(Exception e) {
			System.out.println("Something went wrong - make sure you have added a supplier\n");
		}
	}
	public static Product productChoice() {
		try {
		ArrayList<Product> proList = new ArrayList<>();
		int index = 1;
		System.out.println("How would you like to search for the product?");
		System.out.println("1 - Product code\n2 - Make\n3 - Model\n4 - Price");
		int choice = Validation.validateInts();
		while (choice >= 1 && choice <= 4) {
			switch (choice) {
			case 1: proList = Searching.searchByCode(); break;
			case 2: proList = Searching.searchByMake(); break;
			case 3: proList = Searching.searchByModel(); break;
			case 4: proList = Searching.searchByPrice(); break;
			}
			for (Product product : proList) {
				System.out.println(index + ": " + product.getProductDetails());
				index++;
			}
			System.out.println("Which product do you want to choose?");
			int userChoice = Validation.validateInts();
			Product product = proList.get(userChoice - 1);
			return product;
		}
		System.out.println("Please enter a value between 1 and 4");
		return productChoice();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please make sure the value's you enter are valid");
			return productChoice();
		}
	}
	public static void addProductOption() {
		try {
			ArrayList<Supplier> supList = Supplier.getSupplierList();
			System.out.println("Which supplier would you like to add this product to?");
			int index = 1;
			for (Supplier supplier : supList) {
				System.out.println(index + ": " + supplier.getSupName());
				index++;
			}
			int userChoice = Validation.validateInts();
			Supplier newSupplier = supList.get(userChoice - 1);
			newSupplier.setSupProducts(Product.addProduct());
		}
		catch(Exception e) {
			System.out.println("Something went wrong - perhaps no suppliers have been added or you have added an incorrect data type for the question asked\n");
		}
	}
	public static void productSearch() {
		ArrayList<Product> proList = new ArrayList<>();
		int index = 1;
		System.out.println("How would you like to search for the product?");
		System.out.println("1 - Product code\n2 - Make\n3 - Model\n4 - Price");
		int choice = Validation.validateInts();
		if (choice >= 1 && choice <= 4) {
			switch (choice) {
			case 1: proList = Searching.searchByCode(); break;
			case 2: proList = Searching.searchByMake(); break;
			case 3: proList = Searching.searchByModel(); break;
			case 4: proList = Searching.searchByPrice(); break;
			}
			for (Product product : proList) {
				System.out.println(index + ": " + product.getProductDetails());
				index++;
			}
			System.out.println("Have you found the product you were looking for?");
			String userInput = Validation.validateStrings();
			if (userInput.trim().toLowerCase().equals("yes")) {
				MainMenu.mainMenu();
			} else if (userInput.trim().toLowerCase().equals("No")){
				System.out.println("Re-running search, please try again(maybe try using a different search parameter)");
				productSearch();
			}
		} else {
			System.out.println("Please enter a value between 1 and 4");
			productSearch();
		}
	}
}
