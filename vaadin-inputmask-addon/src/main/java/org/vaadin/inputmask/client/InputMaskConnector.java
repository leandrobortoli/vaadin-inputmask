package org.vaadin.inputmask.client;

import org.vaadin.inputmask.InputMask;
import org.vaadin.inputmask.client.gwt.GwtDefinition;
import org.vaadin.inputmask.client.gwt.GwtInputMaskEventHandler;
import org.vaadin.inputmask.client.gwt.GwtMaskOptions;
import org.vaadin.inputmask.client.gwt.GwtPreValidator;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

// Connector binds client-side widget class to server-side component class
// Connector lives in the client and the @Connect annotation specifies the
// corresponding server-side component
@Connect(InputMask.class)
public class InputMaskConnector extends AbstractExtensionConnector implements GwtInputMaskEventHandler{
	private static final long serialVersionUID = -4809490222987319921L;

	protected InputMaskServerRpc serverRpc = RpcProxy.create(InputMaskServerRpc.class, this);
	
	@Override
	public InputMaskState getState() {
		return (InputMaskState) super.getState();
	}

	@Override
	protected void extend(ServerConnector target) {
		Widget widget = (Widget) ((ComponentConnector) target).getWidget();
		Element input = getInput(widget.getElement());
		if (input == null) {
			throw new IllegalArgumentException("Viable input not found.");
		}
		GwtMaskOptions options = parseOptions();
		addMask(input, options);
	}

	private GwtMaskOptions parseOptions() {
		InputMaskState state = getState();
		GwtMaskOptions options = GwtMaskOptions.create();

		if (state.alias != null)
			options.setAlias(state.alias);
		
		if (state.mask != null) {
			if (!state.regexMask)
				options.setMask(state.mask);
			else
				options.setRegex(state.mask);
		}
		if (state.placeholder != null)
			options.setPlaceholder(state.placeholder);
		if(state.showMaskOnFocus != null)
			options.setShowMaskOnFocus(state.showMaskOnFocus);
		if(state.showMaskOnHover != null)
			options.setShowMaskOnHover(state.showMaskOnHover);
		if(state.jitMasking != null)
			options.setJitMasking(state.jitMasking);
		if (state.repeat != null)
			options.setRepeat(state.repeat);
		if(state.greedy != null)
			options.setGreedy(state.greedy);
		if(state.autoUnmask != null)
			options.setAutoUnmask(state.autoUnmask);
		if(state.clearMaskOnLostFocus != null)
			options.setClearMaskOnLostFocus(state.clearMaskOnLostFocus);
		if(state.insertMode != null)
			options.setInsertMode(state.insertMode);
		if(state.clearIncomplete != null)
			options.setClearIncomplete(state.clearIncomplete);
		if(state.numericInput != null)
			options.setNumericInput(state.numericInput);
		if(state.rightAlign != null)
			options.setRightAlign(state.rightAlign);
		if(state.keepStatic != null)
			options.setKeepStatic(state.keepStatic);
		if(state.positionCaretOnTab != null)
			options.setPositionCaretOnTab(state.positionCaretOnTab);
		if(state.tabThrough != null)
			options.setTabThrough(state.tabThrough);
		if(state.casing != null)
			options.setCasing(state.casing.toString());
		if(state.digits != null)
			options.setDigits(state.digits);
		if(state.radixPoint != null)
			options.setRadixPoint(state.radixPoint);
		if(state.groupSeparator != null)
			options.setGroupSeparator(state.groupSeparator);
		if(state.digitsOptional != null)
			options.setDigitsOptional(state.digitsOptional);
		if(state.enforceDigitsOnBlur != null)
			options.setEnforceDigitsOnBlur(state.enforceDigitsOnBlur);
		if(state.groupSize != null)
			options.setGroupSize(state.groupSize);
		if(state.autoGroup != null)
			options.setAutoGroup(state.autoGroup);
		if(state.allowMinus != null)
			options.setAllowMinus(state.allowMinus);
		if(state.prefix != null)
			options.setPrefix(state.prefix);
		if(state.suffix != null)
			options.setSuffix(state.suffix);
		if(state.decimalProtect != null)
			options.setDecimalProtect(state.decimalProtect);
		if(state.min != null)
			options.setMin(state.min);
		if(state.max != null)
			options.setMax(state.max);
		if(state.step != null)
			options.setStep(state.step);
		
		if(state.definitions != null) {
			for(Definition definition : state.definitions) {
				GwtDefinition gwtDefinition = parseDefinition(definition);
				options.addDefinition(definition.getMaskSymbol(), gwtDefinition);
			}
		}
		
		if(state.listenComplete)
			options.addOnCompleteHandler(this);
		if(state.listenIncomplete)
			options.addOnIncompleteHandler(this);
		
		return options;
	}

	private GwtDefinition parseDefinition(Definition definition) {
		GwtDefinition gwtDefinition = GwtDefinition.create();
		if(definition.getValidator() != null)
			gwtDefinition.setValidator(definition.getValidator());
		if(definition.getDefinitionSymbol() != null)
			gwtDefinition.setDefinitionSymbol(definition.getDefinitionSymbol());
		if(definition.getPlaceholder() != null)
			gwtDefinition.setPlaceholder(definition.getPlaceholder());
		if(definition.getCasing() != null)
			gwtDefinition.setCasing(definition.getCasing().toString());
		gwtDefinition.setCardinality(definition.getCardinality());
		
		if(definition.getPreValidators() != null) {
			for(PreValidator preValidator : definition.getPreValidators()) {
				GwtPreValidator gwtPreValidator = parsePreValidator(preValidator);
				gwtDefinition.addPreValidator(gwtPreValidator);
			}
		}
		return gwtDefinition;
	}
	
	private GwtPreValidator parsePreValidator(PreValidator preValidator) {
		GwtPreValidator gwtPreValidator = GwtPreValidator.create();
		gwtPreValidator.setCardinality(preValidator.getCardinality());
		gwtPreValidator.setValidator(preValidator.getValidator());
		return gwtPreValidator;
	}

	public native Element getInput(Element el)
	/*-{
	  	if(el.tagName.toUpperCase() == 'INPUT' || el.tagName.toUpperCase() == 'TEXTAREA') {
	  		return el;
	  	}
	  	return $wnd.$(el).find("input[type='text'], textarea, input[type='search']")[0];
	 }-*/;

	public native void addMask(Element el, GwtMaskOptions options)
	/*-{
	 	$wnd.Inputmask(options).mask(el);
	}-*/;

	@Override
	public void onComplete() {
		serverRpc.onComplete();
	}

	@Override
	public void onIncomplete() {
		serverRpc.onIncomplete();
	}
}
