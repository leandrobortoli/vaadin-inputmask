package org.vaadin.inputmask.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.inputmask.InputMask;
import org.vaadin.inputmask.client.Alias;
import org.vaadin.inputmask.client.Casing;
import org.vaadin.inputmask.client.Definition;
import org.vaadin.inputmask.client.PreValidator;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("InputMask Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
    	this.setStyleName("demoContentLayout");
    	
        // Show it in the middle of the screen
    	final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(false);
        layout.setSpacing(false);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        final HorizontalLayout container = new HorizontalLayout();

        final FormLayout column1 = new FormLayout();
        column1.setWidth(500, Unit.PIXELS);
        final FormLayout column2 = new FormLayout();
        column2.setWidth(500, Unit.PIXELS);
      
        container.addComponents(column1, column2);
        layout.addComponent(container);
        
        /*
         * Date
         */
        DateField dateField = new DateField("Date:");
        dateField.setDateFormat("MM/dd/yyyy");
        InputMask.addTo(dateField, "99/99/9999");
        column1.addComponent(dateField);

        /*
         * Time
         */
        TextField timeTextField = new TextField("Time:");
        InputMask.addTo(timeTextField, "99:99:99");
        column1.addComponent(timeTextField);
        
        /*
         * Placeholder
         */
        TextField examplePlaceholderTextField = new TextField("Placeholder:");
        InputMask examplePlaceholderInputMask = new InputMask("99:99:99");
        examplePlaceholderInputMask.setPlaceholder("*");
        examplePlaceholderInputMask.extend(examplePlaceholderTextField);
        column1.addComponent(examplePlaceholderTextField);
      
        /*
         * Regex mask
         */
        TextField regexMaskTextField = new TextField("Regex mask:");
        InputMask regexInputMask = new InputMask("\\d*");
        regexInputMask.setRegexMask(true);
        regexInputMask.extend(regexMaskTextField);
        column1.addComponent(regexMaskTextField);
        
        /*
         * Mask repeat with greedy false
         */
        TextField greedyTextField = new TextField("Greedy(false):");
        InputMask greedyInputMask = new InputMask("9");
        greedyInputMask.setRepeat(10);
        greedyInputMask.setGreedy(false);
        greedyInputMask.extend(greedyTextField);
        column1.addComponent(greedyTextField);
        
        /*
         * Auto unmask
         */
        TextField autoUnmaskTextField = new TextField("Autounmask(true):");
        InputMask autoUnmaskInputMask = new InputMask("(999) 999-9999");
        autoUnmaskInputMask.setAutoUnmask(true);
        autoUnmaskInputMask.extend(autoUnmaskTextField);
        column1.addComponent(autoUnmaskTextField);
        
        Button getValueButton = new Button("Get Unmasked Value");
        getValueButton.addClickListener(event -> {
        	Notification n = new Notification("Unmasked value: " + autoUnmaskTextField.getValue());
        	n.setDelayMsec(3000);
        	n.show(getPage());
        });
        column1.addComponent(getValueButton);
        
        /*
         * Clear mask on lost focus
         */
        TextField clearOnLostTextField = new TextField("Clear on lost focus(false):");
        InputMask clearOnLostInputMask = new InputMask("99:99:99");
        clearOnLostInputMask.setClearMaskOnLostFocus(false);
        clearOnLostInputMask.extend(clearOnLostTextField);
        column1.addComponent(clearOnLostTextField);
        
        /*
         * Insert mode false
         */
        TextField insertModeTextField = new TextField("Insert mode(false):");
        InputMask insertModeInputMask = new InputMask("99:99:99");
        insertModeInputMask.setInsertMode(false);
        insertModeInputMask.extend(insertModeTextField);
        column1.addComponent(insertModeTextField);
        
        /*
         * clear on incomplete
         */
        TextField clearIncompleteTextField = new TextField("Clear incomplete(true):");
        InputMask clearIncompleteInputMask = new InputMask("99:99:99");
        clearIncompleteInputMask.setClearIncomplete(true);
        clearIncompleteInputMask.extend(clearIncompleteTextField);
        column1.addComponent(clearIncompleteTextField);
        
        /*
         * Currency Alias
         */
        TextField currencyTextField = new TextField("Currency:");
        InputMask currencyInputMask = new InputMask(Alias.CURRENCY);
        currencyInputMask.setPrefix("R$ ");
        currencyInputMask.setGroupSeparator(".");
        currencyInputMask.setRadixPoint(",");
        currencyInputMask.extend(currencyTextField);
        column2.addComponent(currencyTextField);
        
        /*
         * Date Extension
         */
        TextField dateTextField = new TextField("Date extension:");
        InputMask dateInputMask = new InputMask(Alias.DATE);
        dateInputMask.setPlaceholder("__/__/____");
        dateInputMask.extend(dateTextField);
        column2.addComponent(dateTextField);
        
        /*
         * Mask Definitions
         */
        TextField maskDefinitionTextField = new TextField("Mask Definition(basic Year):");
        InputMask definitionInputMask = new InputMask("Y");
        Definition yearDefinition = new Definition("Y", "(19|20)\\d{2}");
        yearDefinition.setCardinality(4);
        yearDefinition.addPreValidator(new PreValidator("[12]", 1));
        yearDefinition.addPreValidator(new PreValidator("(19|20)", 2));
        yearDefinition.addPreValidator(new PreValidator("(19|20)\\d", 3));
        definitionInputMask.addDefinition(yearDefinition);
        definitionInputMask.extend(maskDefinitionTextField);
        column2.addComponent(maskDefinitionTextField);
        
        /*
         * Numeric input
         */
        TextField numericInputTextField = new TextField("Numeric Input:");
        InputMask numericInputMask = new InputMask("€ 999.999.999,99");
        numericInputMask.setNumericInput(true);
        numericInputMask.extend(numericInputTextField);
        column2.addComponent(numericInputTextField);
        
        /*
         * Upper Casing
         */
        TextArea upperCasingTextField = new TextArea("Upper Casing:");
        InputMask upperCasingInputMask = new InputMask("*{*}");
        upperCasingInputMask.setCasing(Casing.UPPER);
        upperCasingInputMask.extend(upperCasingTextField);
        column2.addComponent(upperCasingTextField);
      
        /*
         * Phone Number
         */
        TextField phoneNumberTextField = new TextField("Phone Number:");
        InputMask.addTo(phoneNumberTextField, "(999) 999-9999");
        column2.addComponent(phoneNumberTextField);
        phoneNumberTextField.setValue("1234567890");      
         
        /*
         * Ip Alias
         */
        TextField ipTextField = new TextField("IP Address:");
        InputMask ipInputMask = new InputMask(Alias.IP);
        ipInputMask.extend(ipTextField);
        column2.addComponent(ipTextField);
        
        /*
         * Mask on Combobox
         */
        ComboBox<String> combo = new ComboBox<>("Mask on Combobox:");
        combo.setItems("1-444", "1-667", "2-232", "4-433", "4-431", "1-424", "1-627", "2-332", "4-733", "2-437", "4-124", "2-127", "4-832", "1-933", "4-491");
        InputMask comboInputMask = new InputMask("9-999");
        comboInputMask.setJitMasking(true);
        comboInputMask.extend(combo);
        column2.addComponent(combo);
        
        /*
         * Callbacks
         */
        TextField callbacksTextField = new TextField("Callbacks:");
        InputMask callbacksInputMask = new InputMask("(999) 999-9999");
        callbacksInputMask.addOnCompleteListener(() -> {
        	Notification n = new Notification("Inputmask complete");
        	n.setDelayMsec(3000);
        	n.show(getPage());
        });
        callbacksInputMask.addOnIncompleteListener(() -> {
        	Notification n = new Notification("Inputmask incomplete");
        	n.setDelayMsec(3000);
        	n.show(getPage());
        });
        callbacksInputMask.extend(callbacksTextField);
        column2.addComponent(callbacksTextField);
        setContent(layout);
    }
}
