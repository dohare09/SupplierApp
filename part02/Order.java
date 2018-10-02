package part02;

import java.util.ArrayList;

public class Order {
	private double sum;
	private ArrayList<Product> proList;
	private Supplier supplier;
	public Order(double sum, ArrayList<Product> proList, Supplier supplier) {
		this.sum = sum;
		this.proList = proList;
		this.supplier = supplier;
	}
	public double getSum() {
		return sum;
	}
	public ArrayList<Product> getProList() {
		return proList;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public void setProList(Product product) {
		this.proList.add(product);
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public static void placeAnOrder() {
		Supplier supplier = findSupplier();
		supplier.printProductList();
		ArrayList<Product> proList = supplier.getSupProducts();
		System.out.println("Enter the number of your product");
		int userChoice = Validation.validateInts();
		Product product = proList.get(userChoice - 1);
		ArrayList<Product> orderList = new ArrayList<>();
		orderList.add(product);
		System.out.println("How much of this product would you like to order?");
		int quantity = Validation.validateInts();
		if (quantity <= product.getProQtyAvailable() && quantity > 0) {
			double sum = 0;
			sum += product.getProPrice() * quantity;
			product.setProQtyAvailable(product.getProQtyAvailable() - quantity);
		    Order order = new Order(sum, orderList, supplier);
			System.out.println("Would you like to order another product?");
			String choice = Validation.validateStrings();
			if (choice.trim().toLowerCase().equals("yes")) {
				addToAnOrder(order);
			} else if (choice.trim().toLowerCase().equals("no")) {
				printOrderDetails(order);
			} else {
				System.out.println("Please enter a yes or no answer");
			}
		} else {
			System.out.println("ERROR - Input a possible number for the quantity, there are only " + product.getProQtyAvailable() + " available");
			System.out.println("You will have to re do your current order, products ordered previously will be fine");
			placeAnOrder();
		}
	}
	public static Supplier findSupplier() {
		System.out.println("Which supplier are you ordering from?");
		Supplier.printSupplierList();
		ArrayList<Supplier> supList = new ArrayList<>();
		supList = Supplier.getSupplierList();
		System.out.println("Enter the number of the supplier you wish to choose");
		int userChoice = Validation.validateInts();
		Supplier chosenSupplier = supList.get(userChoice - 1);
		return chosenSupplier;
	}
	public static void addToAnOrder(Order order) {
		order.getSupplier().printProductList();
		ArrayList<Product> proList = order.getSupplier().getSupProducts();
		System.out.println("Enter the number of your product");
		int userChoice = Validation.validateInts();
		Product product = proList.get(userChoice - 1);
		order.setProList(product);
		System.out.println("How much of this product would you like to order?");
		int quantity = Validation.validateInts();
		if (quantity <= product.getProQtyAvailable() && quantity > 0) {
			@SuppressWarnings("unused")
			double sum = 0;
			sum += product.getProPrice() * quantity;
			product.setProQtyAvailable(product.getProQtyAvailable() - quantity);
			System.out.println("Would you like to order another product?");
			String choice = Validation.validateStrings();
			if (choice.trim().toLowerCase().equals("yes")) {
				addToAnOrder(order);
			} else if (choice.trim().toLowerCase().equals("no")) {
				printOrderDetails(order);
			} else {
				System.out.println("Please enter a yes or no answer");
			}
		} else {
			System.out.println("ERROR - Input a possible number for the quantity, there are only " + product.getProQtyAvailable() + " available");
			System.out.println("You will have to re do your current order, products ordered previously will be fine");
			addToAnOrder(order);
		}
	}
	public static void printOrderDetails(Order order) {
		System.out.println("These are the products you have ordered");
		int index = 1;
		for (Product product : order.getProList()) {
			System.out.println(index + ": " + product.getProductDetails());
			index++;
		}
		System.out.println("You have ordered them from the supplier: " + order.getSupplier().getSupName());
		System.out.printf("The total cost will be: £%.2f", order.getSum());
	}
}
