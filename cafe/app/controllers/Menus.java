package controllers;

import java.util.*;
import java.lang.reflect.*;
import java.lang.annotation.*;

import javax.persistence.Query;

import play.*;
import play.data.binding.*;
import play.mvc.*;
import play.utils.Java;
import play.db.Model;
import play.db.jpa.JPA;
import play.data.validation.*;
import play.exceptions.*;
import play.i18n.*;

import play.data.validation.*;

import models.*;


public class Menus extends Controller {



    public static void index() {
        
    }

    public static void create()
    {
    	
    	/*List<Item> item=Item.all().from(1).fetch(2);
    	List<Item> item1=Item.all().from(3).fetch(2);
    	List<Item> item2=Item.all().from(5).fetch(2);
    	List<Item> item3=Item.all().from(7).fetch(2);
    	List<Item> item4=Item.all().from(9).fetch(2);
    	new MenuCategoryItem(item).save();
    	new MenuCategoryItem(item1).save();
    	new MenuCategoryItem(item2).save();
    	new MenuCategoryItem(item3).save();
    	new MenuCategoryItem(item4).save();*/
    	//List<MenuCategoryItem> mc1=MenuCategoryItem.find("id < 13").fetch();
    	//List<MenuCategoryItem> mc2=MenuCategoryItem.find("id > 13 and id < 15").fetch();
    	//List<MenuCategoryItem> mc3=MenuCategoryItem.find("id =15").fetch();
    	
    	//new MenuCategory(mc1).save();
    	//new MenuCategory(mc2).save();
    	//new MenuCategory(mc3).save();
    	/*List<Menu> m=Menu.find("id=150").fetch();
    	List<Category> c1=Category.find("id=145").fetch();
    	List<Category> c2=Category.find("id=146").fetch();
    	List<Category> c3=Category.find("id=147").fetch();
    	List<Category> c4=Category.find("id=148").fetch();
    	List<Category> c5=Category.find("id=149").fetch();
    	new MenuCategory(c1, m).save();
    	new MenuCategory(c2, m).save();
    	new MenuCategory(c3, m).save();
    	new MenuCategory(c4, m).save();
    	new MenuCategory(c5, m).save();*/
    	/*List<MenuCategory> mc=MenuCategory.find("id=172").fetch();
    	List<Item> i1=Item.find("id=142").fetch();
    	List<Item> i2=Item.find("id=143").fetch();
    	List<Item> i3=Item.find("id=144").fetch();
    	new MenuCategoryItem(mc,i1).save();
    	new MenuCategoryItem(mc,i2).save();
    	new MenuCategoryItem(mc,i3).save();*/
    	
    	
    	//RUN THE BELOW CODE TO  INSERT INTO MENUCATEGORY AND MENUCATEGORYITEM
    	
     	Category c1=(Category) Category.find("id=13").fetch().get(0);
    	Category c2=(Category) Category.find("id=14").fetch().get(0);
    	Category c3=(Category) Category.find("id=15").fetch().get(0);
    	Category c4=(Category) Category.find("id=16").fetch().get(0);
    	Category c5=(Category) Category.find("id=17").fetch().get(0);
    	Menu m1=(Menu) Menu.find("id=18").fetch().get(0);
    	new MenuCategory(m1,c1).save();
    	new MenuCategory(m1,c2).save();
    	new MenuCategory(m1,c3).save();
    	new MenuCategory(m1,c4).save();
    	new MenuCategory(m1,c5).save();
    	MenuCategory mc1=(MenuCategory) MenuCategory.find("id=23").fetch().get(0);
    	MenuCategory mc2=(MenuCategory) MenuCategory.find("id=24").fetch().get(0);
    	MenuCategory mc3=(MenuCategory) MenuCategory.find("id=25").fetch().get(0);
    	MenuCategory mc4=(MenuCategory) MenuCategory.find("id=26").fetch().get(0);
    	MenuCategory mc5=(MenuCategory) MenuCategory.find("id=27").fetch().get(0);
    	Item i1=(Item) Item.find("id=1").fetch().get(0);
    	Item i2=(Item) Item.find("id=2").fetch().get(0);
    	Item i3=(Item) Item.find("id=3").fetch().get(0);
    	Item i4=(Item) Item.find("id=4").fetch().get(0);
    	Item i5=(Item) Item.find("id=5").fetch().get(0);
    	Item i6=(Item) Item.find("id=6").fetch().get(0);
    	Item i7=(Item) Item.find("id=7").fetch().get(0);
    	Item i8=(Item) Item.find("id=8").fetch().get(0);
    	Item i9=(Item) Item.find("id=9").fetch().get(0);
    	Item i10=(Item) Item.find("id=10").fetch().get(0);
    	Item i11=(Item) Item.find("id=11").fetch().get(0);
    	Item i12=(Item) Item.find("id=12").fetch().get(0);
    	new MenuCategoryItem(mc1,i1).save();
    	new MenuCategoryItem(mc1,i2).save();
    	new MenuCategoryItem(mc2,i3).save();
    	new MenuCategoryItem(mc2,i4).save();
    	new MenuCategoryItem(mc3,i5).save();
    	new MenuCategoryItem(mc3,i6).save();
    	new MenuCategoryItem(mc3,i7).save();
    	new MenuCategoryItem(mc4,i8).save();
    	new MenuCategoryItem(mc4,i9).save();
    	new MenuCategoryItem(mc5,i10).save();
    	new MenuCategoryItem(mc5,i11).save();
    	new MenuCategoryItem(mc5,i12).save();
    	
    	//COMMENT THE ABOVE CODE ONCE INSERT IS DONE 
    	render();
    	
    	
     
        
    }
    public static void view()
    {
    	//DISPLAY A DAILY MENU
    	Menu menu=(Menu) Menu.find("id=18").fetch().get(0);
       	/*for(MenuCategory  mcat:m1.menucategories)
    		System.out.println(mcat.Category.name);*/
    	render(menu);
    	
    }
    public static void edit(Long id, Menu menu) {
        if (id == null) { // Adding new menu.
            id = 0L; 
        }
        
        List<Item> items = Item.findAll();
        List<Category> categories = Category.findAll();

        
        if(menu.id == null) {
            if (id != 0L) {
                menu = Menu.findById(id);
            }
            
            if (menu == null) {
               // menu = new Menu();
            } 
                       
            render(menu, items, categories);
             
        } else {

            if ( validation.hasErrors() ) {
                render(menu, items, categories);
            } else {
                menu.save();
                index();
           }
        }
    }

}
