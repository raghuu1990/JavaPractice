package com.prem.designpattern.chainofresponsibility;

/**
 * Created by lovebharti on 12/1/17.
 */
public interface Handler {

  public void setNextHandler(Handler handler);

  public void process(Request request);
}
