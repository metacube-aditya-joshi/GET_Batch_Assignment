package SoftwareConstructionFundamentals;

import java.util.*;

public class ShoppingCart {
	private HashMap<Item,Integer> cartItems;
	
	public ShoppingCart() {
		cartItems = new HashMap<>();
	}
	
	public void addToCart(Item item ,int quantity)
	{
		if(quantity<=0)
		{
			System.out.println("Quantity must be greater than zero!!");
			
		}
		
		cartItems.put(item, cartItems.getOrDefault(item, 0)+quantity);
		System.out.println(quantity+" "+item.Name+" added into the cart !!");
	}
	public int displayQty(Item item) {
		if(!cartItems.containsKey(item)) {
			System.out.println(item.Name+" is not present in the cart");
			return 0;
		}
		return cartItems.get(item);
	}
    public void updateQty(Item item , int quantity) {
    	if(!cartItems.containsKey(item))
    	{
    		System.out.println(item.Name+" is not present in the cart !!");
    		return ;
    	}
    	if(quantity<=0) {
    		System.out.println("Quantity must be greater than zero!!");
    		return ;
    	}
    	cartItems.put(item, quantity);
    	System.out.println("Quabtity Updated by :"+quantity);
    	return;
    }
    public void deleteItem(Item item) {
    	if(!cartItems.containsKey(item))
    	{
    		System.out.println(item.Name+" is not present in the cart !!");
    		return ;
    	}
    	cartItems.remove(item);
    	System.out.println("Item removed from the cart successfully !!");
    	
    }
    public double displayBill() {
    	double total =0;
    	for(Map.Entry<Item, Integer> entry :cartItems.entrySet()) {
    		total+=entry.getKey().Price*entry.getValue();
    	}
    	System.out.println("Total Bill amount is :" +total);
    	return total;
    }
}

