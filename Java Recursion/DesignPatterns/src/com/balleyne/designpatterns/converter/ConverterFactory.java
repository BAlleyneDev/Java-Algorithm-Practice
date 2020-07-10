package com.balleyne.designpatterns.converter;

public abstract class ConverterFactory {
	public double calculate(double val, String inputType, String outputType) {
		   Converter converter = createConverter();
		   return converter.calculate(val, inputType, outputType);	   
	}
    public abstract Converter createConverter();
}
