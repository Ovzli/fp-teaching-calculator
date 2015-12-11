package edu.cs222.fpteachingcalculator.model.converter;

public class ValueGenerator {
	private int valueLength;

	public String generateHexValue() {
		valueLength = setRandomLength() + 4;
		return generateRandomValueString("HEX");
	}

	public String generateDecValue() {
		valueLength = setRandomLength() + 2;
		return generateRandomValueString("DEC");
	}

	public String generateBinValue() {
		valueLength = (setRandomLength() + 2) * 4;
		return generateRandomValueString("BIN");
	}

	private int setRandomLength() {
		return (int) Math.round(Math.random() * 4);
	}

	private String generateRandomValueString(String valueType) {
		int digitRange = 1;
		int iInitial = 2;
		String valueGenerated = "";
		if (valueType.equals("HEX")) {
			digitRange = 15;
		} else if (valueType.equals("DEC")) {
			digitRange = 9;
		}

		if (valueType.equals("BIN")) {
			iInitial = 1;
		} else {
			valueGenerated = Long.toHexString(1 + (Math.round(Math.random()
					* (digitRange - 1))));
		}
		for (int i = iInitial; i <= valueLength; i++) {
			valueGenerated = valueGenerated
					+ Long.toHexString((Math.round(Math.random() * digitRange)));
		}
		return valueGenerated.toUpperCase();
	}

}
