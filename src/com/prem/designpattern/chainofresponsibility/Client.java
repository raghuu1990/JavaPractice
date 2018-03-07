package com.prem.designpattern.chainofresponsibility;

/**
 * Created by lovebharti on 12/1/17.
 */
public class Client {

  public static void main(String[] args) {
    Request request= new Request(5,4,"multiply");

    Handler addHandler=new AddNumber();
    Handler substractHandler= new SubstractNumber();
    Handler multiplyHandler= new MultiplyNumbers();

    addHandler.setNextHandler(substractHandler);
    substractHandler.setNextHandler(multiplyHandler);


    addHandler.process(request);

  }
}
