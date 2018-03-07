package com.prem.designpattern.state.pattern;

/**
 * Created by lovebharti on 12/1/17.
 */
public interface ATMState {

  public void insertCard();
  public void ejectCard();
  public void enterPin(int pin);
  public void requestCash(long amount);

}
