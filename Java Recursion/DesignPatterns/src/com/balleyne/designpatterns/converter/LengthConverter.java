package com.balleyne.designpatterns.converter;

public class LengthConverter implements Converter {

	@Override
	public double calculate(double inputVal, String inputMetric, String outputMetric) {
		double result = 0.0;
		if(inputMetric.equalsIgnoreCase("cm")) {
			switch(outputMetric) {
			    case "m":
			    	result = inputVal *100;
			    break;
			    
			    default:
			    	result = result*1;
			}
		}
		
		if(inputMetric.equalsIgnoreCase("m")) {
			switch(outputMetric) {
			    case "cm":
			    	result = inputVal /100;
			    break;
			    
			    default:
			    	result = result*1;
			}
		}
		
		return result;
	}

}
