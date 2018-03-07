package com.java8;

import java.util.Observable;

public class ObservableExample {
    public static void main(String[] args) {
    	System.out.println("Enter Text >");
        EventSource eventSource = new EventSource();

        eventSource.addObserver((Observable obj, Object arg) -> { 
            System.out.println("Received response in observer 1 : " + arg);
        });

        eventSource.addObserver((Observable obj, Object arg) -> { 
        	System.out.println("Received response in observer 2 : " + arg);
        });
        
        new Thread(eventSource).start();
    }
}
