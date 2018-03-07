package com.company.jio;

import java.util.HashMap;
import java.util.List;

import com.company.jio.beans.Car;
import com.company.jio.enums.Attribute;
import com.company.jio.enums.Color;
import com.company.jio.enums.Condition;
import com.company.jio.enums.Make;
import com.company.jio.enums.Product;
import com.company.jio.enums.Type;

public class Jio {
	public static void main(String[] args) {
		// Crawls
		Crawler crawler = new Crawler();
		crawler.crawl(Product.CAR);
		
		// process result
		crawler.process(Product.CAR);
		
		// Hit API(s)
		
		HashMap<Attribute, String> attributes = new HashMap<Attribute, String>();
		attributes.put(Attribute.COLOR, Color.RED.toString());
		attributes.put(Attribute.MAKE, Make.MAKE_1.toString());
		attributes.put(Attribute.CONDITION, Condition.AVERAGE.toString());
		attributes.put(Attribute.TYPE, Type.TYPE_1 .toString());
		
		 List<Car> result =  crawler.getResult(attributes, Product.CAR);
		 printResult(result);
	}

	private static void printResult(List<Car> cars) {
		if(cars==null || cars.size()==0) {
			System.out.println("No Result Found");
			return;
		}
		for (Car car : cars) {
			System.out.println(car.toString());
		}
	}
}