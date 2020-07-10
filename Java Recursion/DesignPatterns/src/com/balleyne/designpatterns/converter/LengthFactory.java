package com.balleyne.designpatterns.converter;

public class LengthFactory extends ConverterFactory {

	@Override
	public Converter createConverter() {
		return new LengthConverter();
	}

}
