package org.vaadin.inputmask.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;

public class GwtMaskOptions extends JavaScriptObject{
	protected GwtMaskOptions(){};
	
	public static GwtMaskOptions create() {
		return (GwtMaskOptions) JavaScriptObject.createObject();
	}

	public final native void setAlias(String alias) /*-{
		this.alias = alias;
	}-*/;

	public final native void setMask(String mask) /*-{
		this.mask = mask;
	}-*/;
	
	public final native void setRegex(String regex) /*-{
		this.regex = regex;
	}-*/;

	public final native void setPlaceholder(String placeholder) /*-{
		this.placeholder = placeholder;
	}-*/;

	public final native void setShowMaskOnFocus(boolean showMaskOnFocus) /*-{
		this.showMaskOnFocus = showMaskOnFocus;
	}-*/;

	public final native void setShowMaskOnHover(boolean showMaskOnHover) /*-{
		this.showMaskOnHover = showMaskOnHover;
	}-*/;

	public final native void setJitMasking(boolean jitMasking) /*-{
		this.jitMasking = jitMasking;
	}-*/;

	public final native void setRepeat(int repeat) /*-{
		this.repeat = repeat;
	}-*/;
	
	public final native void setGreedy(boolean greedy) /*-{
		this.greedy = greedy;
	}-*/;
	
	public final native void setAutoUnmask(boolean autoUnmask) /*-{
		this.autoUnmask = autoUnmask;
	}-*/;

	public final native void setClearMaskOnLostFocus(boolean clearMaskOnLostFocus) /*-{
		this.clearMaskOnLostFocus = clearMaskOnLostFocus;
	}-*/;

	public final native void setInsertMode(boolean insertMode) /*-{
		this.insertMode = insertMode;
	}-*/;

	public final native void setClearIncomplete(boolean clearIncomplete) /*-{
		this.clearIncomplete = clearIncomplete;
	}-*/;
	
	public final native void addDefinition(String maskSymbol, GwtDefinition definition) /*-{
		if(this.definitions == null)
		 	this.definitions = new Object();
		this.definitions[maskSymbol] = definition;
	}-*/;
	
	public final native void setNumericInput(boolean numericInput) /*-{
		this.numericInput = numericInput;
	}-*/;

	public final native void setRightAlign(boolean rightAlign) /*-{
		this.rightAlign = rightAlign;
	}-*/;

	public final native void setKeepStatic(boolean keepStatic) /*-{
		this.keepStatic = keepStatic;
	}-*/;

	public final native void setPositionCaretOnTab(boolean positionCaretOnTab) /*-{
		this.positionCaretOnTab = positionCaretOnTab;
	}-*/;

	public final native void setTabThrough(boolean tabThrough) /*-{
		this.tabThrough = tabThrough;
	}-*/;

	public final native void setCasing(String casing) /*-{
		this.casing = casing;
	}-*/;

	public final native void setDigits(String digits) /*-{
		this.digits = digits;
	}-*/;

	public final native void setRadixPoint(String radixPoint) /*-{
		this.radixPoint = radixPoint;
	}-*/;

	public final native void setGroupSeparator(String groupSeparator) /*-{
		this.groupSeparator = groupSeparator;
	}-*/;
	
	public final native void setDigitsOptional(boolean digitsOptional) /*-{
		this.digitsOptional = digitsOptional;
	}-*/;

	public final native void setEnforceDigitsOnBlur(boolean enforceDigitsOnBlur) /*-{
		this.enforceDigitsOnBlur = enforceDigitsOnBlur;
	}-*/;
	
	public final native void setGroupSize(Integer groupSize) /*-{
		this.groupSize = groupSize;
	}-*/;

	public final native void setAutoGroup(boolean autoGroup) /*-{
		this.autoGroup = autoGroup;
	}-*/;

	public final native void setAllowMinus(boolean allowMinus) /*-{
		this.allowMinus = allowMinus;
	}-*/;

	public final native void setPrefix(String prefix) /*-{
		this.prefix = prefix;
	}-*/;

	public final native void setSuffix(String suffix) /*-{
		this.suffix = suffix;
	}-*/;

	public final native void setDecimalProtect(boolean decimalProtect) /*-{
		this.decimalProtect = decimalProtect;
	}-*/;

	public final native void setMin(String min) /*-{
		this.min = min;
	}-*/;

	public final native void setMax(String max) /*-{
		this.max = max;
	}-*/;

	public final native void setStep(Integer step) /*-{
		this.step = step;
	}-*/;
	
	public final native void addOnCompleteHandler(GwtInputMaskEventHandler handler) /*-{
		this.oncomplete = function() {handler.@org.vaadin.inputmask.client.gwt.GwtInputMaskEventHandler::onComplete()();};
	}-*/;
	
	public final native void addOnIncompleteHandler(GwtInputMaskEventHandler handler) /*-{
		this.onincomplete = function() {handler.@org.vaadin.inputmask.client.gwt.GwtInputMaskEventHandler::onIncomplete()();};
	}-*/;
}
