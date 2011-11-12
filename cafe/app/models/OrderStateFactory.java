package models;

public abstract class OrderStateFactory {
	public static OrderState getState(int key) 
	{
	  		if (key == 2) {
	      		return new ClosedOrderState();
	  		} 
	  		if (key == 1) {
	      		return new OpenOrderState();
	  		} 
	  		if (key == 3) {
	      		return new PaidOrderState();
	  		} 
	return new OpenOrderState();
	}
}
