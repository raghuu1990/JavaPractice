package com.designpattern.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingleton {
	private static ReflectionSingleton instance;
	private ReflectionSingleton() {}
	
	public static ReflectionSingleton getInstance() {
		if(null == instance) {
			synchronized(ReflectionSingleton.class){
				if(null == instance) {
					instance = new ReflectionSingleton();
		}}}
		return instance;
	}

	public static void main(String[] args) {
		ReflectionSingleton instanceOne = ReflectionSingleton.getInstance();
		ReflectionSingleton instanceTwo = null;
        try {
            Constructor<?>[] constructors = ReflectionSingleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (ReflectionSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}