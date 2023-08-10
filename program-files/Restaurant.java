import java.util.Scanner;

public class Restaurant {

	// attributes
	private String restaurantName;
	private String restaurantLocation;
	private String restaurantContact;
	private Scanner scanner;

	// constructor
	public Restaurant() {
		scanner = new Scanner(System.in);
	}

	// setter methods
	public void setRestaurantName(String rName) {
		this.restaurantName = rName;
	}

	public void setRestaurantLocation(String rLocation) {
		this.restaurantLocation = rLocation;
	}

	public void setRestaurantContact(String rContact) {
		this.restaurantContact = rContact;
	}

	// getter methods
	public String getRestaurantName() {
		return restaurantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public String getRestaurantContact() {
		return restaurantContact;
	}

	// method requests & set restaurant name
	public void requestRestaurantName() {
		while (true) {
			System.out.print("Enter your restaurant name: ");
			String name = scanner.nextLine().trim();
			if (name.isEmpty()) {
				System.out.println("Please enter a valid restaurant name.");
			} else {
				setRestaurantName(name);
				break;
			}
		}
	}

	// method requests & set restaurant contact number
	public void requestRestaurantContact() {
		while (true) {
			System.out.print("Enter restaurant contact number: ");
			String contact = scanner.nextLine().trim();
			if (contact.length() <= 9) {
				System.out.println("Please enter a valid restaurant contact number.");
			} else {
				setRestaurantContact(contact);
				break;
			}
		}
	}

	// method requests & set restaurant city location
	public void requestRestaurantCityLocation() {
		while (true) {
			System.out.print("Enter restaurant location: ");
			String location = scanner.nextLine().trim();
			if (location.isEmpty()) {
				System.out.println("Please enter a valid restaurant location.");
			} else {
				setRestaurantLocation(location);
				break;
			}
		}
	}

	// method to call restaurant info methods
	public void requestRestaurantInfo() {
		requestRestaurantName();
		requestRestaurantContact();
		requestRestaurantCityLocation();
	}
	// close scanner
	public void closeScanner() {
		scanner.close();
	}
}