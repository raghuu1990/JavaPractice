package com.file;

public class DomesticData {

	private String displayName;
	private String type;
	private String sourceID;
	private String state;
	private String country;
	private String city;
	private String supplier;
	private String countryCode;
	private String stateCode;
	private boolean isDomestic;
	private boolean isDuplicate;

	public DomesticData() {
	}

	public DomesticData(String displayName, String type, String sourceID, String state, String country, String city,
			String supplier, String countryCode, String stateCode, Boolean isDomestic) {
		super();
		this.displayName = displayName;
		this.type = type;
		this.sourceID = sourceID;
		this.state = state;
		this.country = country;
		this.city = city;
		this.supplier = supplier;
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.isDomestic = isDomestic;
	}

	@Override
	public String toString() {
		return "DomesticData [displayName=" + displayName + ", type=" + type + ", sourceID=" + sourceID + ", state="
				+ state + ", country=" + country + ", city=" + city + ", supplier=" + supplier + ", countryCode="
				+ countryCode + ", stateCode=" + stateCode + ", isDomestic=" + isDomestic + "]";
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public boolean isDomestic() {
		return isDomestic;
	}

	public void setDomestic(boolean isDomestic) {
		this.isDomestic = isDomestic;
	}

	public boolean isDuplicate() {
		return isDuplicate;
	}

	public void setDuplicate(boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}
}
