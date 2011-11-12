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


public class Generic extends Controller {
    public static void index(String modelName) {
        //List<Item> items = Item.findAll();

        // use the controller string to perform lookup to get the correct model. Here Item is hardcoded
        List<Model> objects = CafeGenericModel.getFactory(modelName).fetch(0,100,"id", "desc", null, null, null);
        render(objects, modelName);

	system.out.println("hello");

    }
}
