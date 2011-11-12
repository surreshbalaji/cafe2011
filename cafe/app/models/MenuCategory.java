package models; 

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MenuCategory extends CafeGenericModel {

	public MenuCategory(Menu menu,Category category)
	{
		this.Category=category;
		this.Menu=menu;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Category.class)
    public Category Category;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Menu.class)
   public Menu Menu;
   
   @OneToMany(cascade = CascadeType.ALL, targetEntity = MenuCategoryItem.class, mappedBy = "menuCategory")
   public List<MenuCategoryItem> menucategoryitems;
  
}
