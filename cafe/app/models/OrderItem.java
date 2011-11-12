package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class OrderItem extends Model {

	public OrderItem(Order order,Item item,int count)
	{
		this.order=order;
		this.item=item;
		this.count=count;
	}

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Order.class)
	@OnDelete(action = OnDeleteAction.CASCADE)    
	public Order order;
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, targetEntity = Item.class)
	    public Item item;
		public int count;
}
