package com.company.ola;

public class Savefactory {

	public Savefactory() {
	}

	//Factory to produce respected class to save request
	
	public static ISaveRequest getSavefactory(String SaveType){
		if(SaveType.equalsIgnoreCase("inFile")){
			return new SaveInFile();
		}else if(SaveType.equalsIgnoreCase("inMemory")){
			return new SaveInMemory();
		}
		return null;
	}
}
