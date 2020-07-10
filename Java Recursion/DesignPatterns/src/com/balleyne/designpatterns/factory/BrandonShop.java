package com.balleyne.designpatterns.factory;

public class BrandonShop {

	public static void main(String[] args) {
	    PizzaFactory pizzamaker = new CheesePizzaFactory();
	    pizzamaker.orderPizza("Chicago");

	}

}
