package edu.cs222.fpteachingcalculator.model.converter;

public class ValueGenerator {

	public String generateHexValue() {
		String hexValue = "";
		int hexLength = (int) Math.round(Math.random() * 5) + 3;
		for (int i = 1; i <= hexLength; i++) {
			int randomDecimalNumber = (int) (Math.round(Math.random() * 15));
			String hexEquivalent = Integer.toHexString(randomDecimalNumber);
			hexValue = hexValue + hexEquivalent;
		}
		return hexValue.toUpperCase();
	}

}
