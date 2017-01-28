package pos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OrderPizza {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.##");
		Scanner keyboard = new Scanner(System.in);
		
		//Create an instance of a Pizza
	    Pizza order = new Pizza ();

		// Variables
		String name; // first name of user
		char crustType;
		String crust; // name of crust
		int pizzaSize; // pizza size
		double cost = 0.0; // pizza cost
		double tax; // tax amount
		final double taxRate = 0.08;
		double total; // total of pizza + toppings
		double completeTotal; // complete cost of order incl. tax + delivery
		double distance = 0;
		double deliveryFee = 0;
		
		int additionalTopping = 0;
		int additionalTopping2 = 0;
		int totalToppings;
		String defaultTopping = "Cheese";

		// Prompts for name
		System.out.println("Enter your name: ");
		name = keyboard.nextLine();

		// Prompts for distance
		System.out.println("Please enter total distance in miles from our Pizza Parlour (0 for collection):");
		distance = keyboard.nextDouble();
		
		if (distance == 0) {
			deliveryFee = 0;
			System.out.println("There is no delivery fee.");
		} else {
			deliveryFee = ((distance * 0.1) + 2);
			System.out.println("Your delivery fee is: £" + df.format(deliveryFee));
		}
		
		// Prompts for pizza size
		System.out.print("What size of pizza would you like? (Small [7], Medium [9] or Large [14])");
		pizzaSize = keyboard.nextInt();
		if (pizzaSize == 7) {
			order.setCost(7.99);
			order.setSize(pizzaSize);
		} else if (pizzaSize == 9) {
			order.setCost(8.99);
			order.setSize(pizzaSize);
		} else if (pizzaSize == 14) {
			order.setCost(13.99);
			order.setSize(pizzaSize);
		} else if (pizzaSize != 7 && pizzaSize != 9 && pizzaSize != 14) {
			System.out.println("We don't serve the amount you've provided, we can serve you a Medium [9 inch]");
			order.setCost(9);
		}
		
		keyboard.nextLine();
		// Prompts user for type of crust
		System.out.print("What type of crust do you want? (F)lat-Bread, (T)hick-Crust, or (P)an-Crust (enter F, T, or P): ");
		crustType = keyboard.nextLine().charAt(0);

		if (crustType == 'F' || crustType == 'f') {
			order.setCrust("Flat-Bread");
		} else if (crustType == 'T' || crustType == 't') {
			order.setCrust("Thick-Crust");
		} else if (crustType == 'P' || crustType == 'p') {
			order.setCrust("Pan-Crust");
		} else if (crustType != 'F' && crustType != 'f' && crustType != 'T' && crustType != 't' && crustType != 'P'
				&& crustType != 'p') {
			System.out.println(
					"We don't serve the crust type that you've mentioned, we will serve you Pan-Crust though...");
		}
		order.setCrust("Pan-Crust");

		// Prompts user for additional toppings
		System.out.println("All pizzas are served with cheese by default");
		System.out.println("Additional toppings are £1.25 each - choose from Chicken and Jalapenos");

		// Additional Topping 1 - Chicken
		System.out.println("Would you like Chicken Topping? (Y/N)");
		additionalTopping = keyboard.nextLine().charAt(0);
		if (additionalTopping == 'Y' || additionalTopping == 'y') {
			additionalTopping = 1;
			defaultTopping = defaultTopping + " and Chicken";
		} else {
			additionalTopping = 0;
		}

		// Additional Topping 2 - Jalapenos
		System.out.println("Do you want Jalapenos? (Y/N)");
		additionalTopping2 = keyboard.nextLine().charAt(0);
		if (additionalTopping2 == 'Y' || additionalTopping2 == 'y') {
			additionalTopping2 = 1;
			defaultTopping = defaultTopping + " and Jalapenos";
		} else {
			additionalTopping2 = 0;
		}

		totalToppings = (additionalTopping) + (additionalTopping2);

		 //set number of toppings and topping list on pizza ordered
	    order.setNumToppings(totalToppings);
	    order.setToppingList(defaultTopping);
	    //add additional toppings cost to cost of pizza
	    order.setCost(1.25*totalToppings);
	    
		// Calculations
		total = (order.getCost()) + (totalToppings * 1.25) + (deliveryFee);
		tax = total * taxRate;
		completeTotal = total * (1 + taxRate);
		
	    //display order confirmation
	    System.out.println();
	    System.out.println(name + ", Your order is as follows: ");
	    System.out.println("Size: " + order.getSize() + " inch pizza");
	    System.out.println("Crust: " + order.getCrust());
	    System.out.println("Toppings: " + order.getToppingList());
	    System.out.println();
		System.out.println("Tax: £" + df.format(tax));
		System.out.println("Total Due: £" + order.getCost());
		
	
System.out.println("Total Due: £" + df.format(completeTotal));
	}
}