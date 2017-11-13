package org.vaadin.inputmask.client;

import java.util.ArrayList;
import java.util.List;

public class Definition {
	private String maskSymbol;
	private String validator;
	private String placeholder;
	private int cardinality = 1;
	private String definitionSymbol;
	private Casing casing;
	private List<PreValidator> preValidators;
	
	protected Definition(){
	}
	
	public Definition(String maskSymbol, String validator) {
		this.maskSymbol = maskSymbol;
		this.validator = validator;
	}

	public String getMaskSymbol() {
		return maskSymbol;
	}

	public void setMaskSymbol(String maskSymbol) {
		this.maskSymbol = maskSymbol;
	}

	public String getValidator() {
		return validator;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public int getCardinality() {
		return cardinality;
	}

	/**
	* Cardinality specifies how many characters are represented and validated for the definition.
	* @param cardinality number of characters represented for the definition.
	*/
	public void setCardinality(int cardinality) {
		this.cardinality = cardinality;
	}

	public String getDefinitionSymbol() {
		return definitionSymbol;
	}

	public void setDefinitionSymbol(String definitionSymbol) {
		this.definitionSymbol = definitionSymbol;
	}

	public Casing getCasing() {
		return casing;
	}

	public void setCasing(Casing casing) {
		this.casing = casing;
	}

	public void clearPreValidators() {
		this.preValidators = null;
	}

	public void addPreValidator(PreValidator preValidator) {
		if(this.preValidators == null)
			this.preValidators = new ArrayList<>();
		this.preValidators.add(preValidator);
	}

	public List<PreValidator> getPreValidators() {
		return preValidators;
	}

	public void setPreValidators(List<PreValidator> preValidators) {
		this.preValidators = preValidators;
	}
}
