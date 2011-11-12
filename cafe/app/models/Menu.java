package models; 

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Menu extends CafeGenericModel {
    
	private Date ActiveStartDate;
    private Date ActiveEndDate;
    private boolean Active;
 
   public Menu(Date sdate,Date edate,boolean active)
   {
	   this.ActiveStartDate=sdate;
	   this.ActiveEndDate=edate;
	   this.Active=active;
   }
    
       public Date getActiveStartDate() {
        return ActiveStartDate;
    }

    public void setActiveStartDate(Date activeStartDate) {
        ActiveStartDate = activeStartDate;
    }

    public Date getActiveEndDate() {
        return ActiveEndDate;
    }

    public void setActiveEndDate(Date activeEndDate) {
        ActiveEndDate = activeEndDate;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
    
    public String display()
    {
    	return ActiveStartDate.toString() + ActiveEndDate.toString();
    }

    @OneToMany(cascade = CascadeType.ALL, targetEntity = MenuCategory.class, mappedBy = "Menu")
    public List<MenuCategory> menucategories;
   
}
    //@OneToMany
   // private List<MenuCategory> menuCategories;
    

