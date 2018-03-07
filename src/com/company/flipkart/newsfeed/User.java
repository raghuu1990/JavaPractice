package com.company.flipkart.newsfeed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	int id;
	String name;
	Date lastLogin;
	List<String> followers;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
		this.followers = new ArrayList<String>();
	}
}