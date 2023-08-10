public class Main {
	public static void main(String[] args) {

		// create necessary objects
		Customer customer = new Customer();
		Restaurant restaurant = new Restaurant();
		Meal meal = new Meal();
		DeliveryDriver driver = new DeliveryDriver();
		Invoice invoice = new Invoice();
		
		// call customer method
		customer.getCustomerInfo();
		
		// call restaurant method
		restaurant.requestRestaurantInfo();
		
		// call delivery driver method
		driver.getDeliveryDriver(restaurant);
		
		// call meal method
		meal.requestMealInfo();
		
		// call invoice method
		invoice.writeInvoice(customer, meal, restaurant, driver);
	}
}