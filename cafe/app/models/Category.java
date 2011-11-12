package models; 

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Category extends CafeGenericModel {

    public String name;
  
    
    public Category(String name)
    {
    	this.name=name;
    //	menuCategories=mc;
    }
    public String display()
    {
    	return name;
    }
    @OneToMany(cascade = CascadeType.ALL, targetEntity = MenuCategory.class, mappedBy = "Category")
    public List<Category> categories;
   
}
