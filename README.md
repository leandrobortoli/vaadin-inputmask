# InputMask Add-on for Vaadin 8 and Vaadin 7

InputMask its a wrapper for the Input Mask javascript plugin that allows the developer to mask Vaddin components with ease. Can be used on TextField, TextArea, InputDate, Combobox, and pretty much any Vaadin component that has a text input.

## Usage
- Create an `InputMask` and pass the mask or mask alias as parameter
- Call `extend` and pass the Vaadin component you want to add the mask.
  - The component can be any Vaadin component, as long it works with a text input, for example, TextField, TextArea, DateField or ComboBox.
- Optionally you can use it with the static method `addTo` passing the component and the mask as parameters.


### Default masking definitions
- `9` : numeric
- `a` : alphabetical
- `*` : alphanumeric

### Examples

```Java
        
        /*
         * Time
         */
        TextField timeTextField = new TextField("Time:");
        InputMask.addTo(timeTextField, "99:99:99");
        layout.addComponent(timeTextField);
        
        /*
         * Currency Alias
         */
        TextField currencyTextField = new TextField("Currency:");
        InputMask currencyInputMask = new InputMask(Alias.CURRENCY);
        currencyInputMask.setPrefix("R$ ");
        currencyInputMask.setGroupSeparator(".");
        currencyInputMask.setRadixPoint(",");
        currencyInputMask.extend(currencyTextField);
        layout.addComponent(currencyTextField)
        
        /*
         * Date Extension
         */
        TextField dateTextField = new TextField("Date extension:");
        InputMask dateInputMask = new InputMask(Alias.DATE);
        dateInputMask.setPlaceholder("__/__/____");
        dateInputMask.extend(dateTextField);
        layout.addComponent(dateTextField);
        
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
        layout.addComponent(maskDefinitionTextField);
        
        /*
         * Numeric input
         */
        TextField numericInputTextField = new TextField("Numeric Input:");
        InputMask numericInputMask = new InputMask("€ 999.999.999,99");
        numericInputMask.setNumericInput(true);
        numericInputMask.extend(numericInputTextField);
        layout.addComponent(numericInputTextField);
        
        /*
         * Mask on Combobox
         */
        ComboBox<String> combo = new ComboBox<>("Mask on Combobox:");
        combo.setItems("1-444", "1-667", "2-232", "4-433", "4-431", "1-424", "1-627", "2-332", "4-733", "2-437", "4-124", "2-127", "4-832", "1-933", "4-491");
        InputMask comboInputMask = new InputMask("9-999");
        comboInputMask.setJitMasking(true);
        comboInputMask.extend(combo);
        layout.addComponent(combo);
```

For more information on how to use this component, you can check the demo and also visit the javascript plugin page: 
https://github.com/RobinHerbots/Inputmask

## Building and running demo

git clone https://github.com/leandrobortoli/vaadin-inputmask.git
mvn clean install
cd demo
mvn jetty:run

To see the demo, navigate to http://localhost:8080/vaadin-inputmask-demo/

## Development with Eclipse IDE

For further development of this add-on, the following tool-chain is recommended:
- Eclipse IDE
- m2e wtp plug-in (install it from Eclipse Marketplace)
- Vaadin Eclipse plug-in (install it from Eclipse Marketplace)
- JRebel Eclipse plug-in (install it from Eclipse Marketplace)
- Chrome browser

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

### Debugging server-side

If you have not already compiled the widgetset, do it now by running vaadin:install Maven target for vaadin-inputmask-root project.

If you have a JRebel license, it makes on the fly code changes faster. Just add JRebel nature to your vaadin-inputmask-demo project by clicking project with right mouse button and choosing JRebel > Add JRebel Nature

To debug project and make code modifications on the fly in the server-side, right-click the vaadin-inputmask-demo project and choose Debug As > Debug on Server. Navigate to http://localhost:8080/vaadin-inputmask-demo/ to see the application.

### Debugging client-side

Debugging client side code in the vaadin-inputmask-demo project:
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application or by adding ?superdevmode to the URL
  - You can access Java-sources and set breakpoints inside Chrome if you enable source maps from inspector settings.
 
## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

InputMask is written by Leandro José de Bortoli(leandrojbortoli@gmail.com)
