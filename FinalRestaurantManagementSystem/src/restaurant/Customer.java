package restaurant;
import java.util.*;
public class Customer extends ManageFood{
HashMap<String, Integer> order;
	

	Customer() {
		order = new HashMap<String, Integer>();
		
	}

	void displayMenu() {
		super.displayMenu();
	}

	void displayOrder() {
		

		if (order.isEmpty()) {
			System.out.println("No items in order.");
			return;
		}

		Set<String> foodNames = new HashSet<String>();
		foodNames = order.keySet();
		System.out.println("-------------------------------------");
		System.out.println("FOOD \t QUANTITY \t PRICE \t TOTAL");
		System.out.println("-------------------------------------");
		for (String food : foodNames) {
			System.out.println(food + "\t" + order.get(food) + "\t" + menu.get(food) + "\t"
					+ menu.get(food) * order.get(food));
		}
		System.out.println("-------------------------------------\n");
	}

	boolean orderFood(String food, int quantity) {
		
		if (!super.menu.containsKey(food))
			return false;
		order.put(food, quantity);
		return true;

	}

	boolean removeFood(String food) {
		
		if (!order.containsKey(food))
			return false;
		else
			order.remove(food);
		return true;
	}

	boolean update(String food, int quantity) {
		
		try {
			removeFood(food);
			order.put(food, quantity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	double totalBill() {
		
		double amount = 0;
		Set<String> foodNames = new HashSet<String>();
		foodNames = order.keySet();
		for (String food : foodNames) {
			amount += (super.menu.get(food) * order.get(food));
		}
		
		return amount ;
	}
	
	
	
	

}
