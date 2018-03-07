package com.company.flipkart.newsfeed;

import java.util.TreeMap;

public class UserBase {
	private static int id = 1;
	TreeMap<String, User>  map;

	public UserBase() {
		this.map = new TreeMap<String, User>();
	}
	
	public void signup(String name) {
		if(map.containsKey(name)) {
			System.out.println("User already exists.");
		}else {
			User user = new User(id++, name); 
			map.put(name, user);
		}
	}
	
	public User login(String name) {
		if(map.containsKey(name)) {
			return map.get(name);
		}
		System.out.println("No user found.");
		return null;
	}
	
	public void follow(User user, String name) {
		if(user!=null && map.containsKey(name)) {
			user.followers.add(name);
		}else {
			System.out.println("No user found to follow");
		}
	}
}