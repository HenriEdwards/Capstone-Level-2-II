import java.util.Scanner;

public class Customer {

	// attributes
	private String customerName;
	private String customerContact;
	private String customerAddress;
	private String customerCityLocation;
	private String customerEmail;
	private Scanner scanner;

	// constructor
	public Customer() {
		scanner = new Scanner(System.in);
	}

	// setter methods
	public void setCustomerName(String name) {
		this.customerName = name;
	}

	public void setCustomerContact(String contact) {
		this.customerContact = contact;
	}

	public void setCustomerAddress(String address) {
		this.customerAddress = address;
	}

	public void setCustomerCityLocation(String location) {
		this.customerCityLocation = location;
	}

	public void setCustomerEmail(String email) {
		this.customerEmail = email;
	}

	// getter methods
	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerCityLocation() {
		return customerCityLocation;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	// method requests & set customer name
	public void requestCustomerName() {
		while (true) {
			System.out.print("Enter your name: ");
			String name = scanner.nextLine().trim();
			if (name.isEmpty()) {
				System.out.println("Please enter a valid name.");
			} else {
				setCustomerName(name);
				break;
			}
		}
	}
	
	// method requests & set customer contact
	public void requestCustomerContact() {
		while (true) {
			System.out.print("Enter your contact number: ");
			String contact = scanner.nextLine().trim();
			if (contact.length() <= 9) {
				System.out.println("Please enter a valid contact number.");
			}else {
				setCustomerContact(contact);
				break;
			}
		}
	}

	// method requests & set customer city location
	public void requestCustomerCity() {
		while (true) {
			System.out.print("Enter your city location: ");
			String city = scanner.nextLine();
			if (city.isEmpty()) {
				System.out.println("Please enter a valid city location.");
			}else {
				setCustomerCityLocation(city);
				break;
			}
		}
	}

	// method requests & set customer address
	public void requestCustomerAddress() {
		while (true) {
			System.out.print("Enter your address: ");
			String address = scanner.nextLine();
			if (address.isEmpty()) {
				System.out.println("Please enter a valid address.");
			}else {
				setCustomerAddress(address);
				break;
			}
		}
	}

	// method requests & set customer email
	public void requestCustomerEmail() {
		while (true) {
			System.out.print("Enter your email: ");
			String email = scanner.nextLine();
			if (email.isEmpty() || !email.contains("@")) {
				System.out.println("Please enter a valid email.");
			}else {
				setCustomerEmail(email);
				break;
			}
		}
	}

	// method to call customer info methods
	public void getCustomerInfo() {
		requestCustomerName();
		requestCustomerContact();
		requestCustomerCity();
		requestCustomerAddress();
		requestCustomerEmail();
	}
	// close scanner
	public void closeScanner() {
		scanner.close();
	}
}

