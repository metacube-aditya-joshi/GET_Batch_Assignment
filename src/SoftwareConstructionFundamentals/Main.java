package SoftwareConstructionFundamentals;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		ArrayList<Item> itemsStorage = new ArrayList<Item>();
		
		itemsStorage.add(new Item("1","Excel","Detergent",10));
		itemsStorage.add(new Item("2","Surf Excel","Detergent",10));
		itemsStorage.add(new Item("3","Tide","Detergent",15));
		itemsStorage.add(new Item("4","Dove","Soap",30));
		itemsStorage.add(new Item("5","Colgate","ToothPaste",45));
		itemsStorage.add(new Item("6","Zara","T- Shirt",60));
		itemsStorage.add(new Item("7","Clinic Plus","Shampoo",50));
		itemsStorage.add(new Item("8","Reynolds","Pen",70));
		itemsStorage.add(new Item("9","Natraj","Pencil",90));
		itemsStorage.add(new Item("10","Cleanx","A wall mop",150));
		itemsStorage.add(new Item("11","Gala","Broom",250));
		
		
		

		  Scanner inputStream = new Scanner(System.in);
		  String input ="";

		  while(!input.equals("6"))
		 {
			for(Item item : itemsStorage)
			{
			System.out.println("Item Id : "+item.ItemId+"\n Name :" + item.Name +"\n Description : "
			+ item.Description+"\n Price : $"+item.Price);
			}
			 
		    input = inputStream.nextLine() ;
						
			System.out.println("Enter the Choice");
			System.out.println("1. Add items to cart");
			System.out.println("2. Display quantity of an item ");
			System.out.println("3. Update quantity of an item in cart");
			System.out.println("4. Remove Item from cart");
			System.out.println("5. Checkout ");
			System.out.println("6. Exit");
			
			ShoppingCart cart = new ShoppingCart();
			 
			 int option = inputStream.nextInt();
			 System.out.println(option);
		 
			 switch(option)
			 {
			 case 1 : addItemToCart(cart,inputStream,itemsStorage);
			 case 2 : displayItemQuantity(cart,inputStream,itemsStorage);
			 case 3 : updateItemQuantity(cart,inputStream,itemsStorage);
			 case 4 : deleteItemFromCart(cart,inputStream,itemsStorage);
			 case 5 : cart.displayBill();
			 case 6 : System.out.println(option);
				
				 default :
					 System.out.println("Invalid Option choosen. Please select a valid option .");
				 
			 
			 }
			 
		 }
	}
	 
	 
	private static void addItemToCart(ShoppingCart cart,Scanner inputStream, ArrayList<Item> itemsStorage) {
		{
			 System.out.println("Select the Item ... : ");
		     int itemIdChoosen = inputStream.nextInt();
		     Item item =new Item();
		     for(int index=0;index<itemsStorage.size();index++)
		     {
		    	 if(index==itemIdChoosen) {
		    		 item = itemsStorage.get(index);
		    		 break;
		    	 }
		     }
		     
		     System.out.println("Enter the quantity of Item ... : ");
		     int quantityChoosen = inputStream.nextInt();
		     
		     
		     
			 cart.addToCart(item, quantityChoosen);
			 
		 }
	}
    private static void displayItemQuantity(ShoppingCart cart,Scanner inputStream, ArrayList<Item> itemsStorage) {
    	
			 System.out.println("Select the Item ... : ");
		     int itemIdChoosen = inputStream.nextInt();
		     
		     Item item = itemsStorage.get(itemIdChoosen);
		     cart.displayQty(item);
		     
		 
    }
    private static void updateItemQuantity(ShoppingCart cart,Scanner inputStream, ArrayList<Item> itemsStorage) {
    	 System.out.println("Select the Item ... : ");
	     int itemIdChoosen = inputStream.nextInt();
	     
	     if (!itemsStorage.contains(itemIdChoosen)) {
		    	System.out.println("Invalid Item Choosen !!");
		 }
	     
	     System.out.println("Enter the quantity of Item ... : ");
	     int quantityChoosen = inputStream.nextInt();
	     Item item = itemsStorage.get(itemIdChoosen);
	     cart.updateQty(item, quantityChoosen);
	     
    }
    private static void deleteItemFromCart(ShoppingCart cart,Scanner inputStream, ArrayList<Item> itemsStorage) {
    	 System.out.println("Select the Item ... : ");
	     int itemIdChoosen = inputStream.nextInt();
	     
	     if(!itemsStorage.contains(itemIdChoosen)) {
	    	System.out.println("Invalid Item Choosen !!");
	     }
	     Item item = itemsStorage.get(itemIdChoosen);
	     cart.deleteItem(item);
    }
    
    
    
}
