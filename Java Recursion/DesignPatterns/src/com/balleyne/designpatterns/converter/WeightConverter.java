package com.balleyne.designpatterns.converter;

public class WeightConverter implements Converter {

	@Override
	public double calculate(double inputVal, String inputMetric, String outputMetric) {
		double result = 0.0;
		if(inputMetric.equals("tonnes")) {
			switch(outputMetric) {
			   case "ounces":
				   result = inputVal * 0.0056;
			   break;
			   
			   default:
				   result = inputVal *1;
			}
		}
		
		if(inputMetric.equals("ounces")) {
			
			switch(outputMetric) {
			   case "tonnes":
				   result = inputVal / 0.0056;
			   break;
			   
			   default:
				   result = inputVal *1;
			}
		}
		
		return result;
	}

	

}
