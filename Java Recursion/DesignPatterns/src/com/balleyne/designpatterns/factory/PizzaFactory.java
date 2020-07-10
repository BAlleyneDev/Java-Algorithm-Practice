package com.balleyne.designpatterns.factory;

public abstract class PizzaFactory {
	   public Pizza orderPizza(String type) {
		   Pizza pizza = createPizza(type);
		   
		   pizza.bake();
		   pizza.cut();
		   pizza.box();
		   
		   return pizza;
	
	   }
	   
       public abstract Pizza createPizza(String type);
}
