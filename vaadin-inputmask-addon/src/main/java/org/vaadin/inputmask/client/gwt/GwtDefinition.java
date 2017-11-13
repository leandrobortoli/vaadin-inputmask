package org.vaadin.inputmask.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;

public class GwtDefinition extends JavaScriptObject{
	protected GwtDefinition(){};
	
	public static GwtDefinition create() {
		return (GwtDefinition) JavaScriptObject.createObject();
	}

	public final native void setValidator(String validator) /*-{
		this.validator = validator;
	}-*/;
	
	public final native void setDefinitionSymbol(String definitionSymbol) /*-{
		this.definitionSymbol = definitionSymbol;
	}-*/;
	
	public final native void setPlaceholder(String placeholder) /*-{
		this.placeholder = placeholder;
	}-*/;

	public final native void setCasing(String casing) /*-{
		this.casing = casing;
	}-*/;

	public final native void setCardinality(int cardinality) /*-{
		this.cardinality = cardinality;
	}-*/;
	
	public final native void addPreValidator(GwtPreValidator preValidator) /*-{
		if(!this.prevalidator)
			this.prevalidator = new Array();
		this.prevalidator.push(preValidator);
	}-*/;
}
