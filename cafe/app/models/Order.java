package models;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import models.*;

import play.db.jpa.*;

@Entity
@Table(name="Cafe_Order")
public class Order extends CafeGenericModel {
 
	public int key;

	public Date date;
	public double total;
	public Order(Date date)
	{
		this.key=1;
		this.date=date;
		this.total=0;
	}
	@OneToMany(targetEntity = OrderItem.class, mappedBy = "order")
	@OnDelete(action = OnDeleteAction.CASCADE)  
	public List <OrderItem>  orderitem;
 
	public OrderState getOrderStatus()
	{
	  return OrderStateFactory.getState(key);	
	}
	
	public void updateStatus(OrderState os)
	{
	  this.key=os.key;	
	}
}
