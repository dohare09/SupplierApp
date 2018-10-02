
package part02;
import java.util.ArrayList;
import java.util.Scanner;
public class MainMenu {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Address address1 = new Address(101, "Antrim Road", "Belfast", "Bt366hx", "Northern Ireland");
		Address address2 = new Address(5, "Antrim Road", "Belfast", "Bt147lg", "Northern Ireland");
		Product pro1 = new Product(1022, "Iphone", "8", 1000, true, 800);
		Product pro2 = new Product(10022, "Iphone", "X", 800, true, 1000);
		Product pro3 = new Product(305678, "Galaxy", "S7", 700, false, 0);
		Product pro4 = new Product(234567, "Galaxy", "S8", 900, true, 4456);
		ArrayList<Product> list1 = new ArrayList<>();
		ArrayList<Product> list2 = new ArrayList<>();
		list1.add(pro1);
		list1.add(pro2);
		list2.add(pro3);
		list2.add(pro4);
		Supplier apple = new Supplier(101, "Apple", address1, SupRegion.UNITED_KINGDOM, list1);
		Supplier samsung = new Supplier(101, "Samsung", address2, SupRegion.UNITED_KINGDOM, list2);
		mainMenu();
	}
	public static void mainMenu() {
		System.out.println("----MAIN MENU----");
		System.out.println("1 - Supplier \n2 - Address\n3 - Product\n4 - Exit Application");
		System.out.println("Please enter the number of your chosen option");
			int choice = Validation.validateInts();
			if (choice >= 1 && choice <= 4) {
				switch (choice) {
				case 1 : supplierOptions(); break;
				case 2: addressOptions(); break;
				case 3: productOptions(); break;
				case 4: System.exit(0); break;
				}
			} else {
				System.out.println("Please enter a number between 1 and 4\n");
				mainMenu();
			}
		System.out.println("Please make sure to enter a number\n");
		mainMenu();
	}
	public static void supplierOptions() {
		System.out.println("---Supplier Menu---\n1 - Print all suppliers\n2 - Add a supplier\n3 - Back to main menu\n4 - Exit application");
			int userChoice = Validation.validateInts();
			if (userChoice >=1 && userChoice <=4) {
				switch (userChoice) {
				case 1: Supplier.printSupplierList(); mainMenu();break;
				case 2: Supplier.addSupplier();mainMenu(); break;
				case 3: mainMenu(); break;
				case 4: System.exit(0); break;
				}
			} else {
				System.out.println("Please enter a number between 1 and 4\n");
				supplierOptions();
			}
	}
	public static void addressOptions() {
		System.out.println("---Address Menu---\n1 - Add an address\n2 - Back to main menu\n3 - Exit application");
			int userChoice = Validation.validateInts();
			if (userChoice >= 1 && userChoice <= 3) {
				switch (userChoice) {
				case 1: Address.addAddress(); mainMenu();break;
				case 2: mainMenu(); break;
				case 3: System.exit(0); break;
				}
			} else {
				System.out.println("Please enter a number between 1 and 3\n");
				addressOptions();
			}
	}
	public static void productOptions() {
		System.out.println("---Product Menu---\n1 - Print all products\n2 - Add a product\n3 - Edit a product\n4 - Delete a product\n5 - Search for a product\n6 - Check the stock of a certain product\n7 - Get a quote\n8 - Order a product\n9- Back to main menu\n10 - Exit application");
			int userChoice = Validation.validateInts();
			if (userChoice >=1 && userChoice <=10) {
				switch (userChoice) {
				case 1: Product.printAllProducts(); mainMenu();break;
				case 2: Product.addProductOption(); mainMenu();break;
				case 3: Product editProduct = Product.productChoice(); Product.editProduct(editProduct); mainMenu();break;
				case 4: Product deleteProduct = Product.productChoice(); Product.deleteProduct(deleteProduct); mainMenu();break;
				case 5: Product.productSearch(); mainMenu(); break;
				case 6: Product.stockCheck(); mainMenu(); break;
				case 7: Product.produceQuote(0); mainMenu(); break;
				case 8: Order.placeAnOrder(); mainMenu(); break;
				case 9: mainMenu(); break;
				case 10: System.exit(0); break;
				}
			} else {
				System.out.println("Please enter a number between 1 and 10\n");
				productOptions();
			}
	}
}