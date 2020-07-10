package com.balleyne.designpatterns.converter;

public class ConverterRunner {

	public static void main(String[] args) {
		
		ConverterFactory converter = new WeightConverterFactory();
		double result = converter.calculate(5.87, "tonnes", "ounces");
		System.out.println("Weight: "+result);
		
		ConverterFactory converter2 = new LengthFactory();
		double result2 = converter2.calculate(5.87, "m", "cm");
		System.out.println("Length: "+result2);
	}

}
