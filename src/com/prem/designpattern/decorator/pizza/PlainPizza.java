package com.prem.designpattern.decorator.pizza;

/**
 * Created by lovebharti on 12/1/17.
 */
public class PlainPizza implements Pizza {
  @Override
  public String getDescription() {
    return "Plain Dough";
  }

  @Override
  public double getCost() {
    return 100.0;
  }
}
