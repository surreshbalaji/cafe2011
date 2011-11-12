package models; 

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Item extends CafeGenericModel {
	
    public String name;
    public double price;

	
	public String description;
	

	public Item() {
	}

	public Item(String name, double price, String description) {
	    this.name = name;
	    this.description = description;
	    this.price = price;
	}

    public String display() {
        return "id: " + id + "  name: " + name + " - " + description;
    }
    @OneToMany(cascade = CascadeType.ALL, targetEntity = MenuCategoryItem.class, mappedBy = "item")
    public List<MenuCategoryItem> menucategoriesitems;
   
    @OneToMany(cascade = CascadeType.ALL, targetEntity = OrderItem.class, mappedBy = "item")
    public List<OrderItem> orderitem;
    
   /* @OneToMany
    private List<MenuCategory> menuCategories;
    
    
    @OneToMany
    private List<MenuCategory> menuCategoryItems;  
*/
}
