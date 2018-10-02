package part02;

import java.util.ArrayList;

public class Address {
	private int bldNum;
	private String bldStreet;
	private String bldTown;
	private String bldPcode;
	private String bldCountry;
	private static ArrayList<Address> addressList;
	/**
	 * This is the address constructor - it sets up address instances
	 * @param bldNum - building number
	 * @param bldStreet - building street
	 * @param bldTown - building town
	 * @param bldPcode - building postcode
	 * @param bldCountry - building country
	 */
	public Address(int bldNum, String bldStreet, String bldTown, String bldPcode, String bldCountry) {
		this.bldNum = bldNum;
		this.bldStreet = bldStreet;
		this.bldTown = bldTown;
		this.bldPcode = bldPcode;
		this.bldCountry = bldCountry;
		addressList = new ArrayList<>();
	}
	/**
	 * This method formats a string to return a full address
	 * @return fullAddress - The full address in a formatted string
	 */
	public String getFullAddress() {
		String fullAddress = "Building number: " + bldNum + " " + bldStreet;
		fullAddress += "\nBuilding town: " + bldTown;
		fullAddress += "\nBuilding postcode: " + bldPcode;
		fullAddress += "\nBuilding country: " + bldCountry;
		return fullAddress;
	}
	/**
	 * This methods returns the bldnum variable
	 * @return the bldNum
	 */
	public int getBldNum() {
		return bldNum;
	}
	/**
	 * This method returns the bldStreet variable
	 * @return the bldStreet
	 */
	public String getBldStreet() {
		return bldStreet;
	}
	/**
	 * This method returns the bldtown variable
	 * @return the bldTown
	 */
	public String getBldTown() {
		return bldTown;
	}
	/**
	 * This method returns the bldpcode variable
	 * @return the bldPcode
	 */
	public String getBldPcode() {
		return bldPcode;
	}
	/**
	 * This method returns the bldcountry variable
	 * @return the bldCountry
	 */
	public String getBldCountry() {
		return bldCountry;
	}
	public static ArrayList<Address> getAddressList() {
		return addressList;
	}
	/**
	 * Sets the new bldnum
	 * @param bldNum the bldNum to set
	 */
	public void setBldNum(int bldNum) {
		this.bldNum = bldNum;
	}
	/**
	 * Sets the new bldstreet
	 * @param bldStreet the bldStreet to set
	 */
	public void setBldStreet(String bldStreet) {
		this.bldStreet = bldStreet;
	}
	/**
	 * Sets the new bldtown
	 * @param bldTown the bldTown to set
	 */
	public void setBldTown(String bldTown) {
		this.bldTown = bldTown;
	}
	/**
	 * Sets the new bldpcode
	 * @param bldPcode the bldPcode to set
	 */
	public void setBldPcode(String bldPcode) {
		this.bldPcode = bldPcode;
	}
	/**
	 * Sets the new bldcountry
	 * @param bldCountry the bldCountry to set
	 */
	public void setBldCountry(String bldCountry) {
		this.bldCountry = bldCountry;
	}
	public static void setAddressList(Address address) {
		addressList.add(address);
	}
	/**
	 * This method uses a scanner to take in user input to allow the user to create their own address
	 * @return address - the address object the user has created
	 */
	public static Address addAddress() {
		System.out.println("----Create an Address----");
		System.out.println("Input building number");
		int bldNum = Validation.validateInts();
		System.out.println("Input building street");
		String bldStreet = Validation.validateStrings();
		System.out.println("Input building town");
		String bldTown = Validation.validateStrings();
		System.out.println("Input building postcode");
		String bldPcode = Validation.validatePostcodes();
		System.out.println("Input building country");
		String bldCountry = Validation.validateStrings();
		Address address = new Address(bldNum, bldStreet, bldTown, bldPcode, bldCountry);
		setAddressList(address);
		System.out.println(address.getFullAddress());
		return address;
	}
}
