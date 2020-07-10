package com.balleyne.designpatterns.converter;

public class WeightConverterFactory extends ConverterFactory{

	@Override
	public Converter createConverter() {
		return new WeightConverter();
	}

}
