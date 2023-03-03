package restaurant;
import java.util.*;

public class ManageFood {
	static HashMap<String, Float> menu;

	public ManageFood() {
		menu = new HashMap<String, Float>();
	}

	
	
	
	
	Scanner scanner=new Scanner(System.in);
	boolean authorize(String username, String password) {
		return username.equals("angel") && password.equals("angel123");
	}
	  
	
     boolean addFood(String food, float price) {
		
		if (menu.containsKey(food))
		{
			return false;
		}else
		{
		menu.put(food, price);
		return true;
		}

		 }
		 boolean update(String food, float price) {
				
				try {
					deleteItem(food);
					addFood(food, price);
				} catch (Exception e) {
					return false;
				}
				return true;

			}
		 boolean deleteItem(String food) {
				
				if (menu.containsKey(food)) {
					menu.remove(food);
					return true;
				} else
					return false;
			}
		 void displayMenu() {
				if (menu.isEmpty()) {
					System.out.println("Menu empty.");
					return;
				}
				else
				{
				Set<String> foodNames = new HashSet<String>();
				foodNames = menu.keySet();
				System.out.println("-------------------------------------");
				System.out.println("FOOD \t PRICE");
				System.out.println("-------------------------------------");
				for (String food : foodNames) {
					System.out.println(food + "\t" + menu.get(food));
				}
				System.out.println("-------------------------------------");
			}
		 }


}
