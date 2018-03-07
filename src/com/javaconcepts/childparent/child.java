package com.javaconcepts.childparent;

/*
 * super parent constructor called first 
 * parent reference can hold child object, child reference cann't hold parent object ie : child p = new parent();
 * run time error if patent object casted into child ie : (child) new parent(), but this will work : (child)(superParent)child
 * run time error if child = [(child)parent]
 * 
 * if some method/fields not present in a class than look into parent (public/protected) ->  superParent (public/protected)
 * for child object : error if not exist in any, or not exists in child and exist invisible/private in parent even visible in superParent
 * for parent object created in child class : it cann't access invisible/private method/fields
 * for parent reference child object -> parent variable> superParent variable but child method > parent method> superParent method 
 */

public class child extends parent {
	public int p=10;
	public int a,b,c =10;
	public child(int p) {
		super();
		//this.p = p;
		System.out.println("child constractor with field");
	}

	public child() {
		//super(10);
		System.out.println("child constractor with out fields");
	}

	/*public void method() {
		//super.method();
		//System.out.println("child method with out field : "+ p);
	}
	*/
	public void method(int p) {
		System.out.println("child method with field : "+ p);
	}

	public static void main(String[] args) {
		// (child) (parent) (superParent)
		// Pass
	    // child p = new child(10);
		 parent p = new parent();
		// superParent p = new superParent();

	     
		// Compile time: will ask to cast, if run : Type mismatch: cannot convert from parent to child
		// child p = new parent();
		// child p = new superParent();
		// parent p = new superParent();
		// child p = (parent) new superParent();
		// child p = (parent) new child();
	
		// Fail at run time : parent cannot be cast to child
		// child p = (child) new parent();
		// parent p = (child) new parent();
		
	     
		// Pass
		// child p = (child)(superParent)new child();
	
		
	     
		// Pass
		// parent p = new child();
		// superParent p = new child();
		// superParent p = new parent();

	     
		// parent p = (parent) new child();
		// superParent p = (parent) new child();
		// superParent p = (superParent) new child();
		// superParent p = (superParent) new parent();
		
		 //parent.method();
	     //System.out.println(p.p);
	     
		p.method();
		// p.method(10);
	    // System.out.println(p.p);
	}
}