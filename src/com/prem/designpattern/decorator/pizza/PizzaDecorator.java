package com.prem.designpattern.decorator.pizza;

public abstract class PizzaDecorator implements Pizza{
  protected Pizza pizza;

  public PizzaDecorator(Pizza pizza) {
    this.pizza=pizza;
  }

}
