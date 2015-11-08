package edu.cs222.fpteachingcalculator.model.converter.inputexceptions;

public class InvalidHexNumberLengthException extends Exception
{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidHexNumberLengthException(){}

      public InvalidHexNumberLengthException(String message)
      {
         super(message);
      }
 }