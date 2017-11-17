package org.vaadin.inputmask;

import java.io.Serializable;
import java.util.ArrayList;

import org.vaadin.inputmask.client.Alias;
import org.vaadin.inputmask.client.Casing;
import org.vaadin.inputmask.client.Definition;
import org.vaadin.inputmask.client.InputMaskServerRpc;
import org.vaadin.inputmask.client.InputMaskState;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.AbstractComponent;

/**
 * Vaadin wrapper for the JavaScript Plugin InputMask (https://github.com/RobinHerbots/Inputmask)<br>
 *
 * @author Leandro José de bortoli (leandrojbortoli@gmail.com)
 */
@JavaScript({"client/js/jquery.js", "client/js/inputmask.dependencyLib.min.js", "client/js/inputmask.min.js", 
	"client/js/inputmask.extensions.min.js", "client/js/inputmask.numeric.extensions.min.js", "client/js/inputmask.date.extensions.min.js"})
public class InputMask extends AbstractExtension {
	private static final long serialVersionUID = -8054139927566326662L;
	
	private InputMaskServerRpc rpc = new InputMaskServerRpc() {
		private static final long serialVersionUID = 1L;

		@Override
		public void onIncomplete() {
			for(OnIncompleteListener listener : onIncompleteListeners) {
				listener.onIncomplete();
			}
		}
		
		@Override
		public void onComplete() {
			for(OnCompleteListener listener : onCompleteListeners) {
				listener.onComplete();
			}
		}
	};
	
	public interface OnCompleteListener extends Serializable {
		public void onComplete();
	}
	ArrayList<OnCompleteListener> onCompleteListeners = new ArrayList<>();
	
	public interface OnIncompleteListener extends Serializable {
		public void onIncomplete();
	}
	ArrayList<OnIncompleteListener> onIncompleteListeners = new ArrayList<>();
	
	public InputMask(String mask) {
		getState().mask = mask;
		registerRpc(rpc);
	}

	public InputMask(Alias alias) {
		getState().alias = alias.toString();
		registerRpc(rpc);
	}
	
	public void extend(AbstractComponent field) {
		extend((AbstractClientConnector) field);
	}
	
	public static void addTo(AbstractComponent field, String mask) {
        new InputMask(mask).extend((AbstractClientConnector) field);
    }

	public static void addTo(AbstractComponent field, Alias alias) {
		new InputMask(alias).extend((AbstractClientConnector) field);
	}
	
	@Override
	protected InputMaskState getState() {
		return (InputMaskState) super.getState();
	}

	@Override
	protected InputMaskState getState(boolean markAsDirty) {
		return (InputMaskState) super.getState(markAsDirty);
	}
	
	public void addOnCompleteListener(OnCompleteListener listener) {
		onCompleteListeners.add(listener);
		getState().listenComplete = true;
	}
	
	public void addOnIncompleteListener(OnIncompleteListener listener) {
		onIncompleteListeners.add(listener);
		getState().listenIncomplete = true;
	}
	
	public void setAlias(Alias alias) {
		if(alias != null)
			getState().alias = alias.toString();
		else 
			getState().alias = null;
	}

	public void setAlias(String alias) {
		getState().alias = alias;
	}
	
	public void setMask(String mask) {
		getState().mask = mask;
	}
	/**
	 * Toggle mask as a regular expression
	 * @param regexMask Mask as a regular expression
	 */
	public void setRegexMask(boolean regexMask) {
		getState().regexMask = regexMask;
	}
	/**
	 * Change the mask placeholder. Default: "_"
	 * Instead of "_", you can change the unfilled characters mask as you like, simply by adding the placeholder option.
	 * For example, placeholder: " " will change the default autofill with empty values
	 * @param placeholder The placeholder
	 */
	public void setPlaceholder(String placeholder) {
		getState().placeholder = placeholder;
	}
	/**
	 * Shows the mask when the input gets focus. (default = true)
	 * @param showMaskOnFocus Toggle show mask on focus.
	 */
	public void setShowMaskOnFocus(boolean showMaskOnFocus) {
		getState().showMaskOnFocus = showMaskOnFocus;
	}
	/**
	 * Shows the mask when hovering the mouse. (default = true)
	 * @param showMaskOnHover Toggle show mask on hover.
	 */
	public void setShowMaskOnHover(boolean showMaskOnHover) {
		getState().showMaskOnHover = showMaskOnHover;
	}
	/**
	 * Just in time masking. With the jitMasking option you can enable jit masking. The mask will only be visible for the user entered characters. Default: false
	 * @param jitMasking Toggle Jist in time masking.
	 */
	public void setJitMasking(boolean jitMasking) {
		getState().jitMasking = jitMasking;
	}
	/**
	 * Mask repeat function. Repeat the mask definition x-times.
	 * @param repeat Number of repeats.
	 */
	public void setRepeat(int repeat) {
		getState().repeat = repeat;
	}
	/**
	 * Toggle to allocate as much possible or the opposite.
	 * @param greedy Toggle greedy mask.
	 */
	public void setGreedy(boolean greedy) {
		getState().greedy = greedy;
	}
	/**
	 * Automatically unmask the value when retrieved.
	 * Default: false.
	 * When setting this option to true the plugin also expects the initial value from the server to be unmasked.
	 * @param autoUnmask Toggle autounmask.
	 */
	public void setAutoUnmask(boolean autoUnmask) {
		getState().autoUnmask = autoUnmask;
	}
	/**
	 * Remove the empty mask on blur or when not empty removes the optional trailing part Default: true
	 * @param clearMaskOnLostFocus Toggle clear mask on lost focus.
	 */
	public void setClearMaskOnLostFocus(boolean clearMaskOnLostFocus) {
		getState().clearMaskOnLostFocus = clearMaskOnLostFocus;
	}
	/**
	 * Toggle to insert or overwrite input.
	 * Default: true.
	 * This option can be altered by pressing the Insert key.
	 * @param insertMode Toggle insert mode.
	 */
	public void setInsertMode(boolean insertMode) {
		getState().insertMode = insertMode;
	}
	/**
	 * Clear the incomplete input on blur
	 * @param clearIncomplete Toggle clearIncomplete.
	 */
	public void setClearIncomplete(boolean clearIncomplete) {
		getState().clearIncomplete = clearIncomplete;
	}
	
	public void addDefinition(Definition definition) {
		if(getState().definitions == null)
			getState().definitions = new ArrayList<>();
		getState().definitions.add(definition);
	}
	
	public void clearDefinitions() {
		getState().definitions = null;
	}
	/**
	 * Numeric input direction. Keeps the caret at the end.
	 * @param numericInput Toggle numeric input.
	 */
	public void setNumericInput(boolean numericInput) {
		getState().numericInput = numericInput;
	}
	/**
	 * Align the input to the right
	 * By setting the rightAlign you can specify to right align an inputmask. This is only applied in combination op the numericInput option or the dir-attribute. Default is true
	 * @param rightAlign Toggle rightAlign.
	 */
	public void setRightAlign(boolean rightAlign) {
		getState().rightAlign = rightAlign;
	}
	/**
	 * Default: null (~false) Use in combination with the alternator syntax Try to keep the mask static while typing. Decisions to alter the mask will be postponed if possible.
	 * When passing multiple masks (an array of masks) keepStatic is automatically set to true unless explicitly set through the options.
	 * @param keepStatic Toggle keepStatic.
	 */
	public void setKeepStatic(boolean keepStatic) {
		getState().keepStatic = keepStatic;
	}
	/**
	 * When enabled the caret position is set after the latest valid position on TAB Default: true
	 * @param positionCaretOnTab Toggle positionCaretOnTab.
	 */
	public void setPositionCaretOnTab(boolean positionCaretOnTab) {
		getState().positionCaretOnTab = positionCaretOnTab;
	}
	/**
	 * Allows for tabbing through the different parts of the masked field.
	 * Default: false
	 * @param tabThrough Toggle TabThrough.
	 */
	public void setTabThrough(boolean tabThrough) {
		getState().tabThrough = tabThrough;
	}
	/**
	 * Apply casing at the mask-level. Options: null, "upper", "lower" or "title"
	 * @param casing The Casing of the mask.
	 */
	public void setCasing(Casing casing) {
		getState().casing = casing;
	}
	/**
	 * Number of fractionalDigits Default: "*"
	 * The value can be a number, *, or a quantifier syntax like 2,4 When the quantifier syntax is used, the digitsOptional option is ignored
	 * @param digits Number of fractional Digits.
	 */
	public void setDigits(String digits) {
		getState().digits = digits;
	}
	/**
	 * Define the radixpoint (decimal separator)
	 * Default: ""
	 * @param radixPoint Radix Point.
	 */
	public void setRadixPoint(String radixPoint) {
		getState().radixPoint = radixPoint;
	}
	/**
	 * Define the groupseparator
	 * Default: ""
	 * @param groupSeparator Group Separator.
	 */
	public void setGroupSeparator(String groupSeparator) {
		getState().groupSeparator = groupSeparator;
	}
	/**
	 * Specify wheter the digits are optional. Default: true
	 * @param digitsOptional Toggle optional digits.
	 */
	public void setDigitsOptional(boolean digitsOptional) {
		getState().digitsOptional = digitsOptional;
	}
	/**
	 * Enforces the decimal part when leaving the input field
	 * @param enforceDigitsOnBlur Toggle Enforce Digits on Blur.
	 */
	public void setEnforceDigitsOnBlur(boolean enforceDigitsOnBlur) {
		getState().enforceDigitsOnBlur = enforceDigitsOnBlur;
	}
	/**
	 * Define the grouping of the integer part. Default: 3
	 * @param groupSize Grouping of the integer part.
	 */
	public void setGroupSize(Integer groupSize) {
		getState().groupSize = groupSize;
	}
	/**
	 * Enable grouping of the integer part. Default: false
	 * @param autoGroup Toggle auto grouping.
	 */
	public void setAutoGroup(boolean autoGroup) {
		getState().autoGroup = autoGroup;
	}
	/**
	 * Allow to enter -. Default: true
	 * @param allowMinus Allow minus.
	 */
	public void setAllowMinus(boolean allowMinus) {
		getState().allowMinus = allowMinus;
	}
	public void setIntegerDigits(String integerDigits) {
		getState().integerDigits = integerDigits;
	}
	public void setIntegerOptional(boolean integerOptional) {
		getState().integerOptional = integerOptional;
	}
	/**
	 * Define a prefix. Default: ""
	 * @param prefix Prefix.
	 */
	public void setPrefix(String prefix) {
		getState().prefix = prefix;
	}
	/**
	 * Define a suffix. Default: ""
	 * @param suffix Suffix.
	 */
	public void setSuffix(String suffix) {
		getState().suffix = suffix;
	}
	/**
	 * Do not allow assumption of decimals input without entering the radixpoint. Default: true
	 * @param decimalProtect Toggle decimalProtect.
	 */
	public void setDecimalProtect(boolean decimalProtect) {
		getState().decimalProtect = decimalProtect;
	}
	/**
	 * Minimum value Default: undefined
	 * @param min Minimum value.
	 */
	public void setMin(String min) {
		getState().min = min;
	}
	/**
	 * Maximum value Default: undefined
	 * @param max Maximum value.
	 */
	public void setMax(String max) {
		getState().max = max;
	}
	/**
	 * Define the step the ctrl-up ctrl-down must take. Default: 1
	 * @param step Step.
	 */
	public void setStep(Integer step) {
		getState().step = step;
	}
}
