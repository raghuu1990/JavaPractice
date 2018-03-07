package com.prem.designpattern.state.pattern.state;

import com.prem.designpattern.state.pattern.ATMState;
import com.prem.designpattern.state.pattern.AtmMachine;

/**
 * Created by lovebharti on 12/1/17.
 */
public class HasPin implements ATMState {

  private AtmMachine machine;

  public HasPin(AtmMachine machine){
    this.machine=machine;
  }

  @Override
  public void insertCard() {
    System.out.println("You already inserted a card.");
  }

  @Override
  public void ejectCard() {
    System.out.println("Your card is ejected");
    machine.setCurrentATMState(machine.getNoCard());
  }

  @Override
  public void enterPin(int pin) {
    if(pin==1234){
      System.out.println("Password is correct");
      System.out.println("Now you can get cash.");
      machine.setCurrentATMState(machine.getHasPin());
    }

  }

  @Override
  public void requestCash(long amount) {

  }
}
