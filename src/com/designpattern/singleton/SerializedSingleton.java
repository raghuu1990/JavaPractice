package com.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedSingleton implements Serializable{
	private static final long serialVersionUID = -7604766932017737115L;
	private static SerializedSingleton instance;

	private SerializedSingleton() {}

	public static SerializedSingleton getInstance() {
		if(null == instance) {
			synchronized(SerializedSingleton.class){
				if(null == instance) {
					instance = new SerializedSingleton();
				}
			}
		}
		return instance;
	}
	
	protected Object readResolve() {
	    return getInstance();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
		
		//Serialize object to file 
		 
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.txt"));
		out.writeObject(instanceOne);
		out.close();

		//De-Serialize file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.txt"));
		SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode="+instanceOne.hashCode());
		System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
	}
}

