package com.company.ola;


public interface ISaveRequest {
	
	//Interface for class which save requests
	
	// Abstract methods
	public String saveRequest(HttpRequest request);
	public HttpRequest fetchRequest(String Key);
}
