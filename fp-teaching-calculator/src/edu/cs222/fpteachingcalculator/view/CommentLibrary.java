package edu.cs222.fpteachingcalculator.view;

import java.util.HashMap;

public class CommentLibrary {
	private final HashMap<String, String> commentMessage = new HashMap<String, String>();

	public CommentLibrary() {
		commentMessage.put("hexDecStep", new String(
				"shows each input symbol must be assigned a "
					+ "representative equivalent for each symbol needing "
					+ "converted. This is done through pre-determined "
					+ "representations of each individual symbol as outlined in the "
					+ "equivalency table shown to the right."));
		commentMessage.put("decExpansionStep", new String(
				"shows how using 2 as base multipler can represent a decimal number "
					+ "in the form of an expanded sum algorithm. The expansions in "
					+ "red represent values of zero in the sum (not needed). The green "
					+ "expansions show values that are used in constructing the base 2 "
					+ "value of the decimal."));
		commentMessage.put("binConcatenationStep", new String(
				"shows how the binary multipliers in the decimal expansions algorithms "
					+ "(of the previous step) are then extracted and combined into "
					+ "expanded binary representation."));
		commentMessage.put("binRepresentationStep", new String(
				"shows the final binary representation rewritten as a binary number."));
	}

	public String readComment(String commentKey) {
		return commentMessage.get(commentKey);
	}

}
