package org.vaadin.inputmask.client;

public enum Alias {
	//date aliases
	DATE("date"),
	DATETIME("datetime"),
	DATETIME12("datetime12"),
	SHAMSI("shamsi"),
	//numeric aliases
	NUMERIC("numeric"),
	INTEGER("integer"),
	DECIMAL("decimal"),
	PERCENTAGE("percentage"),
	CURRENCY("currency"),
	//other aliases
	URL("url"),
	IP("ip"),
	MAC("mac"),
	VIN("vin"),
	EMAIL("email");

	private String aliasName;
	
	Alias(String aliasName) {
		this.aliasName = aliasName;
	}
	
	public String getAliasName() {
		return aliasName;
	}
	
	@Override
	public String toString() {
		return aliasName;
	}
}
