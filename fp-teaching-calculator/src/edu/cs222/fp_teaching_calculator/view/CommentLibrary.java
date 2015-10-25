package edu.cs222.fp_teaching_calculator.view;

public class CommentLibrary {
	private final String[] commentMessage = {
			" ",
			"shows each input symbol must be assigned a "
					+ "representative equivalent for each symbol needing "
					+ "converted. This is done through pre-determined "
					+ "representations of each individual symbol as outlined in the "
					+ "equivalency table shown to the right.",
			"shows how using 2 as base multipler can represent a decimal number "
					+ "in the form of an expanded sum algorithm. The expansions in "
					+ "red represent values of zero in the sum (not needed). The green "
					+ "expansions show values that are used in constructing the base 2 "
					+ "value of the decimal.",
			"shows how the binary multipliers in the decimal expansions algorithms "
					+ "(of the previous step) are then extracted and combined into "
					+ "expanded binary representation.",
			"shows the final binary representation rewritten as a binary number."
	};

	public String readComment(int commentID) {
		return commentMessage[commentID];
	}

}
