package models; 

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class MenuCategoryItem extends CafeGenericModel {
	
	public MenuCategoryItem(MenuCategory mcategory,Item item)
	{
		this.menuCategory=mcategory;
		this.item=item;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = MenuCategory.class)
	    public MenuCategory menuCategory;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Item.class)

	    public Item item;
}
