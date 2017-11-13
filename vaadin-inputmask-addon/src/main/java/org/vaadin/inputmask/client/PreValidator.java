package org.vaadin.inputmask.client;

public class PreValidator {
	private String validator;
	private int cardinality = 1;
	
	protected PreValidator(){
	}
	
	public PreValidator(String validator, int cardinality) {
		this.validator = validator;
		this.cardinality = cardinality;
	}

	public String getValidator() {
		return validator;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}

	public int getCardinality() {
		return cardinality;
	}

	public void setCardinality(int cardinality) {
		this.cardinality = cardinality;
	}
}
