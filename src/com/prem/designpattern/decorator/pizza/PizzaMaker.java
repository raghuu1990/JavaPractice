package com.prem.designpattern.decorator.pizza;

public class PizzaMaker {

  public static void main(String[] args) {
    Pizza pizza= new SaucePizza(new CheezePizza(new PlainPizza()));
    System.out.println(pizza.getDescription());
    System.out.println(pizza.getCost());
  }


}
