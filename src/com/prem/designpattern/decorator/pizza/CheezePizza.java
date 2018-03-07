package com.prem.designpattern.decorator.pizza;

/**
 * Created by lovebharti on 12/1/17.
 */
public class CheezePizza extends PizzaDecorator{

  public CheezePizza(Pizza pizza){
    super(pizza);
  }

  @Override
  public String getDescription() {
    return pizza.getDescription() +", Cheeze";
  }

  @Override
  public double getCost() {
    return pizza.getCost()+ 50;
  }
}