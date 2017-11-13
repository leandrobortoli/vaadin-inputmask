package org.vaadin.inputmask.client;

public enum Casing{
	UPPER("upper"), 
	LOWER("lower"), 
	TITLE("title");
	
	private String stringValue;
	
	Casing(String stringValue) {
		this.stringValue = stringValue;
	}
	
	@Override
	public String toString() {
		return stringValue;
	}
}