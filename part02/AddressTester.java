package part02;
public class AddressTester {
/**
 * This method will test the Address class by creating 2 instances - one hardcoded and one created by the user 
 */
	public static void main(String[] args) {
		Address test1 = new Address(52, "Crumlin Road", "Belfast", "bt147tf", "Northern Ireland");
		System.out.println(test1.getFullAddress());
		
	Address test2 = Address.addAddress();
	System.out.println(test2.getFullAddress());
	}
}
