package org.vaadin.inputmask.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;

public class GwtPreValidator extends JavaScriptObject{
	protected GwtPreValidator(){};
	
	public static GwtPreValidator create() {
		return (GwtPreValidator) JavaScriptObject.createObject();
	}

	public final native void setValidator(String validator) /*-{
		this.validator = validator;
	}-*/;

	public final native void setCardinality(int cardinality) /*-{
		this.cardinality = cardinality;
	}-*/;
}
