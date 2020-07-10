package com.udemy.iterative;

import java.util.Comparator;

public class StringCustomSort implements Comparable<StringCustomSort>{
	
	String text;
	Integer textVal =0;
	
	public StringCustomSort(String text) {
		this.text = text;
		int tempString = 0;
		for(int i=0; i<text.length(); i++) {
			tempString += Character.getNumericValue(text.charAt(i));
		}
		
		this.textVal = tempString;
		
	}

	@Override
	public int compareTo(StringCustomSort s2) {
		return Integer.compare(this.textVal, s2.textVal);
	}



}
