package controllers;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.util.*;

import javax.persistence.Query;



public class Orders extends Controller {

	public static void create()
	{
		/*Item i1=(Item) Item.find("id=8").fetch().get(0);
    	Item i2=(Item) Item.find("id=9").fetch().get(0);
    	Item i3=(Item) Item.find("id=10").fetch().get(0);
    	Item i4=(Item) Item.find("id=4").fetch().get(0);
    	Item i5=(Item) Item.find("id=5").fetch().get(0);
    	Order o1=new Order(new Date());
    	new OrderItem(o1,i1,4).save();
    	new OrderItem(o1,i2,5).save();
    	new OrderItem(o1,i3,1).save();
    	new OrderItem(o1,i4,3).save();
    	new OrderItem(o1,i5,1).save();*/
		/*Order o=(Order) Order.find("id=57").fetch().get(0);
		o.updateStatus(new ClosedOrderState());
		o.save();*/
		Menu menu=(Menu) Menu.find("id=18").fetch().get(0);
		if(session.get("cafeorder")==null)
		{
		
       	render(menu);
		}
		else
		{
			Order order=(Order) Order.find("id="+session.get("cafeorder")).fetch().get(0);
			render(menu,order);
		}  		
	}

	  public static void index() {
	        List<Order> orders = Order.findAll();
	        session.remove("cafeorder");
	    	render(orders);	
	    }
    
    public static void view(long id) {
    	Order order = Order.findById(id);
    	render(order);
    }
    
    public static void edit (long id) {
		session.put("cafeorder",id);
		create();
    }
    public static void cancel(Long id) {
        Order order= Order.findById(id);
        order.delete();
        index();
    }
    
    public static void remove(Long id) {
    	//OrderItem oi=(OrderItem) OrderItem.findById(id);
    	 Query query = JPA.em().createQuery("delete from OrderItem where id="+id);
    	 query.executeUpdate();

        //oi.delete();
           create();
    }
    
	public static void additemtoorder()
	{
		boolean itemexist=false;
		if(session.get("cafeorder")==null)
		{
		Order o1=new Order(new Date());
		o1.save();
		session.put("cafeorder",o1.getId());
		Item i1=(Item) Item.find("id="+params.get("iteminfo")).fetch().get(0);
		new OrderItem(o1,i1,Integer.parseInt(params.get("quantity"))).save();
		System.out.println("dsds" +params.get("quantity"));
			
		}
		else
		{
			Order o=(Order) Order.find("id="+session.get("cafeorder")).fetch().get(0);
			Item i1=(Item) Item.find("id="+params.get("iteminfo")).fetch().get(0);
			List<OrderItem> currentlist=o.orderitem;
			for(OrderItem oi:currentlist)
			{
				if(i1.id.equals(oi.item.id))
				{
					//item already existing;
					itemexist=true;
					oi.count=Integer.parseInt(params.get("quantity"));
					oi.save();
					break;
				}
				
			}
			if(!itemexist)
			{
			new OrderItem(o,i1,Integer.parseInt(params.get("quantity"))).save();
			}
			
		}
		create();
	}
}
