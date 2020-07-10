package com.balleyne.designpatterns.converter;

public interface Converter {
	
     public abstract double calculate(double inputVal, String inputMetric, String outputMetric);
}
