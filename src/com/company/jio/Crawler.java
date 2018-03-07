package com.company.jio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.company.jio.beans.Car;
import com.company.jio.db.CarDB;
import com.company.jio.enums.Attribute;
import com.company.jio.enums.Color;
import com.company.jio.enums.Condition;
import com.company.jio.enums.Make;
import com.company.jio.enums.Product;
import com.company.jio.enums.Type;

public class Crawler {
	private static CarDB carDB;

	public void crawl(Product product) {
		// {BASE_URL}/v1/search/type?q=Nissan
		createSampleData(product);
	}
	
	public List<Car> createSampleData(Product car) {
		if(Product.CAR.equals(car)) {
			List<Car> cars = new ArrayList<Car>();
			for (int i = 0; i < 500; i++) {
				Car randomCar =  new Car(
						"Name_"+(i+1),
						Make.values()[new Random().nextInt(Make.values().length)],
						Condition.values()[new Random().nextInt(Condition.values().length)],
						Type.values()[new Random().nextInt(Type.values().length)],
						Color.values()[new Random().nextInt(Color.values().length)],
						20000+Math.random()*10000
						);
				cars.add(randomCar);
			}
			if(carDB==null) {
				carDB = new CarDB();
			}
			carDB.updateDB(cars);
			return cars;
		}
		return null;
	}
	
	public void process(Product car) {
		if(carDB==null) {
			return;
		}
		carDB.createIndexes();
	}

	public List<Car> getResult(HashMap<Attribute, String> attributes, Product car) {
		List<Car> result = new ArrayList<Car>();
		boolean isFirst = true;
		for(Attribute attribute : attributes.keySet()) {
			if(isFirst) {
				result = carDB.search(attribute, attributes.get(attribute));
				isFirst = false;
			}else if(result!=null && result.size()!=0){
				carDB.searchAndFilter(attribute, attributes.get(attribute), result);
			} else if(result==null && result.size()==0){
				return null;
			}
		}
		return result;
	}
}