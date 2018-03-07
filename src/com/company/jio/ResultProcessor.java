package com.company.jio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.company.jio.beans.Car;
import com.company.jio.db.CarDB;
import com.company.jio.enums.Attribute;
import com.company.jio.enums.Product;

public class ResultProcessor {
	private static CarDB carDB;

	public static void process(Product car) {
		if(carDB==null) {
			return;
		}
		carDB.createIndexes();
	}

	public static List<Car> getResult(HashMap<Attribute, String> attributes, Product car) {
		List<Car> result = new ArrayList<Car>();
		boolean isFirst = true;
		for(Attribute attribute : attributes.keySet()) {
			if(isFirst) {
				result = carDB.search(attribute, attributes.get(attribute));
				isFirst = false;
			}else if(result!=null && result.size()!=0){
				carDB.searchAndFilter(attribute, attributes.get(attribute), result);
			}
		}
		return result;
	}
}
