package com.balleyne.designpatterns.factory;

public class CheesePizzaFactory extends PizzaFactory{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = new CheesePizza();
		if(type.equalsIgnoreCase("Chicago")) {
			pizza = new ChicagoCheesePizza();
		}
		return pizza;
	}

}
