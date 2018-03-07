package com.prem.designpattern.state.pattern;

import com.prem.designpattern.state.pattern.state.HasCard;
import com.prem.designpattern.state.pattern.state.HasPin;
import com.prem.designpattern.state.pattern.state.NoCard;
import com.prem.designpattern.state.pattern.state.NoCash;

public class AtmMachine{

  private ATMState currentATMState;

  private HasCard hasCard;
  private NoCard noCard;
  private HasPin hasPin;
  private NoCash noCash;

  long cashInMachine = 2000;

  public boolean isCorrectPinEntered() {
    return correctPinEntered;
  }

  public void setCorrectPinEntered(boolean correctPinEntered) {
    this.correctPinEntered = correctPinEntered;
  }

  public long getCashInMachine() {
    return cashInMachine;
  }

  public void setCashInMachine(long cashInMachine) {
    this.cashInMachine = cashInMachine;
  }

  boolean correctPinEntered= false;

  public AtmMachine(){
    hasCard = new HasCard(this);
    hasPin = new HasPin(this);
    noCash = new NoCash(this);
    noCard = new NoCard(this);

    currentATMState=noCard;

    if(cashInMachine<0){
      currentATMState=noCash;
    }
  }

  public ATMState getCurrentATMState() {
    return currentATMState;
  }

  public void setCurrentATMState(ATMState currentATMState) {
    this.currentATMState = currentATMState;
  }

  public void insertCard() {
    currentATMState.insertCard();
  }

  public void ejectCard() {
    currentATMState.ejectCard();
  }

  public void enterPin(int pin) {
    currentATMState.enterPin(pin);
  }

  public void requestCash(long amount) {
    currentATMState.requestCash(amount);
  }

  public HasCard getHasCard() {
    return hasCard;
  }

  public void setHasCard(HasCard hasCard) {
    this.hasCard = hasCard;
  }

  public NoCard getNoCard() {
    return noCard;
  }

  public void setNoCard(NoCard noCard) {
    this.noCard = noCard;
  }

  public HasPin getHasPin() {
    return hasPin;
  }

  public void setHasPin(HasPin hasPin) {
    this.hasPin = hasPin;
  }

  public NoCash getNoCash() {
    return noCash;
  }

  public void setNoCash(NoCash noCash) {
    this.noCash = noCash;
  }
}
