import java.io.FileWriter;
import java.io.IOException;

public class Invoice {

	// attributes
	private Integer orderNumber = 0;
	private static final String INVOICE_FILE_NAME = "invoice.txt";

	// setter methods
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	// getter methods
	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void writeInvoice(Customer customer, Meal meal, Restaurant restaurant, DeliveryDriver driver) {
		try {
			// create a FileWriter object to write output to
			FileWriter writer = new FileWriter(INVOICE_FILE_NAME);

			if (!customer.getCustomerCityLocation().equalsIgnoreCase(driver.getDeliveryDriverLocation())) {
				writer.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
			} else {
				// increase order #
				setOrderNumber(++orderNumber);

				// write the order details to file
				writer.write("Order number: " + getOrderNumber() + "\n");
				writer.write("Customer: " + customer.getCustomerName() + "\n");
				writer.write("Email: " + customer.getCustomerEmail() + "\n");
				writer.write("Phone number: " + customer.getCustomerContact() + "\n");
				writer.write("Location: " + customer.getCustomerCityLocation() + "\n\n");
				writer.write("You have ordered the following from " + restaurant.getRestaurantName() + " in "
						+ restaurant.getRestaurantLocation() + ":\n\n");

				// loop to write each meal item/price/quantity to file
				for (int i = 0; i < meal.getMealList().size(); i++) {
					String mealName = meal.getMealList().get(i);
					Integer quantity = meal.getQuantityList().get(i);
					// format price to ensure 2 decimals
					String mealPriceFormatted = String.format("%.2f", meal.getPriceList().get(i));
					String price = mealPriceFormatted;
					writer.write(quantity + " x " + mealName + " (R" + price + ")\n");
				}
				writer.write("\n");

				// add special prep or none
				if (!meal.getSpecialPrep().isEmpty()) {
					writer.write("Special instructions: " + meal.getSpecialPrep() + "\n\n");
				} else {
					writer.write("Special instructions: None\n\n");
				}

				// call getTotalCost method & format to ensure 2 decimals
				writer.write("Total: R" + String.format("%.2f", meal.getTotalCost()) + "\n\n");
				writer.write(driver.getDeliveryDriverName()
						+ " is nearest to the restaurant and so he will be delivering your order to you at:\n\n");

				// check if there is a space in the customer address
				if (customer.getCustomerAddress().contains(" ")) {
					// find index of the last space " " char
					int lastSpaceIndex = customer.getCustomerAddress().lastIndexOf(" ");
					String firstLine = customer.getCustomerAddress().substring(0, lastSpaceIndex);
					String secondLine = customer.getCustomerAddress().substring(lastSpaceIndex + 1);
					writer.write(firstLine + "\n" + secondLine + "\n\n");
				} else {
					writer.write(customer.getCustomerAddress() + "\n\n");
				}
				writer.write("If you need to contact the restaurant, their number is " + restaurant.getRestaurantContact() + ".");
			}
			// close the FileWriter
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred while writing the invoice: " + e.getMessage());
		}
	}
}

