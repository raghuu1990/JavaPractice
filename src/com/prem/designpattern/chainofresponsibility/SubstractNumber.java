package com.prem.designpattern.chainofresponsibility;

/**
 * Created by lovebharti on 12/1/17.
 */
public class SubstractNumber implements Handler {
  private Handler nextHandler;

  @Override
  public void setNextHandler(Handler handler) {
    this.nextHandler=handler;
  }

  @Override
  public void process(Request request) {
    if(request.getOperation().equals("substract")){
      System.out.println(request.getNum1()+" - "+request.getNum2()+" = "+
          (request.getNum1()-request.getNum2()));
    }
    else {
      nextHandler.process(request);
    }
  }
}
