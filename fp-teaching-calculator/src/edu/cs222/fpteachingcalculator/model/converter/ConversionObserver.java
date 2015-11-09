package edu.cs222.fpteachingcalculator.model.converter;

import java.util.Observable;
import java.util.Observer;

public class ConversionObserver extends Observable{

	public void addObservers(Observer... observers){
		for(Observer observer: observers){
			this.addObserver(observer);
		}
	}
}
