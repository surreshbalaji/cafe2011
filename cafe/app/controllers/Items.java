package controllers;

import java.util.*;
import java.lang.reflect.*;
import java.lang.annotation.*;

import play.*;
import play.data.binding.*;
import play.mvc.*;
import play.utils.Java;
import play.db.Model;
import play.data.validation.*;
import play.exceptions.*;
import play.i18n.*;

import play.data.validation.*;

import models.*;


public class Items extends Controller {

    
	public static void index() {
    	
        List<Item> items = Item.findAll();

        //List<Model> items = CafeGenericModel.getFactory("Item").fetch(0,100,"id", "desc", null, null, null);

        render(items);
    }

    public static void create()
    {
    	//RUN THE BELOW CODE ONLY ONCE FOR CREATING ITEMS,CATEGORY,MENU
    	Item item=new Item("dish1",10.00,"this is dish16").save();    	
    	Item item1=new Item("dish2",10.00,"this is dish16").save();  
    	Item item2=new Item("dish3",10.00,"this is dish16").save();  
    	Item item3=new Item("dish4",10.00,"this is dish16").save();
    	Item item4=new Item("dish5",10.00,"this is dish16").save();
    	Item item5=new Item("dish6",10.00,"this is dish16").save();
    	Item item6=new Item("dish7",10.00,"this is dish16").save();
    	Item item7=new Item("dish8",10.00,"this is dish16").save();
    	Item item8=new Item("dish9",10.00,"this is dish16").save();
    	Item item9=new Item("dish10",10.00,"this is dish16").save();
    	Item item10=new Item("dish11",10.00,"this is dish16").save();
    	Item item11=new Item("dish12",10.00,"this is dish16").save();
    	
    	//render(item);
    	Category c1=new Category("cat1").save();
    	Category c2=new Category("cat2").save();
    	Category c3=new Category("cat3").save();
    	Category c4=new Category("cat4").save();
    	Category c5=new Category("cat5").save();
    	
    	Menu m1=new Menu(new Date(11,12,9),new Date(11,12,15),true).save();
    	Menu m2=new Menu(new Date(11,12,9),new Date(11,12,15),true).save();
    	Menu m3=new Menu(new Date(11,12,9),new Date(11,12,15),true).save();
    	Menu m4=new Menu(new Date(11,12,12),new Date(11,12,15),true).save();
    	Menu m5=new Menu(new Date(11,12,9),new Date(11,12,15),true).save();
   	
    	
    	render(m4);
    }
    
    public static void edit(Long id, Item item) {
        if (id == null) { // Adding new item.
            id = 0L; 
        }

        
        if(item.id == null) {
            if (id != 0L) {
                item = Item.findById(id);
            }
            
            if (item == null) {
                item = new Item();
            } 
                       
            render(item);
             
        } else {

            if ( validation.hasErrors() ) {
                render(item);
            } else {
                item.save();
                index();
           }
        }
    }

}
