package org.vaadin.inputmask.client;

import java.util.List;

public class InputMaskState extends com.vaadin.shared.AbstractComponentState {
	private static final long serialVersionUID = 1236942200200172544L;

	public String alias;
    public String mask;
    public String placeholder;
    public boolean regexMask = false;
    public Boolean showMaskOnFocus;
    public Boolean showMaskOnHover;
    public Boolean jitMasking;
    public Integer repeat;
    public Boolean greedy;
    public Boolean autoUnmask;
    public Boolean clearMaskOnLostFocus;
    public Boolean insertMode;
    public Boolean clearIncomplete;
    public List<Definition> definitions;
    public Boolean numericInput;
    public Boolean rightAlign;
    public Boolean keepStatic;
    public Boolean positionCaretOnTab;
    public Boolean tabThrough;
    public Casing casing;
    public boolean listenComplete = false;
    public boolean listenIncomplete = false;
    
    //Numeric extension
    public String digits;
    public String radixPoint;
    public String groupSeparator;
    public Boolean digitsOptional;
    public Boolean enforceDigitsOnBlur;
    public Integer groupSize;
    public Boolean autoGroup;
    public Boolean allowMinus;
    public String integerDigits;
    public Boolean integerOptional;
    public String prefix;
    public String suffix;
    public Boolean decimalProtect;
    public String min;
    public String max;
    public Integer step;
}