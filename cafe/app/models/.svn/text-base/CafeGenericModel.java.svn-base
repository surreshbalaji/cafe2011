package models; 

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

import play.*;
import play.data.binding.*;
import play.mvc.*;
import play.utils.Java;



public class CafeGenericModel extends Model {

    //public String modelName = null;
	
    //public static Model.Factory getFactory() {
    //    return Model.getFactory(modelName);
    //}

    public static Model.Factory getFactory(String modelName) {
        try {
            return Model.Manager.factoryFor( (Class<? extends Model>) Play.classloader.loadClass("models." + modelName));
        } catch (java.lang.ClassNotFoundException e) {
            return null;
        }
    }

    public static List<play.db.Model> fetchAll(String modelName) {
        return getFactory(modelName).fetch(0,100,"id", "desc", null, null, null);
    }

}
