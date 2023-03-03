package restaurant;
import java.util.Scanner;
public class TestMain {
public static void main(String[] args) {
		
		ManageFood managefood= new ManageFood();
		
		Customer customer = new Customer();
		int select;
		String foodItem ;
		float price ;
		int quantity;
		System.out.println("\n------WELCOME TO ANGEL'S RESTAURANT------\n");
		
		
		
		 Scanner scanner=new Scanner(System.in);
		do {
			Main();
			select= scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("------AUTHENTICATION-------");
				System.out.println("Enter username.");
				String uname = scanner.next();
				
				System.out.println("Enter password.");
				String password = scanner.next();
				if (managefood.authorize(uname, password)) {
					System.out.println("valid username and password.");
					
				
				
					
				
				 do {
					 
					 
					
					MenuManageFood();
					
					select= scanner.nextInt();
					switch (select) {
					case 1:
						System.out.println("Enter number of food items to add in menu.");
						int noOfItems = scanner.nextInt();
						for (int i = 0; i < noOfItems; i++) {
							System.out.println("Enter food item ");
						    foodItem = scanner.next();
							System.out.println("Enter its price.");
							price = scanner.nextFloat();
							if (managefood.addFood(foodItem, price))
								System.out.println(foodItem + " added in menu.");
							else
								System.out.println(foodItem + " already in menu.");
							managefood.addFood(foodItem, price);
						}

						break;
					
					case 2:
						System.out.println("Enter food item to update its price.");
						foodItem = scanner.next();
						System.out.println("Enter its price.");
						price = scanner.nextFloat();
						if (managefood.update(foodItem, price))
							System.out.println("Menu updated.");
						else
							System.out.println("Failed to update menu.");
						break;
						
						
					case 3:
						System.out.println("Enter food item to remove.");
						foodItem = scanner.next();
						if (managefood.deleteItem(foodItem))
							System.out.println(foodItem + " removed from menu.");
						else
							System.out.println(foodItem + " does not exist in menu.");
						
						break;
					case 4:
						managefood.displayMenu();
						
						break;
					case 5:
						
						break;
					case 0:
						System.out.println("back");
						break;
					default:
						break;
					}
					
				} while (select !=0);
				} else {
					System.out.println("Invalid username or password.");
					
					
				}
				 
				 
				break;
				 
			case 2:
				
				do {
					customer();
					select= scanner.nextInt();
					switch (select) {
					case 1:
						System.out.println("----MENU----");
						customer.displayMenu();
						
						
						break;	
					case 2:
						System.out.println("Enter food item to add.");
						foodItem = scanner.next();
						System.out.println("Enter " + foodItem + "\'s quantity.");
						quantity = scanner.nextInt();
						if (customer.orderFood(foodItem, quantity))
							System.out.println(quantity + " " + foodItem + " added in order.");
						else
							System.out.println(foodItem + " does not exist in menu.");
					
						
						break;
					
					case 3:
						System.out.println("Enter food item to remove.");
						foodItem = scanner.next();
						if (customer.removeFood(foodItem))
							System.out.println(foodItem + " removed from order");
						else
							System.out.println("Failed to remove " + foodItem);
				            break;
					case 4:   
						System.out.println("Enter food to update quantity.");
						
						foodItem = scanner.next();
						System.out.println("Enter the quantity.");
						quantity = scanner.nextInt();
						if (customer.update(foodItem, quantity))
							System.out.println(quantity + " " + foodItem + " added in order.");
						else
							System.out.println("Failed to update quantity for " + foodItem);
						break;
					
					case 5:
						System.out.println("Your order is ");
						customer.displayOrder();
						break;
						
					case 6:
						System.out.println("Your total amount for following order ");
						System.out.println("-------------------------------------");
						System.out.println("FOOD \t QUANTITY");
						System.out.println("-------------------------------------");
						customer.displayOrder();
						System.out.println("Total Amount = " + customer.totalBill());
						System.out.println("-------------------------------------\n");
						break;
				            
				            
					case 0:
						System.out.println("back");
						break;
					default:
						break;
					}
				} while (select !=0);
				break;

			default:
				break;
			}
		} while (select !=3);
		
		
		
		
		

	}
	static void MenuManageFood() {
		System.out.println("------ADMIN----------");
		System.out.println("0. BACK TO menu main");
		System.out.println("1. Add food");
		System.out.println("2. update food");
		System.out.println("3. Delete food");
		System.out.println("4. Display Menu");
		
		System.out.println("---------------------------");
		System.out.println("select the option");
	}
	static void customer() {
		System.out.println("-------CUSTOMER----------");
		System.out.println("0. BACK TO menu main");
		System.out.println("1. Display Menu ");
		System.out.println("2. Order Food Item ");
		System.out.println("3. Cancel Food Item            ");
		System.out.println("4. Update Food Item Quantity          ");
		System.out.println("5. Display Order           ");
		System.out.println("6. Pay Bill           ");
		System.out.println("---------------------------");
		System.out.println("select the option");
	}
	static void Main() {
		System.out.println("------- MAIN----------");
		System.out.println("1. Admin");
		System.out.println("2. Customer");
		System.out.println("2. Exit");
		System.out.println("select the option");
		
	}


}
