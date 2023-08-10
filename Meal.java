import java.util.ArrayList;
import java.util.Scanner;

public class Meal {

	// attributes
	private String specialPrep;
	private ArrayList<String> mealList = new ArrayList<>();
	private ArrayList<Integer> quantityList = new ArrayList<>();
	private ArrayList<Double> priceList = new ArrayList<>();
	private Double totalOrderCost;
	private Scanner scanner;

	// constructor
	public Meal() {
		scanner = new Scanner(System.in);
	}

	// setter methods
	public void setSpecialPrep(String specialPrep) {
		this.specialPrep = specialPrep;
	}

	public void setMeal(String meal) {
		mealList.add(meal);
	}

	public void setQuantity(Integer quantity) {
		quantityList.add(quantity);
	}

	public void setPrice(Double price) {
		priceList.add(price);
	}

	public void setTotalOrderCost(Double sumTotal) {
		this.totalOrderCost = sumTotal;
	}

	// getter methods
	public String getSpecialPrep() {
		return specialPrep;
	}

	public Double getTotalCost() {
		return totalOrderCost;
	}

	// get method to return the meal list
	public ArrayList<String> getMealList() {
		return mealList;
	}

	// get method to return the quantity list
	public ArrayList<Integer> getQuantityList() {
		return quantityList;
	}

	// get method to return the price list
	public ArrayList<Double> getPriceList() {
		return priceList;
	}

	// method request & set special prep
	public void requestSpecialPrep() {
		System.out.print("Enter any special preparation for the meals: ");
		String specialprep = scanner.nextLine();
		setSpecialPrep(specialprep);
	}

	boolean addMeal = true;
	// method requests & set meal info
	public void mealInfo() {
		while (addMeal) {
			
			// ask user to enter meal name
			while(true) {
				System.out.print("Enter the name of your meal: ");
				String mealName = scanner.nextLine();
				if (mealName.isEmpty()) {
					System.out.println("Please enter a valid meal name.");
				}else {
					setMeal(mealName);
					break;
				}
			}
			
			// ask user to enter price
			while (true) {
				System.out.print("Enter the price of your meal: ");
				String input = scanner.nextLine();
				try {
					Double mealPrice = Double.parseDouble(input);
					setPrice(mealPrice);
					break;
				}catch (NumberFormatException e){
					System.out.println("Please enter a valid meal price.");
				}
			}
			
			// ask user to enter quantity
			while (true) {
				System.out.print("Enter the quantity of the meal: ");
				String input = scanner.nextLine();
				try {
					Integer mealQuantity = Integer.parseInt(input);
					setQuantity(mealQuantity);
					break;
				}catch (NumberFormatException e){
					System.out.println("Please enter a valid meal quantity.");
				}
			}

			// ask user if they want to add another meal
      while (true) {
        System.out.print("Would you like to add another meal? (y/n): ");
        String addAnotherMeal = scanner.nextLine();
        if (addAnotherMeal.equalsIgnoreCase("n")) {
            addMeal = false;
            break;
        } else if (addAnotherMeal.equalsIgnoreCase("y")) {
            break;
        } else {
            System.out.println("Please enter a valid response.");
        }
      }	

			// calculate the total order cost
			double sumTotal = 0.00;
			for (Integer i = 0; i < priceList.size(); i++) {
				sumTotal += priceList.get(i) * quantityList.get(i);
			}
			// set totalOrderCost
			setTotalOrderCost(sumTotal);
		}
	}

	// method to call meal methods
	public void requestMealInfo() {
		mealInfo();
		requestSpecialPrep();
	}

	// close scanner
	public void closeScanner() {
		scanner.close();
	}
}