import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;

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

			// create a stringBuilder object
			StringBuilder stringBuilder = new StringBuilder();

			if (!customer.getCustomerCityLocation().equalsIgnoreCase(driver.getDeliveryDriverLocation())) {
				stringBuilder.append("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
			} else {
				// increase order #
				setOrderNumber(++orderNumber);

				// write the order details to file
				stringBuilder.append("Order number: ").append(getOrderNumber()).append("\n");
				stringBuilder.append("Customer: ").append(customer.getCustomerName()).append("\n");
				stringBuilder.append("Email: ").append(customer.getCustomerEmail()).append("\n");
				stringBuilder.append("Phone number: ").append(customer.getCustomerContact()).append("\n");
				stringBuilder.append("Location: ").append(customer.getCustomerCityLocation()).append("\n\n");
				stringBuilder.append("You have ordered the following from ").append(restaurant.getRestaurantName())
						.append(" in ").append(restaurant.getRestaurantLocation()).append(":\n\n");

				// loop to write each meal item/price/quantity to file
				for (int i = 0; i < meal.getMealList().size(); i++) {
					String mealName = meal.getMealList().get(i);
					Integer quantity = meal.getQuantityList().get(i);
					// format price to ensure 2 decimals
					String mealPriceFormatted = String.format("%.2f", meal.getPriceList().get(i));
					String price = mealPriceFormatted;
					stringBuilder.append(quantity).append(" x ").append(mealName).append(" (R").append(price).append(")\n");
				}
				stringBuilder.append("\n");

				// add special prep or none
				if (!meal.getSpecialPrep().isEmpty()) {
					stringBuilder.append("Special instructions: ").append(meal.getSpecialPrep()).append("\n\n");
				} else {
					stringBuilder.append("Special instructions: None\n\n");
				}

				// call getTotalCost method & format to ensure 2 decimals
				stringBuilder.append("Total: R").append(String.format("%.2f", meal.getTotalCost())).append("\n\n");
				stringBuilder.append(driver.getDeliveryDriverName())
						.append(" is nearest to the restaurant and so he will be delivering your order to you at:\n\n");

				// check if there is a space in the customer address
				if (customer.getCustomerAddress().contains(" ")) {
					// find index of the last space " " char
					int lastSpaceIndex = customer.getCustomerAddress().lastIndexOf(" ");
					String firstLine = customer.getCustomerAddress().substring(0, lastSpaceIndex);
					String secondLine = customer.getCustomerAddress().substring(lastSpaceIndex + 1);
					stringBuilder.append(firstLine).append("\n").append(secondLine).append("\n\n");
				} else {
					stringBuilder.append(customer.getCustomerAddress()).append("\n\n");
				}
				stringBuilder.append("If you need to contact the restaurant, their number is ")
						.append(restaurant.getRestaurantContact()).append(".");
			}

			// write stringBuilder to txt file
			writer.write(stringBuilder.toString());
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred while writing the invoice: " + e.getMessage());
		}
	}
}
