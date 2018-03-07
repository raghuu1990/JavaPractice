package com.company.ola;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//Class to save request inFile
public class SaveInFile implements ISaveRequest{
	private volatile int KeyCounter = 0;
	public SaveInFile() {
	}

	public String saveRequest(HttpRequest request){
		System.out.println("Saving Request : inFile ");
		String filename = "filename"+(++KeyCounter);
		ObjectOutput out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.writeObject(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return filename;
	}

	public HttpRequest fetchRequest(String Key){
		System.out.println("Fetching Request from : inFile ");
		ObjectInput in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(Key));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpRequest httpRequest = null;
		try {
			httpRequest = (HttpRequest) in.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpRequest;
	}
}
