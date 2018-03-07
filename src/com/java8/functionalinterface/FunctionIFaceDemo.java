package com.java8.functionalinterface;

public class FunctionIFaceDemo {
    public static void main(String[] args) {
        Eatable eatImpl = (name) -> {
            System.out.println("start to eat "+name);
        };
        eatImpl.prepareBeforeEat();
        String foodName="Rajma";
        eatImpl.eat(foodName);
    }
}


@FunctionalInterface //adding annotation provides compile time error check
interface Eatable{
    public void eat(String foodName); //main single method to implement

    //later on multiple method can be added without disturbing existing existing interface implemented classes
    default void prepareBeforeEat(){
        System.out.println("Please wash your Hand");
    }
}

// if implementing class implements two function interface having same default method then it will
// give ambiguity error.