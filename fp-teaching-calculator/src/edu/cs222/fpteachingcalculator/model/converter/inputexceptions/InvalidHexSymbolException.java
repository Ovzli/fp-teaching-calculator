package edu.cs222.fpteachingcalculator.model.converter.inputexceptions;

public class InvalidHexSymbolException extends Exception
{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidHexSymbolException() {}

      public InvalidHexSymbolException(String message)
      {
         super(message);
      }
 }