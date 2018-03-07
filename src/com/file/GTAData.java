package com.file;

public class GTAData {

	private String cityCode;
	private String synonym;
	private String name;
	private String countryCode;
	private String stateCode;
	private String metroCode;
	private String associatedAirports;
	private String hostService;
	private String commercialService;

	public GTAData() {
	}
	
	public GTAData(String cityCode, String synonym, String name, String countryCode, String stateCode, String metroCode,
			String associatedAirports, String hostService, String commercialService) {
		super();
		this.cityCode = cityCode.replace("\"", "");
		this.synonym = synonym.replace("\"", "");
		this.name = name.replace("\"", "");
		this.countryCode = countryCode.replace("\"", "");
		this.stateCode = stateCode.replace("\"", "");
		this.metroCode = metroCode.replace("\"", "");
		this.associatedAirports = associatedAirports.replace("\"", "");
		this.hostService = hostService.replace("\"", "");
		this.commercialService = commercialService.replace("\"", "");
	}

	@Override
	public String toString() {
		return "GTAData [cityCode=" + cityCode + ", synonym=" + synonym + ", name=" + name + ", countryCode="
				+ countryCode + ", stateCode=" + stateCode + ", metroCode=" + metroCode + ", associatedAirports="
				+ associatedAirports + ", hostService=" + hostService + ", commercialService=" + commercialService
				+ "]";
	}
	
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getSynonym() {
		return synonym;
	}

	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMetroCode() {
		return metroCode;
	}

	public void setMetroCode(String metroCode) {
		this.metroCode = metroCode;
	}

	public String getAssociatedAirports() {
		return associatedAirports;
	}

	public void setAssociatedAirports(String associatedAirports) {
		this.associatedAirports = associatedAirports;
	}

	public String getHostService() {
		return hostService;
	}

	public void setHostService(String hostService) {
		this.hostService = hostService;
	}

	public String getCommercialService() {
		return commercialService;
	}

	public void setCommercialService(String commercialService) {
		this.commercialService = commercialService;
	}

}
