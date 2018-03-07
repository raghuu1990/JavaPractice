package com.prem.designpattern.state.pattern.state;

import com.prem.designpattern.state.pattern.ATMState;
import com.prem.designpattern.state.pattern.AtmMachine;

/**
 * Created by lovebharti on 12/1/17.
 */
public class HasCard implements ATMState {

  private AtmMachine machine;

  public HasCard(AtmMachine machine){
    this.machine=machine;
  }

  @Override
  public void insertCard() {
    System.out.println("Already inserted a card");
  }

  @Override
  public void ejectCard() {
    machine.setCurrentATMState(machine.getNoCard());
    System.out.println("Card is ejected");
  }

  @Override
  public void enterPin(int pin) {
    System.out.println("Please enter Correct pin");
  }

  @Override
  public void requestCash(long amount) {
    if(amount<machine.getCashInMachine()){
      System.out.println("Request amount is not available in ATM");
    }
    else {
      machine.setCashInMachine(machine.getCashInMachine()-amount);
      System.out.println("Please collect your amound"+amount);
    }
  }
}