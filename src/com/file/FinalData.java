package com.file;

import com.utils.StringUtils;

import java.util.Comparator;

public class FinalData implements Comparator{

	private String domesticCity;
	private String galCity;
	private String country;
	private String countryCode;
	private String state;
	private String galCityCode;

	@Override
	public int compare(Object o1, Object o2) {
		if(StringUtils.isNotEmpty(((FinalData) o1).getDomesticCity()) && StringUtils.isNotEmpty(((FinalData) o2).getDomesticCity())){
			return ((FinalData) o1).getDomesticCity().compareTo(((FinalData) o2).getDomesticCity());
		}else{
			return ((FinalData) o1).getGalCity().compareTo(((FinalData) o2).getGalCity());
		}
	}

	public FinalData() {
	}

	public FinalData(String domesticCity, String galCity, String country, String countryCode, String state,
			String galCityCode) {
		super();
		this.domesticCity = domesticCity;
		this.galCity = galCity;
		this.country = country;
		this.countryCode = countryCode;
		this.state = state;
		this.galCityCode = galCityCode;
	}

	@Override
	public String toString() {
		return "FinalData [domesticCity=" + domesticCity + ", galCity=" + galCity + ", country=" + country
				+ ", countryCode=" + countryCode + ", state=" + state + ", galCityCode=" + galCityCode + "]";
	}

	public String getDomesticCity() {
		return domesticCity;
	}

	public void setDomesticCity(String domesticCity) {
		this.domesticCity = domesticCity;
	}

	public String getGalCity() {
		return galCity;
	}

	public void setGalCity(String galCity) {
		this.galCity = galCity;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGalCityCode() {
		return galCityCode;
	}

	public void setGalCityCode(String galCityCode) {
		this.galCityCode = galCityCode;
	}
}
