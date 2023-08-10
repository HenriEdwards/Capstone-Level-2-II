import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DeliveryDriver {

	// attributes
	private String deliveryDriverName;
	private String deliveryDriverLocation;
	private Scanner scanner;

	// constructor
	public DeliveryDriver() {
		scanner = new Scanner(System.in);
	}

	// setter methods
	public void setDeliveryDriverName(String driverName) {
		this.deliveryDriverName = driverName;
	}

	public void setDeliveryDriverLocation(String driverLocation) {
		this.deliveryDriverLocation = driverLocation;
	}

	// getter methods
	public String getDeliveryDriverName() {
		return deliveryDriverName;
	}

	public String getDeliveryDriverLocation() {
		return deliveryDriverLocation;
	}

	// find driver location
	public void getDeliveryDriver(Restaurant restaurant) {

		// initialize variable to compare driver load
		Integer lowestOrder = Integer.MAX_VALUE;
		// initialize variable
		String driverDeliveries = "";
		try {
			// read the file
			File file = new File("drivers.txt");
			Scanner fileScanner = new Scanner(file);

			// loop through each line in the file
			while (fileScanner.hasNextLine()) {

				// read the next line from the file
				String line = fileScanner.nextLine();

				// split the line into an array of strings using the comma delimiter
				String[] parts = line.split(",");

				// extract location & current driver deliveries
				String driverName = parts[0].trim();
				String driverLocation = parts[1].trim();

				// if driver deliveries are empty, assign 0
				if (parts[2].trim() == "") {
					driverDeliveries = "0";
				} else {
					driverDeliveries = parts[2].trim();
				}

				// compare the driver location to the entered restaurant location
				if (restaurant.getRestaurantLocation().equalsIgnoreCase(driverLocation)) {
					Integer currentOrders = Integer.parseInt(driverDeliveries);
					// determine driver with least orders
					if (currentOrders < lowestOrder) {
						lowestOrder = currentOrders;
						setDeliveryDriverName(driverName);
						setDeliveryDriverLocation(driverLocation);
					}
				}
			}
			// close the file reader
			fileScanner.close();
		} catch (IOException e) {
			System.err.println("File not found: " + e.getMessage());
		}
	}
	// close scanner
	public void closeScanner() {
		scanner.close();
	}
}