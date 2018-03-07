package com.company.jio.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.company.jio.beans.Car;
import com.company.jio.enums.Attribute;

public class CarDB {
	public static ArrayList<Car> cars;
	
	public static HashMap<String, List<Integer>> colorIndex;
	public static HashMap<String, List<Integer>> conditionIndex;
	public static HashMap<String, List<Integer>> makeIndex;
	public static HashMap<String, List<Integer>> typeIndex;

	public CarDB() {
		cars = new ArrayList<Car>();
	}

	public Car getCar(Integer index) {
		return cars.get(index);
	}

	public void deleteCar(Integer index) {
		cars.remove(index);
		clearIndexes();
		// createIndexes();
	}

	public void clearDB(Integer index) {
		cars = new ArrayList<Car>();
		clearIndexes();
	}

	public void updateDB(List<Car> carList) {
		cars.addAll(carList);
		clearIndexes();
		// createIndexes();
	}
	
	public void clearIndexes(){
		colorIndex = new HashMap<String, List<Integer>>();
		conditionIndex = new HashMap<String, List<Integer>>();
		makeIndex = new HashMap<String, List<Integer>>();
		typeIndex = new HashMap<String, List<Integer>>();
	}

	public void createIndexes(){
		if(cars==null ) {//|| colorIndex ==null || conditionIndex == null || makeIndex == null || typeIndex == null) {
			return;
		}

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			if(colorIndex.containsKey(car.color.toString())) {
				List<Integer> list = colorIndex.get(car.color.toString());
				list.add(i);
				colorIndex.put(car.color.toString(), list);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				colorIndex.put(car.color.toString(), list);
			}
			
			if(conditionIndex.containsKey(car.condition.toString())) {
				List<Integer> list = conditionIndex.get(car.condition.toString());
				list.add(i);
				conditionIndex.put(car.condition.toString(), list);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				conditionIndex.put(car.condition.toString(), list);
			}
			
			if(makeIndex.containsKey(car.make.toString())) {
				List<Integer> list = makeIndex.get(car.make.toString());
				list.add(i);
				makeIndex.put(car.make.toString(), list);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				makeIndex.put(car.make.toString(), list);
			}
			
			if(typeIndex.containsKey(car.type.toString())) {
				List<Integer> list = typeIndex.get(car.type.toString());
				list.add(i);
				typeIndex.put(car.type.toString(), list);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				typeIndex.put(car.type.toString(), list);
			}
		}
	}

	
	public List<Car> searchAndFilter(Attribute attribute, String key, List<Car> result) {
		if(result==null || result.size()==0) {
			return null;
		}
		List<Car> newResult = new ArrayList<Car>();
		if(Attribute.COLOR==attribute) {
			if(colorIndex.containsKey(key)) {
				newResult =  getCarsListFromIds(colorIndex.get(key));
			}
		}else if(Attribute.CONDITION==attribute) {
			if(conditionIndex.containsKey(key)) {
				newResult = getCarsListFromIds(conditionIndex.get(key));
			}
		}else if(Attribute.MAKE==attribute) {
			if(makeIndex.containsKey(key)) {
				newResult = getCarsListFromIds(makeIndex.get(key));
			}
		} else if(Attribute.TYPE==attribute) {
			if(typeIndex.containsKey(key)) {
				newResult = getCarsListFromIds(typeIndex.get(key));
			}
		}
		
		List<Car> finalResult =  findCommonResult(result, newResult);
		result.clear();
		result.addAll(finalResult);
		return result;
	}
	

	private List<Car> findCommonResult(List<Car> result1, List<Car> result2) {
		List<Car> newResult = new ArrayList<Car>();
		for (int i = 0; i < result1.size(); i++) {
			for (int j = 0; j < result2.size(); j++) {
				if(result1.get(i).name.equalsIgnoreCase(result2.get(j).name)) {
					newResult.add(result1.get(i));
				}
			}
		}
		return newResult;
	}

	public List<Car> search(Attribute attribute, String key) {
		if(Attribute.COLOR==attribute) {
			if(colorIndex.containsKey(key)) {
				return getCarsListFromIds(colorIndex.get(key));
			}
		}else if(Attribute.CONDITION==attribute) {
			if(conditionIndex.containsKey(key)) {
				return getCarsListFromIds(conditionIndex.get(key));
			}
		}else if(Attribute.MAKE==attribute) {
			if(makeIndex.containsKey(key)) {
				return getCarsListFromIds(makeIndex.get(key));
			}
		} else if(Attribute.TYPE==attribute) {
			if(typeIndex.containsKey(key)) {
				return getCarsListFromIds(typeIndex.get(key));
			}
		}
		return null;
	}
	
	public List<Car> getCarsListFromIds(List<Integer> ids){
		List<Car> result = new ArrayList<Car>();
		for (int i : ids) {
			result.add(getCar(i));
		}
		return result;
	}
}