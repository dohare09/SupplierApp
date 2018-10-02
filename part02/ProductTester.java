package part02;
public class ProductTester {
/**
 *  This method will test the Product class by creating 2 instances - one hardcoded and one created by the user
 */
	public static void main(String[] args) {
		Product test1 = new Product(101, "Ford", "Focus", 19999.99, true, 55);
		System.out.println(test1.getProductDetails());
		
		Product test2 = Product.addProduct();
		System.out.println(test2.getProductDetails());
	}
}
